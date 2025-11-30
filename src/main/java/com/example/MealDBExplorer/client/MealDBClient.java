package com.example.MealDBExplorer.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

@Component
public class MealDBClient {

    private final RestTemplate restTemplate;

    @Value("${mealdb.api.base-url}")
    private String BASE_URL;

    public MealDBClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Map<String, Object>> searchMeals(String query) {
        try {
            String encoded = URLEncoder.encode(query, StandardCharsets.UTF_8);
            String url = BASE_URL + "/search.php?s=" + encoded;
            Map<String, Object> response = restTemplate.getForObject(url, Map.class);
            return (List<Map<String, Object>>) response.get("meals");
        } catch (Exception e) {
            return null;
        }
    }

    public List<Map<String, Object>> getMealById(String id) {
        String url = BASE_URL + "/lookup.php?i=" + id;
        Map<String, Object> response = restTemplate.getForObject(url, Map.class);
        return (List<Map<String, Object>>) response.get("meals");
    }

    public List<Map<String, Object>> getRandomMeal() {
        String url = BASE_URL + "/random.php";
        Map<String, Object> response = restTemplate.getForObject(url, Map.class);
        return (List<Map<String, Object>>) response.get("meals");
    }

    public List<Map<String, Object>> listCategories() {
        String url = BASE_URL + "/list.php?c=list";
        Map<String, Object> response = restTemplate.getForObject(url, Map.class);
        return (List<Map<String, Object>>) response.get("meals");
    }
}
