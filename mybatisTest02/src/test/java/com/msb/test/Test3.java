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
import java.util.Date;

 public class Test3 {
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
/* Mybatis代理模式实现CURD
*
* */
     @Test
     //增加员工信息
     public void testAddEmp(){
         EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
         Emp emp = new Emp(null,"JIM","SALESMAN",7566,new Date(),2300.0,100.0,10);
         mapper.addEmp(emp);
         sqlSession.commit();
     }

     @Test
     //修改员工信息
     public void testUpdateEnameByEmpno(){
         EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
         mapper.updateEnameByEmpno(7939,"TOM");
         sqlSession.commit();
     }

     @Test
     //删除员工信息
     public void testDeleteByEmpno(){
         EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
         mapper.deleteByEmpno(7939);
         sqlSession.commit();
     }

     @After
     public void  release(){

         sqlSession.close();
     }
 }
