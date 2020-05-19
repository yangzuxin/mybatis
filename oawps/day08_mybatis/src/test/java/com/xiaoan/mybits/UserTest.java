package com.xiaoan.mybits;


import com.xiaoan.dao.RoleDao;
import com.xiaoan.user.Role;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @author 小安
 * @data 2020-05-07 22:10
 */
public class UserTest<pu> {
    private SqlSession sqlSession;
    private RoleDao roleDao;
    private InputStream in;

    //
    @Before//用于在测试方法执行之前执行
    public void init() throws Exception{
        //读取配置文件生成字节流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //获取SqlSessionFactory对象
        SqlSessionFactory sqlFactory = new SqlSessionFactoryBuilder().build(in);
        //获取sqlSession对象
        sqlSession = sqlFactory.openSession();
        //获取UserDao代理对象
        roleDao = sqlSession.getMapper(RoleDao.class);
        //执行查询所有方法
    }

    /**
     * 关闭资源
     * @throws Exception
     */
    @After//用于在执行测试方法之后执行
    public void disClose() throws Exception{
        //提交事务，当openSession(true)时提交事务可省略，手动提交变为自动提交
//        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

    @Test
    public void seletFindAll(){
        List<Role> list = roleDao.seletFindAll();
        for (Role role : list) {
            System.out.println(role);
            System.out.println(role.getUsers());
        }
    }
}
