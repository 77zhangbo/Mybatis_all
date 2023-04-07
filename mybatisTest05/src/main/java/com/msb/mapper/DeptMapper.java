package com.msb.mapper;

import com.msb.pojo.Dept;

public interface DeptMapper {
    /**
     *  根据部门号查询部门信息
     * @param deptno  所查询的部门号
     * @return 返回该部门信息
     */
    //级联积极加载
    Dept findByDeptno(int deptno);
}
