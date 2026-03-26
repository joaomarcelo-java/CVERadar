package com.cveradar.cveradar.repositories;

import com.cveradar.cveradar.entities.Cve;
import com.cveradar.cveradar.entities.Software;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CveRepository extends JpaRepository<Cve, UUID> {
    Optional<Cve> findCveByCveId(String cveId);
    List<Cve> findBySoftware(Software software);
}
