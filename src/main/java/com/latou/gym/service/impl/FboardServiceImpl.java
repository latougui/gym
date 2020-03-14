package com.latou.gym.service.impl;

import com.latou.gym.domain.Fboard;
import com.latou.gym.mapper.FboardMapper;
import com.latou.gym.service.FboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FboardServiceImpl implements FboardService {
    @Autowired
    private FboardMapper fboardMapper;

    @Override
    public List<Fboard> findAllFboard() {
        return fboardMapper.findAllFboard();
    }

    @Override
    public Fboard findByFboardId(long fboardId) {
        return fboardMapper.findByBoardId(fboardId);
    }


}
