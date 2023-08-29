package com.example.makeyourtrip.Controllers;

import com.example.makeyourtrip.Enums.City;
import com.example.makeyourtrip.Enums.ModeOfTransport;
import com.example.makeyourtrip.RequestDtos.AddTransportDto;
import com.example.makeyourtrip.ResponseDtos.FlightResult;
import com.example.makeyourtrip.Services.TransportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/transport")
public class TransportControllers {

    @Autowired
    private TransportService transportService;

    @PostMapping("/add")
    public ResponseEntity addTransport(@RequestBody AddTransportDto addTransportDto)
    {
        try
        {
            String result = transportService.addTransport(addTransportDto);
            return new ResponseEntity(result, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            log.error("Could not add Transport because {}",e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/search-flight")
    public List<FlightResult> searchFlight(@RequestParam("fromCity") City fromCity, @RequestParam("toCity") City toCity,
                                           @RequestParam("modeOfTransport") ModeOfTransport modeOfTransport,
                                           @RequestParam("journeyDate")LocalDate journeyDate)
    {
        return transportService.searchFlight(fromCity,toCity,modeOfTransport,journeyDate);
    }


}
