package com.example.makeyourtrip.Services;

import com.example.makeyourtrip.Enums.SeatType;
import com.example.makeyourtrip.Models.Seat;
import com.example.makeyourtrip.Models.Transport;
import com.example.makeyourtrip.Repositories.SeatRepository;
import com.example.makeyourtrip.Repositories.TransportRepository;
import com.example.makeyourtrip.RequestDtos.AddFlightSeatsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SeatService {

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private TransportRepository transportRepository;
    public String addFlightSeats(AddFlightSeatsDto addFlightSeatsDto) throws Exception{

        Optional<Transport> optional = transportRepository.findById(addFlightSeatsDto.getTransportId());

        if(!optional.isPresent())
            throw new Exception("Transport does not exist");

        Transport transportObj = optional.get();

        for(int i=1; i<=addFlightSeatsDto.getNoOfEconomySeats(); i++)
        {
            Seat seat = Seat.builder().seatNo(i+"E")
                    .seatType(SeatType.ECONOMY)
                    .price(addFlightSeatsDto.getPriceOfEconomySeat())
                    .transport(transportObj)
                    .build();

            transportObj.getSeatList().add(seat);
        }

        for(int i=1; i<=addFlightSeatsDto.getNoOfBusinessSeats(); i++)
        {
            Seat seat = Seat.builder().seatNo(i+"B")
                    .seatType(SeatType.BUSINESS)
                    .price(addFlightSeatsDto.getPriceOfBusinessSeat())
                    .transport(transportObj)
                    .build();

            transportObj.getSeatList().add(seat);
        }

        return "All seats have been added to flight successfully";
    }
}
