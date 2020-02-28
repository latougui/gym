package com.latou.gym.service;

import com.latou.gym.domain.Board;

import java.util.List;

public interface BoardService {
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

    Board findBoardByBoardId(long boardId);
}
