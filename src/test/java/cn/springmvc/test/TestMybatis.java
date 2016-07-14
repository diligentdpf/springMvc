package cn.springmvc.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.springmvc.model.User;

public class TestMybatis {

  SqlSessionFactory sqlSessionFactory;

  @Before
  public void initFactory() throws IOException {
    String resource = "conf/sqlMapConfig.xml";

    InputStream inputStream = Resources.getResourceAsStream(resource);

    sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

  }

  // @Test
  public void testListAll() {
    // SqlSession session = sqlSessionFactory.openSession();
    // List<User> users = session.selectList("cn.itcast.mybatis.listAll");
    // System.out.println(users.size());
  }

  // @Test
  public void testQueryOne() {
    SqlSession session = sqlSessionFactory.openSession();
    User user = session.selectOne("cn.itcast.mybatis.getOne", 1);
    System.out.println(user);
  }

  // 事务需要程序员处理
  @Test
  public void testInsertOne() {
    User user = new User();
    user.setNickname("hello");
    user.setState(2);
    SqlSession session = sqlSessionFactory.openSession();
    int count = session.insert("cn.springmvc.model.User", user);
    session.commit();
    System.out.println(count);
  }

  // @Test
  public void testUpdateOne() {
    SqlSession session = sqlSessionFactory.openSession();
    User u = new User();
    // u=session.selectOne("cn.itcast.mybatis.getOne", "2");
    // u.setId("2");
    // u.setName("clclclclclcfei");
    // u.setAge(100);
    // u.setAddress("USA");
    int count = session.update("cn.itcast.mybatis.updateOne", u);
    session.commit();
    System.out.println(count);
  }

  // @Test
  public void testDeleteOne() {
    SqlSession session = sqlSessionFactory.openSession();
    User u = new User();
    // u.setId("2");
    int count = session.delete("cn.itcast.mybatis.deleteOne", u);
    session.commit();
    System.out.println(count);
  }



}
