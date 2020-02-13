package com.latou.gym.mapper;

import com.latou.gym.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserMapper {
    public User findById(Long id);
}
