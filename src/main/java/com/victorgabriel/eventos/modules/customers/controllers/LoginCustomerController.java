package com.victorgabriel.eventos.modules.customers.controllers;

import com.victorgabriel.eventos.modules.customers.dto.JWTToken;
import com.victorgabriel.eventos.modules.customers.dto.LoginDTO;
import com.victorgabriel.eventos.modules.customers.entities.Customer;
import com.victorgabriel.eventos.modules.customers.repositories.ICustomerRepository;
import com.victorgabriel.eventos.shared.exceptions.CustomException;
import com.victorgabriel.eventos.shared.security.PasswordUtils;
import com.victorgabriel.eventos.shared.security.TokenConfig;
import com.victorgabriel.eventos.shared.security.TokenInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/customers")
public class LoginCustomerController {

    @Autowired
    private ICustomerRepository customerRepository;

    @PostMapping("/login")
    public JWTToken login(@RequestBody LoginDTO loginDTO) {
        //verificar se existe email no customer
        Customer customerExists = this.customerRepository.findByEmail(loginDTO.getEmail());
        if(customerExists == null) throw new CustomException("Email/password incorrect", HttpStatus.UNAUTHORIZED);

        // se existir verificar a senha
        boolean passwordEquals = PasswordUtils.matches(loginDTO.getPassword(), customerExists.getPassword());
        if(!passwordEquals) throw new CustomException("Email/password incorrect", HttpStatus.UNAUTHORIZED);

        // se tudo tiver ok Gerar o Token
        var SECONDS = 1000;
        var MINUTES = 60 * SECONDS;
        var expiresIn = new Date(System.currentTimeMillis() + MINUTES);
        var token = TokenConfig.encode(new TokenInfo(loginDTO.getEmail(), expiresIn));

        return token;
    }
}
