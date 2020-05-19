package com.xiaoan.dao;

import com.xiaoan.user.User;

import java.util.List;

/**
 * @author 小安
 * @data 2020-05-07 22:05
 */
public interface UserDao {
    /**
     * 查询所有用户,同时获取带所有账户信息
     * @return
     */
    List<User> select();

    /**
     * 根据id查询用户信息
     * @param userid
     * @return
     */
    User selectById(Integer userid);


}
