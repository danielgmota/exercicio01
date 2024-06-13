package br.com.cid.gestao_vagas.modules.jobs.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cid.gestao_vagas.exceptions.UserFoundExecption;
import br.com.cid.gestao_vagas.modules.jobs.JobEntity;
import br.com.cid.gestao_vagas.modules.jobs.repository.JobRepository;

@Service
public class CreateJobUseCase {
    
    @Autowired
    private JobRepository jobRepository;

    public JobEntity execute(JobEntity jobEntity){
        this.jobRepository
        .findByName(jobEntity.getName()) //AJUSTAR ISSO AQUI
        .ifPresent(job ->{
            throw new UserFoundExecption("Essa vaga já existe");
        });
        return this.jobRepository.save(jobEntity);
    }
}
