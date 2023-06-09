package com.msb.mapper;

import com.msb.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmpMapper {
    /**
     * 该方法用于查询全部的员工信息
     * @return 返回 全部员工信息封装的Emp对象的List集合
     */
    List<Emp> findAll();


    /**
     * 根据员工编号查询单个员工信息的方法
     * @param empno 员工编号
     * @return Emp对象    如果找到了返回 Emp对象，找不到返回nuuLLL
     */
    Emp findByEmpno(int empno);


    /**
     * 根据员工部门编号和薪资下限去查询员工信息
     * @param deptno 员工编号
     * @param sal  薪资下限
     * @return  多个Emp对象的List集合
     */
    List<Emp> findByDeptnoAndSal(@Param("deptno") int deptno, @Param("sal") double sal);

    /**
     *
     * @param map
     * @return 多个Emp对象的List集合
     */
    List<Emp> findByDeptnoAndSal2(Map<String,Object> map);

    /**
     *
     * @param emp
     * @return 多个Emp对象的List集合
     */
    List<Emp> findByDeptnoAndSal3(Emp emp);

    /**
     *
     * @param empa
     * @param empb
     * @return 多个Emp对象的List集合
     */
    List<Emp> findByDeptnoAndSal4(@Param("empa") Emp empa,@Param("empb") Emp empb);

    /**
     * 根据员工名字模糊匹配多个员工信息
     * @param ename 模糊查询的文字
     * @return  多个员工对象List集合
     */
    List<Emp> findByEname(String ename);

    /**
     *增加员工信息
     * @param emp 存储新增员工信息的Emp对象
     * @return  对数据库数据产生影响的行数
     */
    int addEmp(Emp emp);

    /**
     * 根据员工编号修改员工姓名的方法
     * @param empno 要修改的员工编号
     * @param ename 修改之后的新的员工名字
     * @return 对数据库数据产生影响的行数
     */
    int updateEnameByEmpno(@Param("empno") int empno,@Param("ename") String ename);

    /**
     * 根据员工编号删除员工信息的方法
     * @param empno 要删除的员工编号
     * @return  对数据库数据产生影响的行数
     */
    int deleteByEmpno(int empno);
}
