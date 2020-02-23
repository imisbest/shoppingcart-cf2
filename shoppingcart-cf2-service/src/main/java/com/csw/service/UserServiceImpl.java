package com.csw.service;

import com.csw.dao.UserDao;
import com.csw.dao.UserDaoImpl;
import com.csw.entity.User;
import com.csw.util.JDBCUtils;

import java.sql.Connection;

public class UserServiceImpl implements UserService {

    @Override
    public User queryBy(String username, String password) {
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            connection.setAutoCommit(false);
            UserDao ud = new UserDaoImpl();
            User user = ud.query(username, password);
            connection.commit();
            return user;
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            e.printStackTrace();
            throw new RuntimeException("{[service query by error}}");
        } finally {
            JDBCUtils.close(connection);
        }
    }

    @Override
    public void addUsers(User uu) {
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            connection.setAutoCommit(false);
            UserDao ud = new UserDaoImpl();
            ud.addUsers(uu);
            connection.commit();

        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            e.printStackTrace();
            throw new RuntimeException("{[service insert into error}}");
        } finally {
            JDBCUtils.close(connection);
        }
    }
}
