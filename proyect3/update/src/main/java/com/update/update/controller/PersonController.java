package com.update.update.controller;

import com.update.update.model.Person;
import com.update.update.service.IPersonService;

import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/")
public class PersonController {
    public IPersonService service;

    
    @PutMapping("persons/{personId}")
    public ResponseEntity<List<Person>> updatePerson(@RequestParam("name") String name,@RequestParam("surname") String surname, @RequestParam("phone") String phone,@PathVariable Long personId) {
        Person person = new Person();
        person.setName(name);
        person.setSurname(surname);
        person.setPhone(phone);
        return service.updatePerson(person,personId);
    }

}
