package br.com.cid.gestao_vagas.modules.company;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity(name = "company")
public class CompanyEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    @Pattern(regexp = "\\S+", message = "O campo [username] não deve ter espaço")
    private String username;

    @NotBlank
    private String name;

    @Email(message = "insira um [email] válido")
    private String email;
    
    @Length(min = 10, max = 30, message = "O password deve ter entre 10 e 30 caracteres")
    private String password;
    
    @URL(message = "A URL do site precisa ser válida")
    private String website;
    
    private String description;
    
    @CreationTimestamp
    private LocalDateTime createdAt;
    
}
