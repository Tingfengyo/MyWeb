package com.Tsing.servlet;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.Tsing.Utils.DBUtil.getCon;

/**
 * @author tingfeng
 * @date 2023/3/9 8:29
 */
public class test {
    public static void main(String[] args) {
        Connection con = getCon();
        try {
            PreparedStatement statement = con.prepareStatement("select count(*) from `account`");

//            ResultSet resultSet = statement.executeQuery();

            boolean execute = statement.execute();
            System.out.println(execute);
//            while (resultSet.next()){
//                System.out.println(resultSet);
//            }
//            System.out.println(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
