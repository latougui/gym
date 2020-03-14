package com.latou.gym.domain;

import lombok.Data;

import java.io.Serializable;
@Data
public class Side implements Serializable {
    private int sideId;
    private String sideName;
    private String sideUrl;
    private String sideDesc;
}
