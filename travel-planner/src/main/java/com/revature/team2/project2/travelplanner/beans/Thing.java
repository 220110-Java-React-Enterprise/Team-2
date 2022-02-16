package com.revature.team2.project2.travelplanner.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "things")
public class Thing {
    @Id
    @Column(name = "thing_id")
    private Integer id;
    
    @Column(name = "some_string")
    private String someString;
}
