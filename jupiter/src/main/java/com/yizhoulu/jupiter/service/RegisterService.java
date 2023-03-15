package com.yizhoulu.jupiter.service;

import com.yizhoulu.jupiter.dao.RegisterDao;
import com.yizhoulu.jupiter.entity.db.User;
import com.yizhoulu.jupiter.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class RegisterService {

    @Autowired
    private RegisterDao registerDao;

    public boolean register(User user) throws IOException {
        // encrypt the password and return
        user.setPassword(Util.encryptPassword(user.getUserId(), user.getPassword()));
        return registerDao.register(user);
    }
}
