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
    public List<Essay> findAllEssayByBoard(long essayBoradId) {
        return essayMapper.findAllEssayByBoard(essayBoradId);
    }

    @Override
    public List<Essay> findRecentEssay(long essayBoardId) {
        return essayMapper.findRecentEssay(essayBoardId);
    }

    @Override
    public List<Essay> findRecent() {
        return essayMapper.findRecent();
    }

    @Override
    public List<Essay> findEssayByViewId() {
        return essayMapper.findEssayByViewId();
    }

    @Override
    public Essay findEssayById(long essayId) {
        return essayMapper.findEssayById(essayId);
    }

    @Override
    public void addEssay(Essay essay) {
       essayMapper.addEssay(essay);
    }

    @Override
    public void updateEssay(Essay essay) {
        essayMapper.updateEssay(essay);
    }

    @Override
    public void deleteEssay(long essayId) {
        essayMapper.deleteEssay(essayId);
    }

    @Override
    public int countEssay() {
        return essayMapper.countEssay();
    }

    @Override
    public int countEssayLove() {
        return essayMapper.countEssayLove();
    }

    @Override
    public List<Essay> search(String content) {
        return essayMapper.search(content);
    }
}
