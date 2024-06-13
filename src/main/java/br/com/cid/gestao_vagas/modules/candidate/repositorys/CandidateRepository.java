package br.com.cid.gestao_vagas.modules.candidate.repositorys;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cid.gestao_vagas.modules.candidate.CandidateEntity;
import java.util.Optional;


public interface CandidateRepository extends JpaRepository< CandidateEntity, UUID> {
    Optional<CandidateEntity> findByUsernameOrEmail(String username, String email);
}
