package com.example.makeyourtrip.Controllers;

import com.example.makeyourtrip.RequestDtos.AddFlightSeatsDto;
import com.example.makeyourtrip.Services.SeatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/seats")
public class SeatController {

    @Autowired
    private SeatService seatService;

    @PostMapping("/add")
    public String addFlightSeats(@RequestBody AddFlightSeatsDto addFlightSeatsDto)
    {
        try {
            String result = seatService.addFlightSeats(addFlightSeatsDto);
            return result;
        }
        catch(Exception e)
        {
            log.error("Add Seats Operation failed because {}",e.getMessage());
            return e.getMessage();
        }
    }

}
