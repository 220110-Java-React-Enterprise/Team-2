package com.revature.team2.project2.travelplanner.beans.controllers;

import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

import javax.annotation.PostConstruct;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.team2.project2.travelplanner.beans.models.Currency;
import com.revature.team2.project2.travelplanner.beans.models.Geo;
import com.revature.team2.project2.travelplanner.beans.models.Weather;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;


/**
 * Controller to guide consumption of third-party APIs.
 */
@RestController
@RequestMapping("/api")
@Slf4j
public class ApiController {
    private String keyNinja;
    private String keyWeather;


    /**
     * GET request for the Currency Converter API.
     * 
     * @param want   the currency code that you are looking for
     * @param have   the currency code that you currently have
     * @param amount the currency amount to convert
     * @return the converted currency amount
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
                    .url(String.format("https://api.api-ninjas.com/v1/convertcurrency?want=%s&have=%s&amount=%s", want,
                            have, amount))
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
            log.error("api/convert request error", e);
        }

        // return the loaded value, null otherwise
        return new_amount;
    }


    /**
     * GET request for the Weather API.
     * Utilizes an additional call to the Geocoding API
     * for conversion of city to latitude & longitude.
     * 
     * @param cityName    name of city to check for
     * @param stateCode   OPTIONAL, state code for US searches
     * @param countryCode OPTIONAL, country code for city in country search
     * @return JSON string containing data from API response
     */
    // TODO stateCode & countryCode?
    @GetMapping(value = "/weather", produces = { MediaType.APPLICATION_JSON_VALUE })
    public String weatherRequest(@RequestParam String cityName,
            @RequestParam(required = false) Optional<String> stateCode,
            @RequestParam(required = false) Optional<String> countryCode) {

        // the Geo information of where we're going to be looking
        Geo geo = null;

        // thing to return
        String jsonString = null;

        // GEOCODING API CALL
        try {
            // client to do req/resp through
            OkHttpClient client = new OkHttpClient();

            // start building the url for the request
            String url = String.format("http://api.openweathermap.org/geo/1.0/direct?q=%s", cityName);

            // add optional stuff to the request if it exists
            if (stateCode.isPresent()) {
                url += "," + stateCode;
            }
            if (countryCode.isPresent()) {
                url += "," + countryCode;
            }

            // tack on the rest of the url
            url += String.format("&limit=%d&appid=%s", 1, keyWeather);

            // build the request

            Request request = new Request.Builder()
                    .url(url)
                    .get()
                    .build();

            // response that holds response information
            ResponseBody responseBody = client.newCall(request).execute().body();

            // map in the response
            ObjectMapper mapper = new ObjectMapper();
            Geo[] geos = mapper.readValue(responseBody.string(), Geo[].class);

            // set the first result to be the Geo we care about
            geo = geos[0];

        } catch (Exception e) {
            log.error("api/weather GEO request error", e);
        }

        // WEATHER API CALL
        // only done if the Geocoding request was successful
        if (geo != null) {
            try {
                // client to do req/resp through
                OkHttpClient client = new OkHttpClient();

                // the request information
                Request request = new Request.Builder()
                        .url(String.format(
                                "https://api.openweathermap.org/data/2.5/forecast?lat=%f&lon=%f&units=imperial&appid=%s",
                                geo.getLat(), geo.getLon(), keyWeather))
                        .get()
                        .build();

                // response that holds response information
                ResponseBody responseBody = client.newCall(request).execute().body();

                // create a Weather object to map into
                Weather weather = new ObjectMapper()
                        .readValue(responseBody.string(), Weather.class);

                // turn the Weather object into a JSON string
                ObjectMapper mapper = new ObjectMapper();
                jsonString = mapper.writeValueAsString(weather);

            } catch (Exception e) {
                log.error("api/weather WEATHER request error", e);
            }
        }

        // return the loaded object as a JSON string, null otherwise
        return jsonString;
    }


    /**
     * Retrieve the apikey information from the respective properties file.
     * @return apikey
     */
    @PostConstruct // called exactly once after dependencies are injected
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
