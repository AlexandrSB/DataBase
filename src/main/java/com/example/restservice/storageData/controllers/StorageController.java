package com.example.restservice.storageData.controllers;

import com.example.restservice.storageData.storageDomain.Storage;
import com.example.restservice.storageData.storageRepos.StorageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/storage")
public class StorageController {

    @Autowired
    private StorageRepo storageRepo;

    @GetMapping
    public String getStorage( Model model ) {

        return "storage";
    }

    @GetMapping("/storage")
    public String storage( Model model ) {

        Iterable<Storage> storages = storageRepo.findAll();
        model.addAttribute("storages", storages);

        return "viewStorage";
    }

    @PostMapping("add_storage")
    public String addStorage(
            @RequestParam String storage_name,
            @RequestParam String description,
            Model model
    ) {

        Storage storage = new Storage();
        storage.setName( storage_name );
        storage.setDescription( description );
        storageRepo.save( storage );

        return "redirect:/storage/storage";
    }

}