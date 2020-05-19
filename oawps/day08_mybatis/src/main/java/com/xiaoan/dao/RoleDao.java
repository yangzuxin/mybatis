package com.xiaoan.dao;

import com.xiaoan.user.Role;

import java.util.List;

/**
 * @author 小安
 * @data 2020-05-17 22:53
 */
public interface RoleDao {
    /**
     * 查询所有
     * @return
     */
    List<Role> seletFindAll();

    List<Role> seletFindUser();
}
