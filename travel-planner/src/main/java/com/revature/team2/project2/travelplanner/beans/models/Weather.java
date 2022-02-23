package com.revature.team2.project2.travelplanner.beans.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Object for storing the Weather API response.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = { "cod", "message", "cnt", "city" })
public class Weather {
    private WeatherDetails[] list;
}
