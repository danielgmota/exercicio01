package br.com.cid.gestao_vagas.modules.jobs.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cid.gestao_vagas.modules.jobs.JobEntity;

public interface JobRepository extends JpaRepository<JobEntity, UUID> {
    Optional<JobEntity> findByName(String name); 
}
