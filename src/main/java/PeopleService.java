package com.springapp.service;


import com.springapp.domain.People;
import com.springapp.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleService {

    @Autowired
    PeopleRepository peopleRepository;

    public List<People> findAll() {
        return peopleRepository.findAll();
    }

    public void save(People people){
        peopleRepository.save(people);
    }

    public void delete(People people){
        peopleRepository.delete(people);
    }

    public  People findById(Long id){
        return peopleRepository.findById(id);
    }
}
