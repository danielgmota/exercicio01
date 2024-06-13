package br.com.cid.gestao_vagas.modules.candidate.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cid.gestao_vagas.exceptions.UserFoundExecption;
import br.com.cid.gestao_vagas.modules.candidate.CandidateEntity;
import br.com.cid.gestao_vagas.modules.candidate.repositorys.CandidateRepository;

@Service
public class CreateCandidateUseCase {

    //ou coloca autowired ou usa construtor nao pode deixar em branco
    @Autowired
    private CandidateRepository candidateRepository;
    
    public CandidateEntity execute(CandidateEntity candidateEntity){
        this.candidateRepository
            .findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
            .ifPresent(user ->{
                throw new UserFoundExecption("Usuário já existe");
            });
        return this.candidateRepository.save(candidateEntity);
    }
}
