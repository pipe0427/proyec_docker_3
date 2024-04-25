package com.search.search.service;

import com.search.search.model.Person;
import com.search.search.repository.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService implements IPersonService {
    @Autowired
    private IPersonRepository repository;

    private List<Person> persons = new ArrayList<>();

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<List<Person>> searchPerson() {
        try {
            persons = (List<Person>) repository.findAll();
            return new ResponseEntity<>(persons, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(persons, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @Override
    public ResponseEntity<Person> searchPersonById(Long id) {
        try {
            Optional<Person> person = repository.findById(id);
            if(person.isPresent()) {
                return new ResponseEntity<>(person.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
