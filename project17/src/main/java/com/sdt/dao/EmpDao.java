package com.sdt.dao;

import com.sdt.domain.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpDao {
    @Select("select * from emp")
    public List<Emp> findAll();

    @Insert("insert into emp(ename,job,mgr,hiredate,sal,comm,deptno)values(#{ename},#{job},#{mgr},#{hiredate},#{sal},#{comm},#{deptno})")
    public void add(Emp emp);

    @Update("update emp set ename=#{ename},job=#{job},mgr=#{mgr},hiredate=#{hiredate},sal=#{sal},comm=#{comm},deptno=#{deptno} where empno=#{empno}")
    public void update(Emp emp);

    @Delete("delete from emp where empno = #{id}")
    public void delete(Integer id);

    @Select("select * from emp where empno = #{id}")
    public Emp findById(Integer id);
}
