package com.latou.gym.service;

import com.latou.gym.domain.Fboard;

import java.util.List;

public interface FboardService {
    /**
     * 查询所有
     * @return
     */
    List<Fboard> findAllFboard();


    Fboard findByFboardId(long fboardId);
}
