package com.lichuandi.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Auther digege
 * @Date 2021/4/25
 * @Description：com.lichuandi.mysql version：1
 */
public class TestMysql {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/springbootdb?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC", "root", "Lichuandi0911");
        PreparedStatement preparedStatement = connection.prepareStatement("insert into mysqlTesr value (?,?)");
        for (int i = 0; i <20000 ; i++) {
            preparedStatement.setInt(1,i);
            preparedStatement.setString(2,i+"");
            preparedStatement.addBatch();
        }
        preparedStatement.executeBatch();
    }
}
