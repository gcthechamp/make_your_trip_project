package com.example.makeyourtrip.RequestDtos;

import com.example.makeyourtrip.Enums.City;
import com.example.makeyourtrip.Enums.ModeOfTransport;
import lombok.Data;

@Data
public class AddRouteDto {
    private City fromCity;
    private City toCity;
    private String stopsInBetween;
    private ModeOfTransport modeOfTransport;

}
