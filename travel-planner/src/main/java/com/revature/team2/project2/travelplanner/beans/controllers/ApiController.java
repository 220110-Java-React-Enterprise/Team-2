package com.revature.team2.project2.travelplanner.beans.controllers;

import java.io.InputStream;
import java.util.Properties;

import javax.annotation.PostConstruct;

<<<<<<< Updated upstream
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.team2.project2.travelplanner.beans.models.Currency;

import org.springframework.http.MediaType;
=======
>>>>>>> Stashed changes
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
<<<<<<< Updated upstream
import okhttp3.ResponseBody;
=======
>>>>>>> Stashed changes

@RestController
@RequestMapping("/api")
@Slf4j
//TODO parse API request parameters from user
//TODO geocoding API for cities -> lat/lon?
public class ApiController {
    private String keyNinja;
    private String keyWeather;


    /**
     * GET request for the Currency Converter API.
     */
    @GetMapping("/convert")
    public void convertRequest() {
        try {
            // client to do req/resp through
            OkHttpClient client = new OkHttpClient();

            // the request information
            Request request = new Request.Builder()
<<<<<<< Updated upstream
                    .url(String.format("https://api.api-ninjas.com/v1/convertcurrency?want=%s&have=%s&amount=%s", want, have, amount))
=======
                    .url("https://api.api-ninjas.com/v1/convertcurrency?want=EUR&have=USD&amount=5000")
>>>>>>> Stashed changes
                    .get()
                    .addHeader("x-api-key", keyNinja)
                    .build();

            // response that holds response information
            Response response = client.newCall(request).execute();

            // convert response body to a "readable" string
            System.out.println(response.body().string());

        } catch (Exception e) {
            log.error("okhttp request error", e);
        }
    }


    /**
     * GET request for the Weather API.
     */
<<<<<<< Updated upstream
    // TODO parse request parameters from user
    // TODO geocoding API for cities -> lat/lon?
    @GetMapping(value = "/weather", produces = { MediaType.APPLICATION_JSON_VALUE })
=======
    @GetMapping("/weather")
>>>>>>> Stashed changes
    public void weatherRequest() {
        try {
            // client to do req/resp through
            OkHttpClient client = new OkHttpClient();
<<<<<<< Updated upstream

=======
            
>>>>>>> Stashed changes
            // the request information
            Request request = new Request.Builder()
                    .url("https://api.openweathermap.org/data/2.5/forecast?id=524901&appid=" + keyWeather)
                    .get()
                    .build();

            // response that holds response information
            Response response = client.newCall(request).execute();

            // convert response body to a "readable" string
            System.out.println(response.body().string());

        } catch (Exception e) {
            log.error("okhttp request error", e);
        }
    }


    /**
     * Retrieve the apikey information from the respective properties file.
     * @return apikey
     */
    // indicates that the method should be called exactly once after dependencies are injected
    @PostConstruct
    private void loadApiKeys() {
        try {
            // properties file
            Properties props = new Properties();

            // retrive class loader from current thread
            ClassLoader loader = Thread.currentThread().getContextClassLoader();

            // input stream tied to file (from classpath)
            InputStream input = loader.getResourceAsStream("api-key.properties");

            // load the properties
            props.load(input);

            // retrieve the api key
            keyNinja = props.getProperty("api-key-ninja");
            keyWeather = props.getProperty("api-key-weather");

        } catch (Exception e) {
            log.error("api-key retrieval error", e);
        }
    }
}
