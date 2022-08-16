package com.bridgelabz.employeepayrollapp.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import javax.sql.DataSource;

@Configuration
public class PasswordEncryption{
    @Bean
    public BCryptPasswordEncoder getPasswordEncoded(){
        return new BCryptPasswordEncoder();
    }
}


