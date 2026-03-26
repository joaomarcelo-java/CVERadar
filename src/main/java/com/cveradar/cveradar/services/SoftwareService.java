package com.cveradar.cveradar.services;


import com.cveradar.cveradar.repositories.SoftwareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SoftwareService {

    private final SoftwareRepository softwareRepository;

    @Autowired
    public SoftwareService(SoftwareRepository softwareRepository){
        this.softwareRepository = softwareRepository;
    }

}
