package com.example.restservice.storageData.controllers;

import com.example.restservice.storageData.storageRepos.ParcelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/storage")
public class ParcelController {

    @Autowired
    private ParcelRepo parcelRepo;

    @GetMapping("/parcel/{id}")
    private String newParcel(
            @PathVariable String id
    ) {
        return "newParty";
    }
}
