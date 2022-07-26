package com.emmmua.service.impl;

import com.emmmua.mapper.userMapper;
import com.emmmua.pojo.User;
import com.emmmua.service.UserService;
import com.emmmua.util.SqlSessionFactoryUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserServiceImpl implements UserService {
    // 1. 使用SqlSessionFactory工具包
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public User login(User user) {
        // 2. 获取openSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3. 获取Mapper对象
        userMapper mapper = sqlSession.getMapper(userMapper.class);
        user.setPassword(DigestUtils.md5Hex(user.getPassword()));
        User res = mapper.login(user);
        return res;
    }

    @Override
    public boolean register(User user) {
        // 2. 获取openSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 获取Mapper对象
        userMapper mapper = sqlSession.getMapper(userMapper.class);

        // 判断用户名是否已经存在
        User flag = mapper.SelectByName(user.getUsername());

        if (flag != null) {
            // 用户名已存在
            return false;
        }

        user.setPassword(DigestUtils.md5Hex(user.getPassword()));


        // 4. 调用mapper中的注册方法进行注册
        mapper.register(user);

        // 5. 提交事务
        sqlSession.commit();

        return true;
    }
}
