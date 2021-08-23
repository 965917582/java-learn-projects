package com.project54.com.dao;

import com.project54.com.bean.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface AccountMapper {
    @Select("select * from account where id=#{id}")
    Account getById(Integer id);

    @Update("update account set money = #{money},version=version+1 where id = #{id} and version=#{version}")
    int update(Account account);
}
