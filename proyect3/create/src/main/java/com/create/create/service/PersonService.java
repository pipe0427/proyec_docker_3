package com.create.create.service;

import com.create.create.model.Person;
import com.create.create.repository.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService implements IPersonService {
    @Autowired
    private IPersonRepository repository;

    private List<Person> persons = new ArrayList<>();


    @Override
    public ResponseEntity<List<Person>> savePerson(Person person) {
        try {
            Person personSaved = repository.save(person);

            if (personSaved != null) {
                persons.add(personSaved);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
