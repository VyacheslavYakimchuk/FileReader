package com.springapp.controller;

import com.springapp.domain.People;
import com.springapp.service.PeopleService;
import com.springapp.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("/")
public class HelloController {

    @Autowired
    PeopleService peopleService;
    @Autowired
    PetService petService;

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model, People people) {
        model.addAttribute("peopleList", peopleService.findAll());

        return "people";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addPeople(@ModelAttribute People people, BindingResult bindingResult) {
        peopleService.save(people);

        return "redirect:/";
    }

    @RequestMapping(value = "/delete/{peopleId}")
    public String deletePeople(@PathVariable("peopleId") Long peopleId) {
        People people = new People();
        people.setId(peopleId);
        peopleService.delete(people);

        return "redirect:/";
    }

    @RequestMapping(value = "/edit/")
    public String editPeople(@RequestParam(value = "peopleId") Long peopleId, ModelMap model) throws FileNotFoundException, UnsupportedEncodingException {
        model.addAttribute("peopleId", peopleId);
        PrintWriter printwritter = new PrintWriter("d:/test.txt", "windows-1251");
        printwritter.println(peopleId);
        printwritter.close();

        return "people";
    }

}