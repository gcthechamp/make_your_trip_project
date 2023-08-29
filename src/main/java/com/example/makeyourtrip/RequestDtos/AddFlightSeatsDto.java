package com.example.makeyourtrip.RequestDtos;

import lombok.Data;

@Data
public class AddFlightSeatsDto {

    private Integer transportId;
    private Integer noOfEconomySeats;
    private Integer noOfBusinessSeats;
    private Integer priceOfBusinessSeat;
    private Integer priceOfEconomySeat;
}
