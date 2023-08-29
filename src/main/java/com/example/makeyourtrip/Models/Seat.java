package com.example.makeyourtrip.Models;


import com.example.makeyourtrip.Enums.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "seats")
public class Seat {

    @Id
    private Integer seatId;

    private String seatNo;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    private Integer price;


    @ManyToOne
    @JoinColumn
    private Transport transport;

}
