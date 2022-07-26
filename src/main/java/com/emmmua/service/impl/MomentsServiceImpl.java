package com.emmmua.service.impl;


import com.emmmua.mapper.momentsMapper;
import com.emmmua.pojo.Moments;
import com.emmmua.pojo.User;
import com.emmmua.service.MomentsService;
import com.emmmua.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import java.util.List;

public class MomentsServiceImpl implements MomentsService {


    // 1. 使用SqlSessionFactory工具包
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public List<Moments> selectAll() {
        // 2. 获取openSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 获取Mapper
        momentsMapper mapper = sqlSession.getMapper(momentsMapper.class);

        List<Moments> moments = mapper.selectAll();
        return moments;
    }


    // 根据id查询
    @Override
    public User selectById(int id) {
        // 2. 获取openSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 获取Mapper
        momentsMapper mapper = sqlSession.getMapper(momentsMapper.class);

        User user = mapper.selectById(id);

        return user;
    }

    // 根据depId删除
    @Override
    public int DeleteById(long number) {
        // 2. 获取openSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 获取Mapper
        momentsMapper mapper = sqlSession.getMapper(momentsMapper.class);

        int line = mapper.DeleteById(number);

        // 提交事务
        sqlSession.commit();

        return line;
    }

    // 插入（发布朋友圈）

    @Override
    public int InsertMoments(Moments moments) {
        // 2. 获取openSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 获取Mapper
        momentsMapper mapper = sqlSession.getMapper(momentsMapper.class);

        int line = mapper.InsertMoments(moments);

        sqlSession.commit();

        return line;
    }
}
