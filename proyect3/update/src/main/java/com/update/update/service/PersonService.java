package com.update.update.service;

import com.update.update.model.Person;
import com.update.update.repository.IPersonRepository;
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
    @Transactional
    public ResponseEntity<List<Person>> updatePerson(Person person,Long id) {
        try {
            Optional<Person> personSearch = repository.findById(id);

            if (personSearch.isPresent()) {
                personSearch.get().setName(person.getName());
                personSearch.get().setSurname(person.getSurname());
                personSearch.get().setPhone(person.getPhone());

                Person personsSaved = repository.save(personSearch.get());

                if (personsSaved != null) {
                    persons.add(personsSaved);
                } else {
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                }
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
