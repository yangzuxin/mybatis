package com.xiaoan.mybits;


import com.xiaoan.dao.UserDao;
import com.xiaoan.user.User;
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
public class MybatisTest<pu> {
    private SqlSession sqlSession;
    private UserDao userDao;
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
        userDao = sqlSession.getMapper(UserDao.class);
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

    /**
     * 查询所有
     * @throws Exception
     */
    @Test
    public void testFndAll() throws Exception {
        List<User> list = userDao.select();
        for (User user : list) {
            System.out.println(user);
            System.out.println(user.getRoles());
        }
    }

    /**
     * 根据id查询
     * @throws Exception
     */
    @Test
    public void selectById() throws Exception{
        User user = userDao.selectById(7);
        System.out.println(user);
    }
}
