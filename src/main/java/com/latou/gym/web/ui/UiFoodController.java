package com.latou.gym.web.ui;

import com.latou.gym.domain.Board;
import com.latou.gym.domain.Essay;
import com.latou.gym.domain.Fboard;
import com.latou.gym.domain.Food;
import com.latou.gym.service.FboardService;
import com.latou.gym.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Iterator;
import java.util.List;

@Controller
public class UiFoodController {

    @Autowired
    FboardService fboardService;

    @Autowired
    FoodService foodService;

    @GetMapping(value = "/food")
    public String food(Model model){
        List<Fboard> fboards = fboardService.findAllFboard();
        model.addAttribute("fboards",fboards);

        return "ui/food";
    }

    @GetMapping(value = "/food/{fboardId}")
    public String getFoodList(@PathVariable String fboardId ,Model model){

        Fboard fboard = fboardService.findByFboardId(Long.parseLong(fboardId));
        List<Food> foods = foodService.findFoodByFboardId(Long.parseLong(fboardId));
        model.addAttribute("fboard",fboard);
        model.addAttribute("foods",foods);

        return "ui/food_list";
    }

    @GetMapping(value = "/food/search")
    public String search(String foodName, Model model){

        List<Food> foods = foodService.search(foodName);
        Fboard fboard = new Fboard();
        fboard.setFboardName("查询结果");
        model.addAttribute("foods",foods);
        model.addAttribute("fboard",fboard);
        return "ui/food_list";
    }


    @GetMapping(value = "/food/detail/{foodId}")
    public String getFood(@PathVariable String foodId,Model model){
        Food food = foodService.findFoodById(Long.parseLong(foodId));
        Fboard fboard = fboardService.findByFboardId(food.getFoodBoardId());
        model.addAttribute("food",food);
        model.addAttribute("fboard",fboard);
        return "ui/food_detail";
    }
}
