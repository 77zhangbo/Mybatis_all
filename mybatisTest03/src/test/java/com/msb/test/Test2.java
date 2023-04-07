package com.msb.test;

import com.msb.mapper.DeptMapper;
import com.msb.mapper.EmpMapper;
import com.msb.mapper.ProjectMapper;
import com.msb.pojo.Dept;
import com.msb.pojo.Emp;
import com.msb.pojo.Project;
import com.msb.pojo.ProjectRecord;
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

    /**
     * 多表查询，测试一对一关系
     */
    @Test
    public void testOneToOne(){
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.findEmpJoinDeptByEmpno(7566);
        System.out.println(emp);
    }

    /**
     * 多表查询，测试一对多关系
     */
    @Test
    public  void testOneToMany(){
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.findDeptJoinEmpsByDeptno(20);
        System.out.println(dept);
        List<Emp> empList = dept.getEmpList();
        empList.forEach(System.out::println);
    }

    /**
     * 多表查询，测试多对多关系
     */
    @Test
    public void testManyToMany(){
        ProjectMapper mapper = sqlSession.getMapper(ProjectMapper.class);
        Project project = mapper.findProjectJoinEmpsByPid(3);
        System.out.println(project.getPid());
        System.out.println(project.getPname());
        System.out.println(project.getMoney());

        List<ProjectRecord> projectRecords = project.getProjectRecords(); //通过project获取项目记录
        for (ProjectRecord projectRecord : projectRecords) {
            Emp emp = projectRecord.getEmp();//通过 projectRecord获得每个Emp对象
            System.out.println(emp); //输出每个Emp对象
        }
    }

    @After
    public void  release(){

        sqlSession.close();
    }
}
