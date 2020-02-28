package com.latou.gym.service.impl;

import com.latou.gym.domain.Board;
import com.latou.gym.mapper.BoardMapper;
import com.latou.gym.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardMapper boardMapper;

    @Override
    public void addBoard(Board board) {

    }

    @Override
    public void deledeBoard(long id) {

    }

    @Override
    public List<Board> findAllBoard() {
        return boardMapper.findAllBoard();
    }

    @Override
    public Board findBoardByBoardId(long boardId) {
        return boardMapper.findBoardByBoardId(boardId);
    }
}
