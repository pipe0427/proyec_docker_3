package com.create.create.service;

import com.create.create.model.Person;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IPersonService {
    public ResponseEntity<List<Person>> savePerson(Person person);
}
