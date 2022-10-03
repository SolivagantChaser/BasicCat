package com.bluewhitecat.utils;

import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class JdbcUtilsTest {

    @Test
    public void test() throws SQLException {
        System.out.println(JdbcUtils.getDataSource().getConnection());
    }

    @Test
    public void test2() {
        for (int i = 0; i < 100; i++) {
            System.out.println(JdbcUtils.getConnection());
        }
    }

    @Test
    public void test3() {
        Connection connection = JdbcUtils.getConnection();
        JdbcUtils.close(connection);
    }
}
