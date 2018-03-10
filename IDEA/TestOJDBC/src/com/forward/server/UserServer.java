package com.forward.server;

import com.forward.dao.DaoImpl;
import com.forward.po.User;

public class UserServer {

    public User login(int user_id, String user_name, int password, double salary) {
        DaoImpl daoImpl = new DaoImpl();
        return daoImpl.getUser(user_id, user_name,password,salary);
    }

}
