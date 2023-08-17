package com.example.restservice.equipmentData.controllers;

import com.example.restservice.equipmentData.equipmentRepos.GroupRecursiveRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private GroupRecursiveRepo groupRecursiveRepo;


    @GetMapping({"/element", "/element/**", "/storage", "/storage/**"})
    public void menyMode(Model model) {
        model.addAttribute("group", groupRecursiveRepo.findAll());
//        return "main";
    }

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("group", groupRecursiveRepo.findAll());
        return "main";
    }


}
