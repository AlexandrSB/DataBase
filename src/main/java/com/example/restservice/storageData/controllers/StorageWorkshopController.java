package com.example.restservice.storageData.controllers;

import com.example.restservice.storageData.storageDomain.Workshop;
import com.example.restservice.storageData.storageRepos.WorkshopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/storage/workshop")
public class StorageWorkshopController {

    @Autowired
    private WorkshopRepo workshopRepo;

    @GetMapping
    public String showWorkshop(
            Model model
    ) {

        Iterable<Workshop> workshops = workshopRepo.findAll();
        model.addAttribute("workshops", workshops);

        return "workshop";
    }

    @PostMapping("add_workshop")
    public String addWorkshop(
            @RequestParam String workshop_name,
            @RequestParam String description,
            Model model
    ) {

        Workshop workshop = new Workshop();
        workshop.setName( workshop_name );
        workshop.setDescription( description );

        workshopRepo.save(workshop);

        return "redirect:/storage/workshop";
    }
}
