package com.bridgelabz.employeepayrollapp;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BCryptTest {
    @Test
    public void encryptPassword(){
        String rawPassword = "Avani@234";
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodePassword = bCryptPasswordEncoder.encode(rawPassword);
        System.out.println(encodePassword);
        boolean ans =  bCryptPasswordEncoder.matches(rawPassword,encodePassword);
        assertTrue(ans);
    }
}
