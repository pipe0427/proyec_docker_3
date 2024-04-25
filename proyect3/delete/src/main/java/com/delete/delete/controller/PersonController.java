package com.delete.delete.controller;

import com.delete.delete.model.Person;
import com.delete.delete.service.IPersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/")
public class PersonController {
    public IPersonService service;
    
    @DeleteMapping("person/{id}")
    public ResponseEntity<List<Person>> deletePerson(@PathVariable Long id) {
        return service.deletePerson(id);
    }
}
