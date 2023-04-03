package com.msb.test;

import com.msb.pojo.Dept;
import com.msb.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

//<!--    sqlSession三种查询方法    -->

public class Test2 {
    private SqlSession sqlSession;

    @Before//准备一个 sqlSession 对象
    public void init(){
        SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory factory = ssfb.build(resourceAsStream) ;
        sqlSession = factory.openSession();
    }

    @Test
    public void testSelectOne(){

        //查询单个对象
        System.out.println("sqlSession查询单个对象");
        Emp emp = sqlSession.selectOne("findOne");
        System.out.println(emp);


    }

    @Test
    public void testSelectList(){

        //查询多个对象的List集合
        System.out.println("sqlSession查询多个对象List集合");
        List<Emp> emps = sqlSession.selectList("EmpMapper.findAll");
        for (Emp emp : emps) {
            System.out.println(emp);
        }

    }

    @Test
    public void testSelectMap(){

        //查询多个对象的Map集合
        System.out.println("sqlSession查询多个对象的Map 集合");
        Map<Integer,Emp> empMap = sqlSession.selectMap("findEmpMap", "EMPNO");
        Set<Integer> empnos = empMap.keySet();
        for (Integer empno : empnos) {
            System.out.println(empno+" :"+empMap.get(empno));
        }

    }
    @After
    public void release(){
        //  关闭SqlSession
        sqlSession.close();
    }
}
