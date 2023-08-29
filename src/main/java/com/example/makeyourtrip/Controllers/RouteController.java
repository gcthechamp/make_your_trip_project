package com.example.makeyourtrip.Controllers;

import com.example.makeyourtrip.RequestDtos.AddRouteDto;
import com.example.makeyourtrip.Services.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/route")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @PostMapping("/add")
    public String addRoute(@RequestBody AddRouteDto addRouteDto)
    {
        return routeService.addRoute(addRouteDto);
    }



}
