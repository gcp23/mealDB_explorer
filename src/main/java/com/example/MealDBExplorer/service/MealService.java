package com.example.MealDBExplorer.service;

import com.example.MealDBExplorer.model.Meal;

import java.util.List;

public interface MealService {
    List<Meal> searchMeals(String query);
    Meal getMealById(String id);
    Meal getRandomMeal();
    List<String> getCategories();
}
