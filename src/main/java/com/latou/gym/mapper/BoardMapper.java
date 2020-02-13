package com.latou.gym.mapper;

import com.latou.gym.domain.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    /**
     * 增
     */
    void addBoard(Board board);

    /**
     * 删
     * @param id
     */
    void deledeBoard(long id);

    /**
     * 查
     * @return
     */
    List<Board> findAllBoard();
}
