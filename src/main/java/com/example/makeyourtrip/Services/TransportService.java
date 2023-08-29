package com.example.makeyourtrip.Services;

import com.example.makeyourtrip.Enums.City;
import com.example.makeyourtrip.Enums.ModeOfTransport;
import com.example.makeyourtrip.Models.Routes;
import com.example.makeyourtrip.Models.Transport;
import com.example.makeyourtrip.Repositories.RouteRepository;
import com.example.makeyourtrip.Repositories.TransportRepository;
import com.example.makeyourtrip.RequestDtos.AddTransportDto;
import com.example.makeyourtrip.ResponseDtos.FlightResult;
import com.example.makeyourtrip.Transformers.TransportTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.RouteMatcher;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransportService {

    @Autowired
    private TransportRepository transportRepository;

    @Autowired
    private RouteRepository routeRepository;
    public String addTransport(AddTransportDto addTransportDto) throws Exception
    {
        Optional<Routes> optional = routeRepository.findById(addTransportDto.getRouteId());
        if(!optional.isPresent())
            throw new Exception("Route doesn't exist");

        Transport transportObj = TransportTransformer.convertDtoToEntity(addTransportDto);
        Routes routeObj = optional.get();

        //Set FK constraints
        transportObj.setRoute(routeObj);

        routeObj.getTransportList().add(transportObj);

        //I am only saving the parent. Since there is bidirectional mapping, child will automatically get saved.
        routeRepository.save(routeObj);

        return "Transport added successfully";
    }

    public List<FlightResult> searchFlight(City fromCity, City toCity, ModeOfTransport modeOfTransport, LocalDate journeyDate)
    {
        List<FlightResult> flightResults = new ArrayList<>();

        List<Routes> routes = routeRepository.findRoutesByFromCityAndToCityAndModeOfTransport(fromCity,toCity,modeOfTransport);

        for(Routes route : routes)
        {
            List<Transport> transportList = route.getTransportList();
            for(Transport transport : transportList)
            {
                if(transport.getJourneyDate().equals(journeyDate))
                {
                    FlightResult flightResult = FlightResult.builder()
                            .startTime(transport.getStartTime())
                            .journeyDate(journeyDate)
                            .journeyTime(transport.getJourneyTime())
                            .companyName(transport.getCompanyName())
                            .build();

                    flightResults.add(flightResult);
                }
            }
        }
        return flightResults;
    }
}
