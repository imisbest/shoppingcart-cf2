package com.csw.test;

import com.csw.util.JDBCUtils;
import org.junit.Test;

public class TestConnection {

    @Test
    public void testconn() {
        System.out.println(JDBCUtils.getConnection());
    }
}
