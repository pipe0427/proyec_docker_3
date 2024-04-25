package com.delete.delete.service;

import com.delete.delete.model.Person;
import com.delete.delete.repository.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService implements IPersonService {
    @Autowired
    private IPersonRepository repository;

    private List<Person> persons = new ArrayList<>();

    @Override
    @Transactional
    public ResponseEntity<List<Person>> deletePerson(Long id) {
        try {
            repository.deleteById(id);
            return new ResponseEntity<>(persons, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
