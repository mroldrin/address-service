package com.example.addressservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.addressservice.model.entity.Carriers;
import com.example.addressservice.model.repository.CarriersRepository;

@RestController
@RequestMapping("api/carriers")
public class CarriersController extends GenericController<Carriers, Long, CarriersRepository>{
    


}
