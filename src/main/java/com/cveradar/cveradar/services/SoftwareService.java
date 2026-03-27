package com.cveradar.cveradar.services;


import com.cveradar.cveradar.entities.Software;
import com.cveradar.cveradar.repositories.SoftwareRepository;
import com.cveradar.cveradar.utils.exceptions.SoftwareNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SoftwareService {

    private final SoftwareRepository softwareRepository;

    @Autowired
    public SoftwareService(SoftwareRepository softwareRepository){
        this.softwareRepository = softwareRepository;
    }

    public List<Software> listarTodoss(){
        return softwareRepository.findAll();
    }
    public Software buscarPorNome(String nome){return softwareRepository.findByNome(nome).orElseThrow(() -> new SoftwareNaoEncontradoException(nome));}

}
