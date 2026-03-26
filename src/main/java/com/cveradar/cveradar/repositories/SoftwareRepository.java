package com.cveradar.cveradar.repositories;

import com.cveradar.cveradar.entities.Software;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SoftwareRepository extends JpaRepository<Software, UUID>{
    Optional<Software> findByNome(String nome);
}