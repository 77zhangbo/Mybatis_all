 package com.msb.test;

import com.msb.mapper.DeptMapper;
import com.msb.pojo.Dept;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class Test2 {
    public SqlSession sqlSession;

    @Before
    public void init() throws IOException {
        SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory factory = ssfb.build(resourceAsStream);
        sqlSession = factory.openSession();

    }

    @Test
    //自增回填方式一
    public void testAddDept(){
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = new Dept(null,"JAVA","北京");
        System.out.println(dept.getDeptno());
        deptMapper.addDept(dept);
        sqlSession.commit();
        System.out.println(dept.getDeptno());
    }

    @Test
    //自增回填方式二
    public void testAddDept2(){
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = new Dept(null,"JAVA","北京");
        System.out.println(dept.getDeptno());
        deptMapper.addDept2(dept);
        sqlSession.commit();
        System.out.println(dept.getDeptno());
    }


    @After
    public void  release(){

        sqlSession.close();
    }
}
