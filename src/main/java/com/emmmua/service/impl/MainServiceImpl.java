package com.emmmua.service.impl;

import com.emmmua.mapper.mainMapper;
import com.emmmua.pojo.User;
import com.emmmua.service.MainService;
import com.emmmua.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class MainServiceImpl implements MainService {

    // 1. 使用SqlSessionFactory工具包
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public void reUser(User user) {
        // 2. 获取openSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 获取Mapper
        mainMapper mapper = sqlSession.getMapper(mainMapper.class);

        // 4. 更新头像
        mapper.reUser(user);

        // 5. 提交事务
        sqlSession.commit();
    }


    // 信息列表

    @Override
    public List<User> SelectAll() {
        // 2. 获取openSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 获取Mapper
        mainMapper mapper = sqlSession.getMapper(mainMapper.class);

        List<User> users = mapper.SelectAll();

        return users;
    }
}
