package com.latou.gym.mapper;

import com.latou.gym.domain.Side;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SideMapper {

    void addSide(Side side);
    void deleteSide(int sideId);
    void updateSide(int sideId);
    Side getSideByName(String name);
    List<Side> getAllSide();

}
