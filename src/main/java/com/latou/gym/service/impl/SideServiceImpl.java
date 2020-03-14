package com.latou.gym.service.impl;

import com.latou.gym.domain.Side;
import com.latou.gym.mapper.SideMapper;
import com.latou.gym.service.SideService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SideServiceImpl implements SideService {

    private SideMapper sideMapper;

    @Override
    public void addSide(Side side) {
        sideMapper.addSide(side);
    }

    @Override
    public void deleteSide(int sideId) {
        sideMapper.deleteSide(sideId);
    }

    @Override
    public void updateSide(int sideId) {
        sideMapper.updateSide(sideId);
    }

    @Override
    public Side getSideByName(String name) {
        return sideMapper.getSideByName(name);
    }

    @Override
    public List<Side> getAllSide() {
        return null;
    }
}
