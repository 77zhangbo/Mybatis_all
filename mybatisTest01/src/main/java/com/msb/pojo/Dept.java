package com.msb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data //注解，编译时自动生成 get、set方法
@AllArgsConstructor//生成一个包含全部参数的构造方法
@NoArgsConstructor//生成一个无参数的构造方法
public class Dept implements Serializable {
    private Integer deptno;
    private String dname;
    private String loc;
//    private String sex;
}
