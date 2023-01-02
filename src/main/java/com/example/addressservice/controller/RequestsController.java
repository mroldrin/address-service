package com.example.addressservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.addressservice.model.entity.Requests;
import com.example.addressservice.model.repository.RequestsRepository;

@RestController
@RequestMapping("api/requests")
public class RequestsController extends GenericController<Requests, Long, RequestsRepository>{
    


}
