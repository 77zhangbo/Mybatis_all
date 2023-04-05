package com.msb.mapper;

import com.msb.pojo.Emp;

import java.util.List;

public interface EmpMapper {
    /**
     *   List集合
     * @return  返回emp对象
     */
    List<Emp> findAll();

}
