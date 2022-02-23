package com.revature.team2.project2.travelplanner.beans.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = { "name", "local_names", "country", "state" })
public class Geo {
    private Double lat;
    private Double lon;
}
