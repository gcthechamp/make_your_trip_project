package com.example.makeyourtrip.Transformers;

import com.example.makeyourtrip.Models.Routes;
import com.example.makeyourtrip.RequestDtos.AddRouteDto;

public class RouteTransformer {

    public static Routes convertDtoToEntity(AddRouteDto addRouteDto)
    {
        Routes routeObj = Routes.builder().fromCity(addRouteDto.getFromCity()).toCity(addRouteDto.getToCity())
                .listOfStopInBetween(addRouteDto.getStopsInBetween())
                .modeOfTransport(addRouteDto.getModeOfTransport()).build();
        return routeObj;
    }
}
