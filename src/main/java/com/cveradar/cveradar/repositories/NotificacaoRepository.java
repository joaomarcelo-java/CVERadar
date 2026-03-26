package com.cveradar.cveradar.repositories;

import com.cveradar.cveradar.entities.Cve;
import com.cveradar.cveradar.entities.Notificacao;
import com.cveradar.cveradar.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface NotificacaoRepository extends JpaRepository<Notificacao, UUID> {
Optional<Notificacao> findByCveAndUsuario(Cve cve, Usuario usuario);

}
