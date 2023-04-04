package com.msb.mapper;

import com.msb.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmpMapper2 {

    List<Emp> findByCondition(Emp emp);
    List<Emp> findByCondition2(Emp emp);

}
