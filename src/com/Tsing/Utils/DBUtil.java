package com.Tsing.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @Author: zty
 * @Date: 2022-12-21 10:03
 * @Description:
 */
public class DBUtil {
    private static String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    private static String USER_NAME = "root";
    private static String PASS_WORD = "123456";
    private static String URL = "jdbc:mysql://localhost:3306/bookstore?characterEncoding=utf-8&serverTimezone=Asia/Shanghai&useUnicode=true&useSSL=true";
    //jdbc:mysql://localhost:3306/business?useUnicode=true&characterEncoding=utf8&useSSL=false
    //jdbc:mysql://localhost:3306/business?characterEncoding=utf-8&serverTimezone=Asia/Shanghai&useUnicode=true
    //静态语句块，表示在该类加载时(使用时)调用，只会调用一次
    static {
        //java提供了一个类Properties,专门用来读取properties文件
        Properties pro = new Properties();
        //创建标准输入流
        InputStream in = null;
        try {
            in =  DBUtil.class.getClassLoader().getResourceAsStream("db.properties");
            //加载文件流到Properties对象中
            pro.load(in);
            //读取配置文件中的信息
            DRIVER_CLASS = pro.getProperty("jdbc.driver")!=null?pro.getProperty("jdbc.driver"):DRIVER_CLASS;
            USER_NAME = pro.getProperty("jdbc.username")!=null?pro.getProperty("jdbc.username"):USER_NAME;
            PASS_WORD = pro.getProperty("jdbc.password")!=null?pro.getProperty("jdbc.password"):PASS_WORD;
            URL = pro.getProperty("jdbc.url")!=null?pro.getProperty("jdbc.url"):URL;
        } catch (IOException e) {
            e.printStackTrace();
        }finally {//关闭流
            if (in !=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //获取一个有效连接
    public static Connection getCon(){
        Connection con = null;
        try {
            //加载驱动
            Class.forName(DRIVER_CLASS);
            //通过url，username，password获取连接
            con = DriverManager.getConnection(URL,USER_NAME,PASS_WORD);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return con;
    }

    //释放所有资源
    public static void closeAll(ResultSet rs, PreparedStatement pst ,Connection con){
        try {
            if(rs!=null){
                rs.close();
            }
            if(pst!=null){
                pst.close();
            }
            if(con!=null){
                con.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
