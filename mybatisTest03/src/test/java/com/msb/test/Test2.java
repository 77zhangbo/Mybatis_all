package com.msb.test;

import com.msb.mapper.EmpMapper;
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
    public void testFindAll(){
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.findEmpJoinDeptByEmpno(7499);
        System.out.println(emp);
    }


    @After
    public void  release(){

        sqlSession.close();
    }
}
