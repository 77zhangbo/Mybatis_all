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

    //当前部门下的所有员工对象的List集合
    private List<Emp> empList;
}
