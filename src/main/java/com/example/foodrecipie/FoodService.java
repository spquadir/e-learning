package com.example.foodrecipie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class FoodService {


    public String getRecipeDataFromAPI(){
        System.out.println("inside service");

        // data to be retrieved from another system
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("www.themealdb.com/api/json/v1/1/filter.php?i=chicken_breast"))
                .header("X-RapidAPI-Key","34b01e5a99mshd7a281b0ff01c09p1e8427jsnba0f76bfb0d0")
                .header("X-RapidAPI-Host","edamam-edamam-nutrition-analysis.p.rapidapi.com")
                .build();

        HttpResponse<String> response = null;
        try {
             response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        }catch (Exception e){
            System.out.println("exception occurred");
        }

       return response.body();
    }
}
