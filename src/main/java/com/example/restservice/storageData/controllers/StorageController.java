package com.example.restservice.storageData.controllers;

import com.example.restservice.storageData.storageRepos.StorageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StorageController {

    @Autowired
    private StorageRepo storageRepo;

    @GetMapping("/storage")
    public String getStorage(
            @RequestParam(
            name = "hello",
            required = false,
            defaultValue = "World"
    ) String name,
    Model model) {

        String s = "Test Completed!";
        model.addAttribute("s", s);

        return "storage";
    }
}
