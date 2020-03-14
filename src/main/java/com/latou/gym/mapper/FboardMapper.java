package com.latou.gym.mapper;

import com.latou.gym.domain.Fboard;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FboardMapper {
    /**
     * 查询所有
     * @return
     */
    List<Fboard> findAllFboard();


    Fboard findByBoardId(long fboardId);
}
