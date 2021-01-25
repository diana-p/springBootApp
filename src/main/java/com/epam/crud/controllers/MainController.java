package com.epam.crud.controllers;

import com.epam.crud.models.Ad;
import com.epam.crud.repository.AdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    private AdRepository adRepository;


    //home page (read)
    @GetMapping("/")
    public String home(Model model) {
        Iterable<Ad> ads = adRepository.findAll();
        model.addAttribute("ads", ads);
        return "home";
    }

    @GetMapping("/add")
    public String add(Model model) {
        Iterable<Ad> ads = adRepository.findAll();
        model.addAttribute("ads", ads);
        return "add-page";
    }

    //create
    @PostMapping("/add")
    public String postAdd(@RequestParam String lastName,@RequestParam String firstName, @RequestParam String adFull, @RequestParam String email, Model model){
        Ad ad = new Ad(adFull, lastName, firstName, email);
        adRepository.save(ad);
        return "redirect:/";
    }

    //edit
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(value = "id") Long id, Model model) {
        if (!adRepository.existsById(id)){
            return "redirect:/";
        }

        Optional<Ad> ad = adRepository.findById(id);
        ArrayList<Ad> res = new ArrayList<>();
        ad.ifPresent(res::add);
        model.addAttribute("ad", res);
        return "edit-page";
    }

    //edit
    @PostMapping("/edit/{id}")
    public String adEdit(@PathVariable(value = "id") Long id, @RequestParam String lastName,@RequestParam String firstName, @RequestParam String adFull, @RequestParam String email, Model model){
        Ad ad = adRepository.findById(id).orElseThrow();
        ad.setLastName(lastName);
        ad.setFirstName(firstName);
        ad.setText(adFull);
        ad.setEMail(email);
        adRepository.save(ad);
        return "redirect:/";
    }

    //delete
    @PostMapping("/delete/{id}")
    public String adDelete(@PathVariable(value = "id") Long id, Model model){
        Ad ad = adRepository.findById(id).orElseThrow();
        adRepository.delete(ad);
        return "redirect:/";
    }

}
