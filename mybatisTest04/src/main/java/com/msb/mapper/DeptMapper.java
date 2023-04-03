package com.msb.mapper;

import com.msb.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {

    /**
     * 查询所有部门信息
     * @return 多个Dept对象的List集合
     */
    @Select("select * from dept ")
    List<Dept> findAllDept();

    /**
     *根据部门编号查询部门信息
     * @param deptno 部门编号
     * @return Dept对象 找不到返回null
     */
    @Select("select * from dept where deptno = #{deptno}")
    Dept findDeptByDeptno(int deptno);

    /**
     * 增加一个部门信息
     * @param dept 部门的属性信息
     * @return
     */
    @Insert("insert into dept values (DEFAULT,#{dname},#{loc})")
    int addDept(Dept dept);

    /**
     * 根据部门编号修改部门信息
     * @param dept 部门编号和需要修改的信息
     * @return
     */
    @Update("update dept set dname = #{dname},loc = #{loc} where deptno = #{deptno}")
    int updateDept(Dept dept);

    /**
     * 根据部门编号删除部门信息
     * @param deptno 部门编号
     * @return 对数据库数据产生影响的行数
     */
    @Delete("delete from dept where deptno=#{deptno}")
    int deleteDept(int deptno);
}
