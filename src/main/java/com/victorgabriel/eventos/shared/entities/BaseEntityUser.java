package com.victorgabriel.eventos.shared.entities;

import com.victorgabriel.eventos.shared.exceptions.CustomException;
import com.victorgabriel.eventos.shared.security.PasswordUtils;
import com.victorgabriel.eventos.shared.validations.ValidationUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseEntityUser {

    /*
    * Com o MappedSuperClass toda classe qu extender BaseEntityUser alem de ter
    * ela como superclasse ainda vai ter como herança as suas anotations
    * Ou seja, ela vai Receber a anotation @Id, exclarecendo para a JPA
    * que a classe filha tambem tem uma primary key*/
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String email;
    private String password;

    public void setEmail(String email) {
        if(!ValidationUtils.validateEmail(email)) throw new CustomException("Email is Invalid", HttpStatus.UNPROCESSABLE_ENTITY);
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = PasswordUtils.encode(password);  // gerando uma senha criptografada
    }
}
