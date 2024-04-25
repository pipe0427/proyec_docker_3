package com.search.search.service;

import com.search.search.model.Person;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IPersonService {
    public ResponseEntity<List<Person>> searchPerson();

    public ResponseEntity<Person> searchPersonById(Long id);
}
