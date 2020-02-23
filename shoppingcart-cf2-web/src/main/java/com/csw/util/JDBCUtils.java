package com.csw.util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    public static ThreadLocal<Connection> tol = new ThreadLocal<Connection>();
    private static Properties prop = new Properties();

    static {
        InputStream is = null;
        try {
            is = JDBCUtils.class.getResourceAsStream("/jdbc.properties");
            prop.load(is);
            Class.forName(prop.getProperty("driverClassName"));

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            throw new RuntimeException("�����ļ���ȡʧ��");
        } finally {
            try {
                is.close();
            } catch (Exception e2) {
                // TODO: handle exception
                e2.printStackTrace();
            }
        }
    }

    public static void close(Connection conn) {
        try {
            if (conn != null) {
                tol.remove();
                conn.close();
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public static void close(PreparedStatement pstm, Connection conn) {
        try {
            if (pstm != null) {
                pstm.close();
            }
            if (conn != null) {
                tol.remove();
                conn.close();

            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public static void close(ResultSet rs, PreparedStatement pstm,
                             Connection conn) {

        try {
            if (rs != null) {
                rs.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (conn != null) {
                tol.remove();
                conn.close();

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection conn = tol.get();
        try {
            if (conn == null) {
                conn = DriverManager.getConnection(prop.getProperty("url"),
                        prop.getProperty("username"),
                        prop.getProperty("password"));
                tol.set(conn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;

    }
}
