package com.springapp.service;

import com.springapp.domain.Pet;
import com.springapp.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by TeSla on 13.02.2015.
 */
@Service
public class PetService {

    @Autowired
    PetRepository petRepository;

    public void save(Pet pet){
        petRepository.save(pet);
    }

    public List<Pet> findAll(){ return petRepository.findAll();}

    public Pet findById(Integer id){return petRepository.findById(id);}

    public void delete(Pet pet) { petRepository.delete(pet);}

}
