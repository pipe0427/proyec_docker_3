package com.delete.delete.service;

import com.delete.delete.model.Person;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IPersonService {
    public ResponseEntity<List<Person>> deletePerson(Long id);
}
