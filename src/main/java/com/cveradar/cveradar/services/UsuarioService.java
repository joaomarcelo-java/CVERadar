package com.cveradar.cveradar.services;

import com.cveradar.cveradar.entities.Software;
import com.cveradar.cveradar.entities.Usuario;
import com.cveradar.cveradar.repositories.UsuarioRepository;
import com.cveradar.cveradar.utils.exceptions.EmailJaCadastradoException;
import com.cveradar.cveradar.utils.exceptions.EmailNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public void cadastrarUsuario(String email){
        if(usuarioRepository.findByEmail(email).isEmpty())
        {
            Usuario usuarioCadastrado = new Usuario();
            usuarioCadastrado.setEmail(email);
            usuarioRepository.save(usuarioCadastrado);
        }
        else
        {
            throw new EmailJaCadastradoException(email);
        }
    }
    public Usuario buscarPorEmail(String email){
        return usuarioRepository.findByEmail(email).orElseThrow(() -> new EmailNaoEncontradoException(email));
    }
    public List<Software> getSoftwaresUsuario(Usuario usuario){
        return usuario.getListaDeSoftwares();
    }
    public void updateSoftwaresUsuario(Usuario usuario, List<Software> softwares){
        if(usuarioRepository.findByEmail(usuario.getEmail()).isEmpty()){
            throw new EmailNaoEncontradoException(usuario.getEmail());
        }
        else
        {
            usuario.setListaDeSoftwares(softwares);
            usuarioRepository.save(usuario);
        }
    }
    public void descadastrarUsuario(Usuario usuario){
        if(usuarioRepository.findByEmail(usuario.getEmail()).isEmpty()){
            throw new EmailNaoEncontradoException(usuario.getEmail());
        }
        else
        {
            usuarioRepository.delete(usuario);
        }
    }
}
