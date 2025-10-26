package com.vegi.learnspring.template;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class JdbcDemo {

    void  createCustomer(Customer customer) throws Exception{
        Connection conn = null;
        try {
            conn = getConnection();
            conn.setAutoCommit(false);
            String sql = "insert into customers(name) values(?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, customer.name());
            preparedStatement.execute();
            conn.commit();
        } catch (SQLException e) {
            //throw new RuntimeException(e);
            conn.rollback();
        }finally {
            if (conn != null) {
                conn.close();
            }
        }
    }

    void  updateCustomer(Customer customer) throws Exception{
        Connection conn = null;
        try {
            conn = getConnection();
            conn.setAutoCommit(false);
            String sql = "update customers set name = ? where id=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, customer.name());
            preparedStatement.setLong(2,customer.id());
            preparedStatement.execute();
            conn.commit();
        } catch (SQLException e) {
            //throw new RuntimeException(e);
            conn.rollback();
        }finally {
            if (conn != null) {
                conn.close();
            }
        }
    }

    private Connection getConnection() {
        Connection conn = null;
        conn = DriverManager.getConnection();
        return conn;
    }
}
