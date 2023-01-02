package com.example.addressservice.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.addressservice.model.entity.Requests;

public interface RequestsRepository extends JpaRepository<Requests, Long> {

}
