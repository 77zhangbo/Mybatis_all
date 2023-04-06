package com.msb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dept implements Serializable {
    private  Integer deptno;
    private String dname;
    private String loc;

    //组合一个 Emp的List集合作为属性 （多表查询一对多）
    private List<Emp> empList;
}
