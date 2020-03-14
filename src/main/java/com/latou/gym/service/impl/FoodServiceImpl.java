package com.latou.gym.service.impl;

import com.latou.gym.domain.Food;
import com.latou.gym.mapper.FoodMapper;
import com.latou.gym.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    FoodMapper foodMapper;

    @Override
    public Food findFoodById(long foodId) {
        return foodMapper.findFoodById(foodId);
    }

    @Override
    public void addFood(Food food) {
        foodMapper.addFood(food);
    }

    @Override
    public void updateFood(Food food) {
        foodMapper.updateFood(food);
    }

    @Override
    public List<Food> findAllFood() {
        return foodMapper.findAllFood();
    }

    @Override
    public List<Food> findFoodByFboardId(long foodBoardId) {
        return foodMapper.findFoodByFboardId(foodBoardId);
    }

    @Override
    public void deleteFood(long foodId) {
        foodMapper.deleteFood(foodId);
    }

    @Override
    public List<Food> search(String foodName) {
        return foodMapper.search(foodName);
    }

    @Override
    public int countFood() {
        return foodMapper.countFood();
    }


}
