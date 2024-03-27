package com.sda.TravelAgency.utility;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Encoder {
    public static void main(String[] args) {
        PasswordEncoder passEncoder = new BCryptPasswordEncoder();
        System.out.println(passEncoder.encode("@Admin111"));
    }
}

