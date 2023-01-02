package com.example.addressservice.controller;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.addressservice.model.entity.GenericEntity;


public class GenericController<T extends GenericEntity<ID>, ID, R extends JpaRepository<T, ID>> {

    @Autowired
    R jpaRepository;

    @GetMapping
    protected List<T> findAll() {
        return jpaRepository.findAll();
    }

    @GetMapping("/{id}")
    protected ResponseEntity<T> getById(@PathVariable ID id) {
        Optional<T> optional = jpaRepository.findById(id);
        return optional.isPresent() 
            ? ResponseEntity.status(HttpStatus.OK).body(optional.get()) 
            : ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PostMapping
    protected ResponseEntity<T> create(@RequestBody T arg) {
        return this.save(arg.getId() == null, arg);
    }

    @PutMapping
    protected ResponseEntity<T> update(@RequestBody T arg) {
        return this.save(this.exists(arg.getId()), arg);         
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    protected ResponseEntity<String> delete(@PathVariable ID id) {

        if (!this.exists(id)) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("{\"status\" : \"NOT FOUND\"}");
        }

        jpaRepository.deleteById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("{\"status\" : \"OK\"}");
    }

    protected List<T> findWhere(Predicate<T> where) {
        return jpaRepository.findAll()
                .stream()
                .filter(where)
                .toList();
    }

    private boolean exists(ID id) {
        if(id == null){
            return false;
        }
        return jpaRepository.findById(id).isPresent();
    }

    private ResponseEntity<T> save(boolean p, T arg) {
        return p ? ResponseEntity.status(HttpStatus.CREATED).body(jpaRepository.save(arg))
                 : ResponseEntity.badRequest().build();
    }
}
