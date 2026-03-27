package com.cveradar.cveradar.services;

import com.cveradar.cveradar.entities.Cve;
import com.cveradar.cveradar.entities.Software;
import com.cveradar.cveradar.repositories.CveRepository;
import com.cveradar.cveradar.utils.exceptions.CveNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CveService {
    private final CveRepository cveRepository;

    @Autowired
    public CveService(CveRepository cveRepository){
        this.cveRepository = cveRepository;
    }

    public Cve buscarPorCveId(String cveId){
        return cveRepository.findCveByCveId(cveId).orElseThrow(() -> new CveNaoEncontradoException(cveId));
    }

    public void salvarCve(Cve cve){
        cveRepository.save(cve);
    }

    public List<Cve> listarPorSoftware(Software software){
        return cveRepository.findBySoftware(software);
    }
}
