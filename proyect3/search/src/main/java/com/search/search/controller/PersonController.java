package com.search.search.controller;

import com.search.search.model.Person;
import com.search.search.service.IPersonService;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/")
public class PersonController {
    public IPersonService service;

    @GetMapping("persons")
    public ResponseEntity<List<Person>> getAllPersons() {
        return service.searchPerson();
    }

}
