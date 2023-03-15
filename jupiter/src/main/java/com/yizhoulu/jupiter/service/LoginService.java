package com.yizhoulu.jupiter.service;

import com.yizhoulu.jupiter.dao.LoginDao;
import com.yizhoulu.jupiter.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class LoginService {

    @Autowired
    private LoginDao loginDao;

    public String verifyLogin(String userId, String password) throws IOException {
        // encrypt the password user entered and compare to the encrypted password we have
        password = Util.encryptPassword(userId, password);
        return loginDao.verifyLogin(userId, password);
    }
}
