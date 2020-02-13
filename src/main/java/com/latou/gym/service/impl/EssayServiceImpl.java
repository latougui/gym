package com.latou.gym.service.impl;

import com.latou.gym.domain.Essay;
import com.latou.gym.mapper.EssayMapper;
import com.latou.gym.service.EssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EssayServiceImpl implements EssayService {

    @Autowired
    private EssayMapper essayMapper;

    @Override
    public List<Essay> findAllEssay() {
        return essayMapper.findAllEssay();
    }

    @Override
    public List<Essay> findAllEssayByBoard() {
        return null;
    }

    @Override
    public void addEssay(Essay essay) {

    }

    @Override
    public void deleteEssay(long id) {

    }
}
