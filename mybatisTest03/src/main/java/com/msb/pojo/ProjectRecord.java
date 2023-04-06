package com.msb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectRecord implements Serializable {

    private Integer empno;
    private Integer pid;

    //组合一个emp对象作为属性
    private Emp emp;
}

