package com.springapp.repository;

import com.springapp.domain.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by TeSla on 13.02.2015.
 */
public interface PetRepository extends JpaRepository<Pet, Long> {
    @Override
    List<Pet> findAll();
    Pet findById(Integer id);
    Pet save (Pet pet);
    void delete (Pet pet);

}
