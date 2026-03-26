package com.cveradar.cveradar.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "softwares")
public class Software {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column
    public String nome;
    @Column(name = "cpe_nome")
    public String cpeNome;
    @ManyToMany(mappedBy = "listaDeSoftwares")
    private List<Usuario> usuarios;

    @OneToMany(mappedBy = "software")
    private List<Cve> cves;
}
