package com.msb.mapper;

import com.msb.pojo.Dept;

public interface DeptMapper {
    /**
     * 根据部门号查询部门信息并携带该部门下的员工信息
     * @param deptno 要查询的部门号
     * @return
     */
    Dept findDeptJoinEmpsByDeptno(int deptno);
}
