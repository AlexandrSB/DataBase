package com.example.restservice.workshopData.controllers;

import com.example.restservice.storageData.storageRepos.WorkshopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/workshopNotUsedNow")
public class WorkshopController {

    @Autowired
    private WorkshopRepo workshopRepo;

    @GetMapping
    public String showWorkshop(Model model) {

        return "workshopWorkshop";
    }
}
