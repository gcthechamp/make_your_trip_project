package com.example.makeyourtrip.Models;


import com.example.makeyourtrip.Enums.City;
import com.example.makeyourtrip.Enums.ModeOfTransport;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "routes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Routes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer routeId;

    private City fromCity;

    private City toCity;

    private String listOfStopInBetween;

    private Date travelDate;

    private ModeOfTransport modeOfTransport;


}
