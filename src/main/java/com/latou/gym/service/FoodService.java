package com.latou.gym.service;

import com.latou.gym.domain.Food;

import java.util.List;

public interface FoodService {

    /**
     * 根据id返回食物
     * @param foodId
     * @return
     */
    Food findFoodById(long foodId);

    void addFood(Food food);

    /**
     * 更新
     * @param food
     */
    void updateFood(Food food);

    /**
     * 返回所有食物信息
     * @return
     */
    List<Food> findAllFood();

    /**
     * 根据分类查询食物
     * @return
     */
    List<Food> findFoodByFboardId(long foodBoardId);


    void deleteFood(long foodId);

    List<Food> search(String foodName);
    /**
     * 食物数量
     * @return
     */
    int countFood();
}
