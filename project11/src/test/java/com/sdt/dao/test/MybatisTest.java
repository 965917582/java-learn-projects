package com.sdt.dao.test;

import com.sdt.dao.IUserDao;
import com.sdt.domain.QueryVo;
import com.sdt.domain.User;
import jdk.internal.util.xml.impl.Input;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * 测试mybatis的crud操作
 */
public class MybatisTest {
    private InputStream is;
    private SqlSession sqlSession;
    private IUserDao userDao;

    @Before//用于在测试方法执行之前执行
    public void init() throws IOException {
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        sqlSession = factory.openSession();
        userDao = sqlSession.getMapper(IUserDao.class);
    }
    @After//用于在测试方法执行之后执行
    public void destroy() throws IOException {
        //提交事务
        sqlSession.commit();
        sqlSession.close();
        is.close();
    }

    @Test
    public void testFindAll() throws Exception{
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testSave() throws Exception{
        User user = new User();
        user.setUsername("aijia");
        user.setAddress("四川成都");
        user.setSex("女");
        user.setBirthday(new Date());

        System.out.println(user);
        userDao.saveUser(user);
        System.out.println(user);
    }

    @Test
    public void testUpdate() throws Exception{
        User user = new User();
        user.setId(52);
        user.setUsername("aijiajia");
        user.setAddress("四川成都");
        user.setSex("男");
        user.setBirthday(new Date());

        userDao.updateUser(user);
    }

    @Test
    public void testDelete() throws Exception{
        userDao.deleteUser(52);
    }

    @Test
    public void testFindOne() throws Exception{
        User user = userDao.findById(48);
        System.out.println(user);
    }

    @Test
    public void testFindByName() throws Exception{
        List<User> users = userDao.findByName("王");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindTotal() throws Exception{
        int total = userDao.findTotal();
        System.out.println(total);
    }

    @Test
    public void testFindUserByVo() throws Exception{
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUsername("%王%");
        vo.setUser(user);
        List<User> users = userDao.findUserByVo(vo);
        for (User u : users) {
            System.out.println(u);
        }
    }

}
