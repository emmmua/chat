package com.emmmua.service;

import com.emmmua.pojo.Moments;
import com.emmmua.pojo.User;

import java.util.List;

public interface MomentsService {
    List<Moments> selectAll();
    User selectById(int id);
    int DeleteById(long number);
    int InsertMoments(Moments moments);
}
