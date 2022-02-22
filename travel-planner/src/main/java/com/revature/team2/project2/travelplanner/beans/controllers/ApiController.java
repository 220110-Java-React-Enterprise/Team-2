package com.revature.team2.project2.travelplanner.beans.controllers;

import java.io.InputStream;
import java.util.Properties;

import javax.annotation.PostConstruct;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.team2.project2.travelplanner.beans.models.Currency;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

@RestController
@RequestMapping("/api")
@Slf4j
public class ApiController {
    private String keyNinja;
    private String keyWeather;

    /**
     * GET request for the Currency Converter API.
     */
    @GetMapping(value = "/convert", produces = { MediaType.APPLICATION_JSON_VALUE })
    public Double convertRequest(@RequestParam String want, @RequestParam String have, @RequestParam String amount) {
        // thing to return
        Double new_amount = null;

        try {
            // client to do req/resp through
            OkHttpClient client = new OkHttpClient();

            // the request information
            Request request = new Request.Builder()
                    .url(String.format("https://api.api-ninjas.com/v1/convertcurrency?want=%s&have=%s&amount=%s", want, have, amount))
                    .get()
                    .addHeader("x-api-key", keyNinja)
                    .build();

            // response body that holds response information
            ResponseBody responseBody = client.newCall(request).execute().body();

            // create an object mapper
            ObjectMapper mapper = new ObjectMapper();

            // map the response to our entity
            Currency currency = mapper.readValue(responseBody.string(), Currency.class);

            // update the value to return
            new_amount = currency.getNew_amount();

        } catch (Exception e) {
            log.error("okhttp request error", e);
        }

        // return the loaded value, null otherwise
        return new_amount;
    }

    /**
     * GET request for the Weather API.
     */
    // TODO parse request parameters from user
    // TODO geocoding API for cities -> lat/lon?
    @GetMapping(value = "/weather", produces = { MediaType.APPLICATION_JSON_VALUE })
    public void weatherRequest() {
        try {
            // client to do req/resp through
            OkHttpClient client = new OkHttpClient();

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
     * 
     * @return apikey
     */
    // indicates that the method should be called exactly once after dependencies
    // are injected
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
