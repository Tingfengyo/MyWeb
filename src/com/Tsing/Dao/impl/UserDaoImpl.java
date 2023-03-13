package com.Tsing.Dao.impl;

import com.Tsing.Dao.UserDao;
import com.Tsing.prop.User;

import java.sql.*;

import static com.Tsing.Utils.DBUtil.closeAll;
import static com.Tsing.Utils.DBUtil.getCon;

/**
 * @author tingfeng
 * @date 2023/3/12 23:19
 */
public class UserDaoImpl implements UserDao {

    public static void main(String[] args) {
        if (new UserDaoImpl().loginSystem("admin","123456")) {
            System.out.println("ok");

        }else System.out.println("error");
    }

    @Override
    public boolean loginSystem(String username, String password) {
        User u = null;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            con = getCon();
            String sql = "SELECT * FROM user WHERE loginName = ? AND passWord = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, password);
            rs = pst.executeQuery();
            if (rs.next()) {
                u = new User(rs.getString("loginName"), rs.getString("passWord"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(rs, pst, con);
        }
        System.out.println(u);
        return u != null;
    }
}
