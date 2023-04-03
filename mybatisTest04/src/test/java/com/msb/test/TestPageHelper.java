package com.msb.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.msb.mapper.DeptMapper;
import com.msb.pojo.Dept;
import org.junit.Test;

import java.util.List;

public class TestPageHelper<ApplicationContext> {
    @Test
    public void testPagehelper() {
        //1）在mybatsi的总的配置文件中配置分页插件
        //2）在使用mybatis查询之前使用pagehelper的静态方法,设置开始页码（从1开始），每页多少条
        PageHelper.startPage(1,10);

        //3）使用Mybatis查询信息,放在list中
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
       DeptMapper deptMapper = applicationContext.getBean(DeptMapper.class);
        Dept example = new Dept();
        List<Dept> list = deptMapper.selectByExample(example);

        //4）使用pageInfo接收mybatis查询的结果集合
        PageInfo<Dept> info = new PageInfo<>(list);

        //5）info中会获取原本的数据（本来查询的结果）
        System.out.println("原本查询的所有数据总条数"+info.getTotal());

        //6）而此时原本使用Mybatis查询信息,放在list中的数据已经是截取之后的了
        System.err.println(list.size());
    }


}
