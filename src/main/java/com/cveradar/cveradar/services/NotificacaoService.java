package com.cveradar.cveradar.services;

import com.cveradar.cveradar.entities.Cve;
import com.cveradar.cveradar.entities.Notificacao;
import com.cveradar.cveradar.entities.Usuario;
import com.cveradar.cveradar.repositories.NotificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificacaoService {
    private final NotificacaoRepository notificacaoRepository;
    @Autowired
    public NotificacaoService(NotificacaoRepository notificacaoRepository){
        this.notificacaoRepository = notificacaoRepository;
    }
    public boolean jaNotificado(Usuario usuario, Cve cve){
        return notificacaoRepository.findByCveAndUsuario(cve, usuario).isPresent();
    }
    public void registrarNotificacao(Usuario usuario, Cve cve, boolean sucesso){
        Notificacao novaNotificacao = new Notificacao();
        novaNotificacao.setUsuario(usuario);
        novaNotificacao.setCve(cve);
        novaNotificacao.setSucesso(sucesso);
        novaNotificacao.setEnviadoEm(LocalDateTime.now());
        notificacaoRepository.save(novaNotificacao);
    }
}
