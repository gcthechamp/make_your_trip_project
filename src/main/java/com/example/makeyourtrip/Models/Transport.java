package com.example.makeyourtrip.Models;


import com.example.makeyourtrip.Enums.City;
import com.example.makeyourtrip.Enums.ModeOfTransport;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "transport")
@Data
public class Transport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transportId;

    private ModeOfTransport modeOfTransport;

    private LocalDate journeyDate;

    private LocalTime startTime;

    private double journeyTime;

    @ManyToOne
    @JoinColumn
    private Routes route;

    @OneToMany(mappedBy = "transport",cascade = CascadeType.ALL)
    List<Seat> seatList = new ArrayList<>();

    @OneToMany(mappedBy = "transport",cascade = CascadeType.ALL)
    List<Booking> bookings = new ArrayList<>();

}
