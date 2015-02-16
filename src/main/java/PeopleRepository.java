package com.springapp.repository;


import com.springapp.domain.People;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PeopleRepository extends JpaRepository<People, Long>{
    List<People> findAll();
    People findById(Long id);
    List<People> findByFirstName(String firstName);
    People save(People people);
    void delete(People people);
}
