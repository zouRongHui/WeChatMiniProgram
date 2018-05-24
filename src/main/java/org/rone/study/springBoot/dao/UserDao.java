package org.rone.study.springBoot.dao;

import org.rone.study.springBoot.mapper.UserMapper;
import org.rone.study.springBoot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by rone on 2018/5/8.
 */
@Repository
public class UserDao {

    @Autowired
    private UserMapper userMapper;

    public List<User> getUserByName(String name) {
        return userMapper.getUserByName(name);
    }

    public Map getUserPartDataByName(String name) {
        return userMapper.getUserDataByName(name);
    }

    public void updateUserEmailByName(String name, String email) {
        userMapper.updateUserEmailByName(name, email);
    }


}
