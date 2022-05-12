package com.lichuandi.jdbc;

/**
 * @Auther digege
 * @Date 2021/7/2
 * @Description：
 * @page com.lichuandi.jdbc
 * version：
 */

import java.sql.*;

public class dbUtil {
    public static Connection getConnection(){
        Connection conn=null;

        try {
            String url="jdbc:oracle:thin:@118.123.246.35:47000:MYCIM4";
            ///
            String user="cim05";
            String password="cimDEV400";

            Class.forName("oracle.jdbc.driver.OracleDriver");//加载数据驱动
            conn = DriverManager.getConnection(url, user, password);// 连接数据库
      System.out.println(" 连接成功");
           Statement statement = conn.createStatement();
            //PreparedStatement preparedStatement = conn.prepareStatement("select * from OME10STATE_SUBSTATE");
            //preparedStatement.
            ResultSet resultSet = statement.executeQuery("select * from OME10STATE_SUBSTATE");
            while (resultSet.next())
            {
                String id = resultSet.getString("E10_SUB_STATE_ID");
                String name = resultSet.getString("DESCRIPTION");
                String city = resultSet.getString("ID");
                System.out.println(id+"   "+name+"   "+city);  //打印输出结果集
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("加载数据库驱动失败");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("连接数据库失败");
        }
        return conn;
    }
    public static void close(Connection conn, PreparedStatement ps, ResultSet rs){
        try {
            if(rs!=null){
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if(ps!=null){
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if(conn!=null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

  public static void main(String[] args) {
    //
      dbUtil.getConnection();
  }
}

