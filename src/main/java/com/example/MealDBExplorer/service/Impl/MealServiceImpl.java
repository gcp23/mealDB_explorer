package com.example.MealDBExplorer.service.Impl;

import com.example.MealDBExplorer.client.MealDBClient;
import com.example.MealDBExplorer.model.Meal;
import com.example.MealDBExplorer.service.MealService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class MealServiceImpl implements MealService {

    private final MealDBClient mealDbClient;

    public MealServiceImpl(MealDBClient mealDbClient) {
        this.mealDbClient = mealDbClient;
    }

    @Override
    @Cacheable(value = "searchMeals", key = "#query")
    public List<Meal> searchMeals(String query) {
        List<Map<String, Object>> response = mealDbClient.searchMeals(query);
        return mapToMeals(response);
    }

    @Override
    @Cacheable(value = "mealById", key = "#id")
    public Meal getMealById(String id) {
        List<Map<String, Object>> response = mealDbClient.getMealById(id);
        List<Meal> meals = mapToMeals(response);
        return meals.isEmpty() ? null : meals.get(0);
    }

    @Override
    @Cacheable("randomMeal")
    public Meal getRandomMeal() {
        List<Map<String, Object>> response = mealDbClient.getRandomMeal();
        List<Meal> meals = mapToMeals(response);
        return meals.isEmpty() ? null : meals.get(0);
    }

    @Override
    @Cacheable("categories")
    public List<String> getCategories() {
        List<Map<String, Object>> response = mealDbClient.listCategories();
        List<String> list = new ArrayList<>();

        if (response != null) {
            for (Map<String, Object> m : response) {
                list.add((String) m.get("strCategory"));
            }
        }
        return list;
    }

    private List<Meal> mapToMeals(List<Map<String, Object>> data) {
        List<Meal> meals = new ArrayList<>();
        if (data == null) return meals;

        for (Map<String, Object> map : data) {
            Meal meal = new Meal();
            meal.setIdMeal((String) map.get("idMeal"));
            meal.setStrMeal((String) map.get("strMeal"));
            meal.setStrCategory((String) map.get("strCategory"));
            meal.setStrArea((String) map.get("strArea"));
            meal.setStrInstructions((String) map.get("strInstructions"));
            meal.setStrMealThumb((String) map.get("strMealThumb"));
            meal.setStrYoutube((String) map.get("strYoutube"));
            meals.add(meal);
        }
        return meals;
    }
}
