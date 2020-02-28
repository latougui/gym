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

    private String essayCreateTime;

    private String essayUpdateTime;

    private long essayViewCount;

    private String essayUrl;

}
