package com.omnirio.catalog.app.utils;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.stereotype.Component;

@Component
public class SecurityUtil {

    private final StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();

    public String encrypt(String privateData) {
        return passwordEncryptor.encryptPassword(privateData);
    }

    public boolean compareWithEncryptedData(String plainData, String encryptedData) {
        return passwordEncryptor.checkPassword(plainData, encryptedData);
    }
}
