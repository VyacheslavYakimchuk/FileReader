package com.springapp.controller;

import com.springapp.domain.People;
import com.springapp.domain.Pet;
import com.springapp.service.PeopleService;
import com.springapp.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequestMapping("/")
public class HelloController {

    @Autowired
    PeopleService peopleService;
    @Autowired
    PetService petService;

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model, People people, Long peopleId, Pet pet, String petId) {
        model.addAttribute("peopleList", peopleService.findAll());
        model.addAttribute("peopleId", peopleId);
        model.addAttribute("countryList", getCountries());
        model.addAttribute("petList", petService.findAll());
        model.addAttribute("petId", petId);
        //System.out.println(getCountries());

        return "people";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addPeople(@ModelAttribute People people, BindingResult bindingResult) {
        peopleService.save(people);

        return "redirect:/";
    }

    @RequestMapping(value ="/addPet/{peopleId}", method = RequestMethod.POST)
    public String addPet(@ModelAttribute Pet pet, @PathVariable("peopleId") Integer peopleId,  BindingResult bindingResult){
        System.out.println(peopleId);
        petService.save(pet);

        return "redirect:/";
    }

    @RequestMapping(value = "/delete/{peopleId}")
    public String deletePeople(@PathVariable("peopleId") Long peopleId) {
        People people = new People();
        people.setId(peopleId);
        peopleService.delete(people);

        return "redirect:/";
    }

    @RequestMapping(value = "deletePet/{petId}")
    public String deletePet(@PathVariable("petId") Integer petId){
        Pet pet = new Pet();
        pet.setId(petId);
        petService.delete(pet);

        return "redirect:/";
    }

    private Map<String, String> getCountries() {
        Map<String, String> country = new LinkedHashMap<String, String>();
        country.put("US", "United Stated");
        country.put("CHINA", "China");
        country.put("SG", "Singapore");
        country.put("MY", "Malaysia");

        return country;
    }
}