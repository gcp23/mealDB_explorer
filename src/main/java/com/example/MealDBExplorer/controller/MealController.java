package com.example.MealDBExplorer.controller;

import com.example.MealDBExplorer.model.Meal;
import com.example.MealDBExplorer.service.MealService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/meals")
@CrossOrigin("*")
public class MealController {

    private final MealService mealService;

    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping("/search")
    public List<Meal> searchMeals(@RequestParam String q) {
        return mealService.searchMeals(q);
    }

    @GetMapping("/{id}")
    public Meal getMeal(@PathVariable String id) {
        return mealService.getMealById(id);
    }

    @GetMapping("/random")
    public Meal getRandomMeal() {
        return mealService.getRandomMeal();
    }

    @GetMapping("/categories")
    public List<String> getCategories() {
        return mealService.getCategories();
    }
}
