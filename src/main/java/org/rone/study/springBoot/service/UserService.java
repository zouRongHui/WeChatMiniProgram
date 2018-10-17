package org.rone.study.springBoot.service;

import org.rone.study.springBoot.Exception.RoneException;
import org.rone.study.springBoot.dao.UserDao;
import org.rone.study.springBoot.model.User;
import org.rone.study.springBoot.utils.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by rone on 2018/4/26.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<User> getUsers() throws Exception {
        List<User> userList = new ArrayList<>(3);
        IdGenerator idGenerator = new IdGenerator(1L, 1L);
        userList.add(new User(idGenerator.nextId()+"", "Mike", "Mike@jishulink.com"));
        userList.add(new User(idGenerator.nextId()+"", "Nike", "Nike@jishulink.com"));
        userList.add(new User(idGenerator.nextId()+"", "Rose", "Rose@jishulink.com"));

        if (userList == null) {
            throw new RoneException("没有用户啊");
        }

        return userList;
    }

    public User getUserById(String userId) throws Exception {
        User user = new User(userId, "no name", "10086@jishulink.com");
        if (user == null) {
            throw new RoneException("用户不存在...");
        }
        return user;
    }

    public void addUser(User user) throws Exception {
        if (user == null) {
            throw new InvalidParameterException("参数出错，用户为NULL...");
        }
    }

    public User updateUserName(String userId, String name) throws Exception {
        return new User(userId, name, name + "@jishulink.com");
    }

    public List<User> getUserByName(String userName) throws Exception {
        return userDao.getUserByName(userName);
    }

    public Map getUserPartDataByName(String userName) throws Exception {
        return userDao.getUserPartDataByName(userName);
    }

    public List<Map> getUserPartDataListByName(String userName) throws Exception {
        return userDao.getUserPartDataListByName(userName);
    }

    public void updateUserEmailByName(String name, String email) throws Exception {
        userDao.updateUserEmailByName(name, email);
    }

}
