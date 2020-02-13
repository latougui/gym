package com.latou.gym.domain;

import lombok.Data;

import java.io.Serializable;
@Data
public class Board implements Serializable {

    private long boardId;
    private String boardDesc;
    private String boardName;
    private long boardPostNum;
}
