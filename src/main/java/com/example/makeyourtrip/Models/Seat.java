package com.example.makeyourtrip.Models;


import com.example.makeyourtrip.Enums.SeatType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "seats")
public class Seat {

    @Id
    private Integer seatId;

    private String seatNo;

    private SeatType seatType;

    private Integer price;


    @ManyToOne
    @JoinColumn
    private Transport transport;

}
