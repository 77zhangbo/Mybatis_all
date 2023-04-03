package com.msb.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
import java.util.List;

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
//    查询所有部门信息
    public void findAllDept(){
        PageHelper.startPage(1,5);
        DeptMapper deptMapper =sqlSession.getMapper(DeptMapper.class);
        List<Dept> depts = deptMapper.findAllDept();
        depts.forEach(System.out::println);
        PageInfo<Dept> info = new PageInfo<>(depts);
        System.out.println("原本查询的所有数据总条数"+info.getTotal());
        System.out.println(depts.size());
//        System.out.println(depts);
    }


    @Test
//    根据部门编号查询部门信息
    public void findDeptByDeptno(){
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept =deptMapper.findDeptByDeptno(85);
        System.out.println(dept);
    }
    @Test
//    增加一个部门信息
    public void addDept(){
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = new Dept(null,"ootd","成都");
        deptMapper.addDept(dept);
//        System.out.println(dept);
        sqlSession.commit();
    }

    @Test
//    根据部门编号修改部门信息
    public void updateDept(){
        DeptMapper deptMapper =sqlSession.getMapper(DeptMapper.class);
        Dept dept = new Dept(88,"xx","667");
//        dept.setDeptno(66);
//        dept.setDname("xixi");
//        dept.setLoc("北京");
        deptMapper.updateDept(dept);
        sqlSession.commit();
    }

    @Test
//    根据部门编号删除部门信息
    public void deleteDept(){
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        int dept = deptMapper.deleteDept(88);
        System.out.println(dept);
        sqlSession.commit();
    }


    @After
    public void release(){
        //  关闭SqlSession
        sqlSession.close();
    }
}
