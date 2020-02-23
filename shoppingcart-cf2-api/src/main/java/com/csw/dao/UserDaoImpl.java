package com.csw.dao;

import com.csw.entity.User;
import com.csw.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl implements UserDao {

    @Override
    public User query(String username, String password) {
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        User uu = null;
        try {
            connection = JDBCUtils.getConnection();
            String sqlString = "select * from shop_user where username=? and password=?";
            pstm = connection.prepareStatement(sqlString);
            pstm.setString(1, username);
            pstm.setString(2, password);
            rs = pstm.executeQuery();
            while (rs.next()) {
                uu = new User(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getInt(4), rs.getString(5));
                System.out.println("{{dao uu}=" + uu);
            }
            return uu;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("{{dao query error}}");
        } finally {
            JDBCUtils.close(rs, pstm, null);
        }
    }

    @Override
    public void addUsers(User uu) {
        Connection connection = null;
        PreparedStatement pstm = null;
        User accUser;
        try {
            connection = JDBCUtils.getConnection();
            String sqlString = "insert into shop_user values(?,?,?,?,?)";
            pstm = connection.prepareStatement(sqlString);
            pstm.setString(1, uu.getUsername());
            pstm.setString(2, uu.getPassword());
            pstm.setString(3, uu.getName());
            pstm.setInt(4, uu.getZip());
            pstm.setString(5, uu.getAddress());
            pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("{{dao insert into error}}");
        } finally {
            JDBCUtils.close(pstm, null);
        }
    }
}
