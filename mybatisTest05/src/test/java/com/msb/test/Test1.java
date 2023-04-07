package com.msb.test;

import com.msb.mapper.DeptMapper;
import com.msb.mapper.EmpMapper;
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

public class Test1 {
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
    /**
     * 测试 级联积极加载
     */
    public void testFindByDeptno(){
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
//        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        Dept dept = deptMapper.findByDeptno(20);
        System.out.println(dept.getDeptno());
        System.out.println(dept.getDname());
        System.out.println(dept.getLoc());
        List<Emp> empList = dept.getEmpList();
        empList.forEach(System.out::println);

//        List<Emp> emps = empMapper.findEmpsByDeptno(20);
//        emps.forEach(System.out::println);

        }



    @After
    public void  release(){

        sqlSession.close();
    }
}
