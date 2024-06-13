package br.com.cid.gestao_vagas.modules.jobs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cid.gestao_vagas.modules.jobs.JobEntity;
import br.com.cid.gestao_vagas.modules.jobs.useCases.CreateJobUseCase;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/job")
public class JobController {
    
    @Autowired
    private CreateJobUseCase createJobUseCase;

    @PostMapping
    public ResponseEntity<Object> create(@Valid @RequestBody JobEntity jobEntity){
        try {
            var result = this.createJobUseCase.execute(jobEntity);
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
