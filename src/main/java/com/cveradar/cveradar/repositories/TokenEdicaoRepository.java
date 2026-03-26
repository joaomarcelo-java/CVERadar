package com.cveradar.cveradar.repositories;

import com.cveradar.cveradar.entities.TokenEdicao;
import com.cveradar.cveradar.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TokenEdicaoRepository extends JpaRepository<TokenEdicao, UUID> {
    Optional<TokenEdicao> findByToken(UUID token);
    List<TokenEdicao> findByUsuario(Usuario usuario);
}
