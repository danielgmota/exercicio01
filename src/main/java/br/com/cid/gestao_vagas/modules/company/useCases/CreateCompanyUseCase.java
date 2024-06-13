package br.com.cid.gestao_vagas.modules.company.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cid.gestao_vagas.exceptions.UserFoundExecption;
import br.com.cid.gestao_vagas.modules.company.CompanyEntity;
import br.com.cid.gestao_vagas.modules.company.repository.CompanyRepository;

@Service
public class CreateCompanyUseCase {

    @Autowired
    private CompanyRepository companyRepository;
    

    public CompanyEntity execute(CompanyEntity companyEntity){
        this.companyRepository
            .findByUsernameOrEmail(companyEntity.getUsername() , companyEntity.getEmail())
            .ifPresent(company ->{
                throw new UserFoundExecption("Essa cia já existe");
            });
        return this.companyRepository.save(companyEntity);
    }
}
