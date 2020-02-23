package com.csw.service;

import com.csw.dao.ProductDao;
import com.csw.dao.ProductDaoImpl;
import com.csw.entity.Product;
import com.csw.util.JDBCUtils;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    @Override
    public List<Product> queryPersonByArray(int currPage, int pageSize,
                                            Integer countPage) {
        Connection connection = null;
        List<Product> lists = new ArrayList<Product>();
        List<Product> list = new ArrayList<Product>();
        try {
            connection = JDBCUtils.getConnection();
            connection.setAutoCommit(false);
            ProductDao pd = new ProductDaoImpl();
            lists = pd.queryPersonByArray();

            int firstIndex = (currPage - 1) * pageSize + 1;
            int lastIndex = currPage * pageSize;
            if (currPage != countPage) {
                for (int i = firstIndex; i <= lastIndex; i++) {
                    list.add(lists.get(i - 1));
                }
            } else {
                for (int i = firstIndex; i <= lists.size(); i++) {
                    list.add(lists.get(i - 1));
                }
            }

            System.out.println("{{service lists}=" + lists);
            System.out.println("{{service list}=" + list);
            connection.commit();
            return list;
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            e.printStackTrace();
            throw new RuntimeException("service search error");
        } finally {
            JDBCUtils.close(connection);
        }
    }

    @Override
    public Integer countPageAction() {
        Connection connection = null;
        Integer pageInteger;
        try {
            connection = JDBCUtils.getConnection();
            connection.setAutoCommit(false);
            ProductDao pd = new ProductDaoImpl();
            Integer count = pd.countPage();
            System.out.println(" {{service count}=" + count);
            if (count % 2 == 0) {
                pageInteger = count / 2;
            } else {
                pageInteger = count / 2 + 1;
            }
            connection.commit();
            System.out.println(" {{service pageInteger}=" + pageInteger);
            return pageInteger;
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            e.printStackTrace();
            throw new RuntimeException("service search error");
        } finally {
            JDBCUtils.close(connection);
        }
    }

    @Override
    public Product getProductById(Integer id) {
        Connection connection = null;
        Product product;
        try {
            connection = JDBCUtils.getConnection();
            connection.setAutoCommit(false);
            ProductDao pd = new ProductDaoImpl();
            product = pd.getProductById(id);
            return product;
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            e.printStackTrace();
            throw new RuntimeException("service search error");
        } finally {
            JDBCUtils.close(connection);
        }
    }
}