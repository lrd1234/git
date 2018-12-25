package com.itcast.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderUtils {
    private static BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
    public static String encodePassword(String password){
        return bCryptPasswordEncoder.encode(password);
    }

    public static void main(String[] args) {
        String password="1";
        String pwd = encodePassword(password);
       //$2a$10$0u1RpZ.OEwhpD8CkAFrw.uBI12SQqyhFHmoNjNMtFW7NHtjRTWuCO 明文 ‘1’
        System.out.print(pwd);
        System.out.println(bCryptPasswordEncoder.matches(password, pwd));


    }
}
