package com.latou.gym.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class Essay implements Serializable {

    private long essayId;

    private long essayBoardId;

    private String essayTitle;

    private String essayContent;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date essayCreateTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date essayUpdateTime;

    private long essayViewCount;

}
