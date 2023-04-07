package com.msb.mapper;

import com.msb.pojo.Emp;

import java.util.List;

public interface EmpMapper {
    /**
     * 根据部门号查询该部门所有的员工信息
     * @param deptno 要查询的部门号
     * @return 该部门下所有的员工信息
     */
    //级联积极加载
    List<Emp> findEmpsByDeptno(int deptno);

}
