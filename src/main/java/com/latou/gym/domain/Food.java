package com.latou.gym.domain;

import lombok.Data;

import java.io.Serializable;
@Data
public class Food implements Serializable {
     private long foodId;
     private long foodBoardId;
     private String foodImg;
     private String foodName;
     private String foodMessage;
     private float foodEnergy;
     private float foodCarbo;
     private float foodFat;
     private float foodProtein;

}
