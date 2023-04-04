 package com.msb.test;

import com.msb.mapper.EmpMapper;
import com.msb.mapper.EmpMapper2;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

 public class Test4 {
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
     //动态sql之if语句
     public void testFindByCondition() throws ParseException {
         EmpMapper2 mapper = sqlSession.getMapper(EmpMapper2.class);
         Emp emp =new Emp();
         emp.setEname("A");       /* 按名字里包含A的去查 */
//         emp.setEmpno(7369);    /* 按工号去查 */
//         emp.setJob("CLERK");   /* 按职位去查 */
//         emp.setMgr(7839);      /* 按上司去查 */
//         emp.setHiredate(new SimpleDateFormat("yyyy-MM-dd").parse("1981-06-09"));       /*按出生日期去查*/
//         emp.setSal(3000.0);    /* 按薪资去查 */
//         emp.setComm(300.0);    /* 按补助金额去查 */
//         emp.setDeptno(10);     /* 按部门号去查 */
         List<Emp> emps =mapper.findByCondition(emp);
         for (Emp emp1 : emps) {
             System.out.println(emp1);
         }
     }

     @Test
     //动态sql之if语句
     public void testFindByCondition2() throws ParseException {
         EmpMapper2 mapper = sqlSession.getMapper(EmpMapper2.class);
         Emp emp =new Emp();
         emp.setEname("A");       /* 按名字里包含A的去查 */
         emp.setEmpno(7369);    /* 按工号去查 */
//         emp.setJob("CLERK");   /* 按职位去查 */
//         emp.setMgr(7839);      /* 按上司去查 */
//         emp.setHiredate(new SimpleDateFormat("yyyy-MM-dd").parse("1981-06-09"));       /*按出生日期去查*/
//         emp.setSal(3000.0);    /* 按薪资去查 */
//         emp.setComm(300.0);    /* 按补助金额去查 */
//         emp.setDeptno(10);     /* 按部门号去查 */
         List<Emp> emps =mapper.findByCondition2(emp);
         for (Emp emp1 : emps) {
             System.out.println(emp1);
         }
     }

     @Test
     public void testUpdateEmpByCondition() throws ParseException {
         EmpMapper2 mapper = sqlSession.getMapper(EmpMapper2.class);
         Emp emp = new Emp();
         emp.setEmpno(7940);    /* 修改工号 */
         emp.setEname("TOM");   /* 修改姓名 */
         emp.setJob("CLERK");   /* 修改职位 */
         emp.setMgr(7839);      /* 修改上级 */
         emp.setHiredate(new SimpleDateFormat("yyyy-MM-dd").parse("2019-09-06"));   /* 修改出生日期 */
         emp.setSal(3500.0);    /* 修改薪资 */
         emp.setComm(200.0);    /* 修改补助 */
         emp.setDeptno(30);     /* 修改部门号 */
         mapper.uodateEmpByCondition(emp);
         sqlSession.commit();
     }


     @After
     public void  release(){

         sqlSession.close();
     }
 }
