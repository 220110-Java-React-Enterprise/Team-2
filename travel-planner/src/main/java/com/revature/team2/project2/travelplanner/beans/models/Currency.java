package com.revature.team2.project2.travelplanner.beans.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Object for storing the Currency Converter API response.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Currency {
    private Double new_amount;
    private String new_currency;
    private String old_currency;
    private Double old_amount;
}
