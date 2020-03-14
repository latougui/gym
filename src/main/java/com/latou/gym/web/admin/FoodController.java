package com.latou.gym.web.admin;

import com.latou.gym.domain.Fboard;
import com.latou.gym.domain.Food;
import com.latou.gym.mapper.FoodMapper;
import com.latou.gym.service.FboardService;
import com.latou.gym.service.FoodService;
import com.latou.gym.util.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/admin/food")
public class FoodController {

    @Autowired
    FoodService foodService;
    @Autowired
    FboardService fboardService;

    @GetMapping("/list")
    public String foodList(Model model){
        List<Food> foods = foodService.findAllFood();
        List<Fboard> fboards = fboardService.findAllFboard();
        model.addAttribute("foods",foods);
        model.addAttribute("fboards",fboards);
        return "admin/food";
    }

    @PostMapping("/publish")
    @ResponseBody
    public APIResponse foodPublish(HttpServletRequest request){
        String foodId = request.getParameter("foodId");
        String foodName = request.getParameter("foodName");
        String foodBoardId = request.getParameter("foodBoardId");
        String foodMessage = request.getParameter("foodMessage");
        float foodEnergy = Float.parseFloat(request.getParameter("foodEnergy"));
        float foodCarbo = Float.parseFloat(request.getParameter("foodCarbo"));
        float foodFat = Float.parseFloat(request.getParameter("foodFat"));
        float foodProtein = Float.parseFloat(request.getParameter("foodProtein"));

        String foodImg1 = request.getParameter("foodImg1");
        String foodImg2 = request.getParameter("foodImg2");

        System.out.println("foodImg1:"+foodImg1);
        System.out.println("foodImg2:"+foodImg2);


        Food food =new Food();

        if(!foodId.isEmpty()){
            food = foodService.findFoodById(Long.parseLong(foodId));
        }

        food.setFoodBoardId(Long.parseLong(foodBoardId));
        food.setFoodCarbo(foodCarbo);
        food.setFoodEnergy(foodEnergy);
        food.setFoodFat(foodFat);
        food.setFoodProtein(foodProtein);
        if(!foodImg1.isEmpty()){
            System.out.println("foodImg1:"+foodImg1);
            food.setFoodImg(foodImg1);
        }else{
            food.setFoodImg(foodImg2);
        }

        food.setFoodMessage(foodMessage);
        food.setFoodName(foodName);

        if(!foodId.isEmpty()){
            foodService.updateFood(food);
        }else{
            foodService.addFood(food);
        }

       return APIResponse.success();
    }

    @GetMapping("/delete")
    @ResponseBody
    public APIResponse foodDelete(long foodId){
        // long id = Long.parseLong(essayId);
        foodService.deleteFood(foodId);
        return APIResponse.success();
    }
}
