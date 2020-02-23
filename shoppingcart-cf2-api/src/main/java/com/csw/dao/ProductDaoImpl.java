package com.csw.dao;

import com.csw.entity.Product;
import com.csw.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    @Override
    public List<Product> queryPersonByArray() {
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Product> list = new ArrayList<Product>();
        Product person;

        try {
            connection = JDBCUtils.getConnection();
            String sqlString = "select * from shop_product";
            pstm = connection.prepareStatement(sqlString);
            rs = pstm.executeQuery();
            while (rs.next()) {
                person = new Product(rs.getInt(1), rs.getString(2),
                        rs.getDouble(3), rs.getString(4), rs.getString(5));
                list.add(person);
            }
            System.out.println("dao list" + list);
            return list;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            throw new RuntimeException("dao search error");
        } finally {
            JDBCUtils.close(rs, pstm, null);
        }
    }

    @Override
    public Integer countPage() {
        // TODO Auto-generated method stub
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Integer count = 0;
        try {
            connection = JDBCUtils.getConnection();
            String sqlString = "select * from shop_product";
            pstm = connection.prepareStatement(sqlString);
            rs = pstm.executeQuery();
            System.out.println("{{dao rs}=" + rs);

            while (rs.next()) {
                count++;
            }
            System.out.println("{{dao count}=" + count);
            return count;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            throw new RuntimeException("dao search error");
        } finally {
            JDBCUtils.close(rs, pstm, null);
        }
    }

    @Override
    public Product getProductById(Integer id) {
        // TODO Auto-generated method stub
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        Product product = null;
        // private Integer id;
        // private String productName;
        // private Double price;
        // private String picpath;
        // private String discription;
        try {
            connection = JDBCUtils.getConnection();
            String sqlString = "select * from shop_product where id=?";
            pstm = connection.prepareStatement(sqlString);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                product = new Product(rs.getInt(1), rs.getString(2),
                        rs.getDouble(3), rs.getString(4), rs.getString(5));

            }

            return product;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            throw new RuntimeException("dao search error");
        } finally {
            JDBCUtils.close(rs, pstm, null);
        }
    }

}
