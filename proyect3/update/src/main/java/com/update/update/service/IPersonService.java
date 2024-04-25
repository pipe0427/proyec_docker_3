package com.update.update.service;

import com.update.update.model.Person;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IPersonService {
    
    public ResponseEntity<List<Person>> updatePerson(Person person, Long id);
}
