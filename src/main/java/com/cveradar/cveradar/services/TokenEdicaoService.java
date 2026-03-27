package com.cveradar.cveradar.services;

import com.cveradar.cveradar.entities.TokenEdicao;
import com.cveradar.cveradar.entities.Usuario;
import com.cveradar.cveradar.repositories.TokenEdicaoRepository;
import com.cveradar.cveradar.utils.exceptions.TokenInvalidoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class TokenEdicaoService {
    private final TokenEdicaoRepository tokenEdicaoRepository;
    @Autowired
    public TokenEdicaoService(TokenEdicaoRepository tokenEdicaoRepository){
        this.tokenEdicaoRepository = tokenEdicaoRepository;
    }

    public TokenEdicao gerarToken(Usuario usuario) {
        List<TokenEdicao> tokensUsuario = tokenEdicaoRepository.findByUsuario(usuario);
        for (TokenEdicao t : tokensUsuario) {
            if (t.getAtivo() && t.getExpiraEm().isAfter(LocalDateTime.now())) {
                return t;
            }
        }

        TokenEdicao novoToken = new TokenEdicao();
        novoToken.setToken(UUID.randomUUID());
        novoToken.setUsuario(usuario);
        novoToken.setAtivo(true);
        novoToken.setExpiraEm(LocalDateTime.now().plusMinutes(30));
        return novoToken;
    }
    public Usuario validarToken(UUID token){
        TokenEdicao tokenBanco = tokenEdicaoRepository.findByToken(token).orElseThrow(() ->  new TokenInvalidoException(token));
        if(tokenBanco.getAtivo() && LocalDateTime.now().isBefore(tokenBanco.getExpiraEm())){
            tokenBanco.setAtivo(false);
            tokenEdicaoRepository.save(tokenBanco);
            return tokenBanco.getUsuario();
        }else{
            throw new TokenInvalidoException(token);
        }
    }
}
