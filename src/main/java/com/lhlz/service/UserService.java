package com.lhlz.service;

import com.lhlz.dao.UserDao;

public class UserService {
    private UserDao userdao;

    public UserService() {
        userdao = new UserDao();
    }

    public boolean VerifyUser(String username, String password) throws Exception {
        boolean result = userdao.VerifyUser(username,password);

        return result;
    }
}
