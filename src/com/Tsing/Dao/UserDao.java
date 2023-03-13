package com.Tsing.Dao;

import com.Tsing.prop.User;

/**
 * @author tingfeng
 * @date 2023/3/12 23:16
 */
public interface UserDao {
    boolean loginSystem(String username, String password);
}
