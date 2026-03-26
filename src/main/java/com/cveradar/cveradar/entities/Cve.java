package com.cveradar.cveradar.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "cves")
public class Cve {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "cve_id")
    private String cveId;
    @Column
    private String severidade;
    @Column
    private String descricao;
    @Column(name = "exploitability_score")
    private double exploitabilityScore;
    @Column(name = "impact_score")
    private double impactScore;
    @Column(name = "patch_disponivel")
    private boolean patchDisponivel;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "software_id")
    private Software software;
}
