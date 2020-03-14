package com.latou.gym.domain;

import lombok.Data;

import java.io.Serializable;
@Data
public class Fboard implements Serializable {

    private long fboardId;
    private String fboardName;
    private String fboardImg;

}
