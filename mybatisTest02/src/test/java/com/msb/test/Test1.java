package com.msb.test;

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
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Test1 {
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
        sqlSession = factory.openSession();
    }

    @Test
    //查询全部员工信息
    public void testFindAll(){

        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> emps = empMapper.findAll();
        emps.forEach(System.out::println);
    }

    @Test
    //根据员工编号查询单个员工信息
    public void FindByEmpno(){
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = empMapper.findByEmpno(7566);
        System.out.println(emp);
    }


    @Test
    //根据员工部门编号deptno和薪资sal下限查询员工信息
    public void FindByDeptnoAndSal(){
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> emps = empMapper.findByDeptnoAndSal(20, 3000.0);
        emps.forEach(System.out::println);
    }


    @Test
    //参数放在map集合里
    public void FindByDeptnoAndSal2(){
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        Map<String,Object> map = new HashMap<>();
        map.put("deptno",20);
        map.put("sal",3000.0);
        List<Emp> emps = empMapper.findByDeptnoAndSal2(map);
        emps.forEach(System.out::println);
    }

    @Test
    //用一个引用类型作为参数
    public void FindByDeptnoAndSal3(){
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = new Emp();
        emp.setDeptno(20);
        emp.setSal(3000.0);
        List<Emp> emps = empMapper.findByDeptnoAndSal3(emp);
        emps.forEach(System.out::println);
    }

    @Test
    //多个引用类型作为方法参数
    public void FindByDeptnoAndSal4(){
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        Emp empa = new Emp();
        empa.setDeptno(20);
        Emp empb = new Emp();
        empb.setSal(3000.0);
        List<Emp> emps = empMapper.findByDeptnoAndSal4(empa, empb);
        emps.forEach(System.out::println);
    }


    @Test
//模糊查询
    public void FindByEname(){
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> emps = empMapper.findByEname("a");
        emps.forEach(System.out::println);
    }
    @After
    public void release(){
        //  关闭SqlSession
        sqlSession.close();
    }
}
