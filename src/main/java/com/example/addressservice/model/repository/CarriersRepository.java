package com.example.addressservice.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.addressservice.model.entity.Carriers;

public interface CarriersRepository extends JpaRepository<Carriers, Long> {

}
