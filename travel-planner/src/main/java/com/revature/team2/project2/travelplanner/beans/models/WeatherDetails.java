package com.revature.team2.project2.travelplanner.beans.models;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Helper class to parse Weather API response.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = { "dt", "clouds", "wind", "visibility", "pop", "rain", "snow", "sys" })
public class WeatherDetails {
    // pulled from object mapper directly
    private String dt_txt;

    // pulled from special unpackNested helper function
    private Double temp;
    private Double tempMin;
    private Double tempMax;
    private Integer humidity;

    // pulled from a nested array
    private WeatherDetailsDetails[] weather;

    /**
     * Breaks apart the weather API response to pull what we want from nested
     * objects.
     * 
     * @param list the object being broken apart
     */
    @JsonProperty("main")
    private void unpackNested(Map<String, Object> main) {
        // retrieve the temp property from the main object
        Object obj = main.get("temp");

        // parse temp based on if temp is a Double or an Integer
        if (obj.getClass() == Double.class) {
            this.temp = (Double) obj;
        } else if (obj.getClass() == Integer.class) {
            this.temp = ((Integer) obj).doubleValue();
        }

        // retrieve the temp_min property from the main object
        obj = main.get("temp_min");

        // parse temp_min based on if temp is a Double or an Integer
        if (obj.getClass() == Double.class) {
            this.tempMin = (Double) obj;
        } else if (obj.getClass() == Integer.class) {
            this.tempMin = ((Integer) obj).doubleValue();
        }

        // retrieve the temp_max property from the main object
        obj = main.get("temp_max");

        // parse temp_max based on if temp is a Double or an Integer
        if (obj.getClass() == Double.class) {
            this.tempMax = (Double) obj;
        } else if (obj.getClass() == Integer.class) {
            this.tempMax = ((Integer) obj).doubleValue();
        }

        // retrieve the humidity property from the main object
        obj = main.get("humidity");

        // parse humidity based on if temp is a Double or an Integer
        if (obj.getClass() == Double.class) {
            this.humidity = ((Double) obj).intValue();
        } else if (obj.getClass() == Integer.class) {
            this.humidity = (Integer) obj;
        }
    }
}