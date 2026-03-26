package com.cveradar.cveradar.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Entity
@Data
@Table(name = "notificacoes")
public class Notificacao {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private LocalDateTime enviadoEm;
    @Column
    private boolean sucesso;

    @ManyToOne
    @JoinColumn(name = "cve_id")
    private Cve cve;
    @ManyToOne()
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
