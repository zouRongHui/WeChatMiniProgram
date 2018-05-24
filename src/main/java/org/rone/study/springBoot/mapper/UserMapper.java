package org.rone.study.springBoot.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.rone.study.springBoot.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by rone on 2018/5/8.
 */
@Component
public interface UserMapper {

    @Select("select id,email,name from employee where name=#{userName}")
    List<User> getUserByName(@Param("userName") String userName);

    @Select("select name,email from employee where name=#{userName}")
    Map getUserDataByName(@Param("userName") String userName);

    @Update("update employee set email=#{email} where name=#{userName}")
    void updateUserEmailByName(@Param("userName") String userName, @Param("email") String email);

}
