package com.latou.gym.service;

import com.latou.gym.domain.Side;

import java.util.List;

public interface SideService {
    void addSide(Side side);
    void deleteSide(int sideId);
    void updateSide(int sideId);
    Side getSideByName(String name);
    List<Side> getAllSide();
}
