package com.msb.test;

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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//<!--  sqlSession实现CURD     -->

public class Test4 {
    private SqlSession sqlSession;

    @Before
    public void init(){
        SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory factory = ssfb.build(resourceAsStream) ;
        sqlSession = factory.openSession();//可以设置自动提交事务 (true)
    }

    @Test
    //增加方法
    public void testInsert(){
        Emp emp = new Emp(null,"玫瑰","CLERK",7839,new Date(),3050.0,300.0,10);
        int rows = sqlSession.insert("addEmp", emp);
        System.out.println(rows);

        //手动提交事务
        sqlSession.commit();
        /*增删改要 提交事务
        * sqlSession.commit();手动提交事务
        * sqlSession = factory.openSession(true);  设置事务自动提交👆
        * */
    }


    @Test
    //修改方法
    public void testUpdate(){
        Emp emp = new Emp();
        emp.setEname("可美");
        emp.setEmpno(7936);
        int rows = sqlSession.update("updateEmp",emp);
        System.out.println(rows);

        //手动提交事务
        sqlSession.commit();
    }


    @Test
    //删除方法
    public void testDelete(){
        int rows = sqlSession.delete("deleteEmp", 7936);
        System.out.println(rows);

        //手动提交事务
        sqlSession.commit();
    }

    @After
    public void release(){
        //  关闭SqlSession
        sqlSession.close();
    }
}
