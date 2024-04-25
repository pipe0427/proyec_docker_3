package com.create.create.controller;

import com.create.create.model.Person;
import com.create.create.service.IPersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/")
public class PersonController {
    public IPersonService service;

    @PostMapping("persons")
    public ResponseEntity<List<Person>> savePerson(@RequestParam("name") String name,@RequestParam("surname") String surname, @RequestParam("phone") String phone) {
        Person person = new Person();
        person.setName(name);
        person.setSurname(surname);
        person.setPhone(phone);
        return service.savePerson(person);
    }
}
