package com.cveradar.cveradar.repositories;

import com.cveradar.cveradar.entities.Software;
import com.cveradar.cveradar.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
    Optional<Usuario> findByEmail(String email);
    List<Usuario> findByListaDeSoftwares(Software software);
}
