package com.example.restservice.equipmentData.controllers;

import com.example.restservice.equipmentData.equipmentDomain.Unit;
import com.example.restservice.equipmentData.equipmentDomain.UnitDictionary;
import com.example.restservice.equipmentData.equipmentRepos.UnitDictionaryRepo;
import com.example.restservice.equipmentData.equipmentRepos.UnitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UnitController {

    @Autowired
    private UnitDictionaryRepo unitDicRepo;

    @PostMapping("addUnit")
    private String addUnit(
            @RequestParam String unit_name,
            @RequestParam String path
    ) {

        if (unitDicRepo.findByName(unit_name).isPresent()) {
            return "redirect:" + path;
        }

        UnitDictionary unitDictionary = new UnitDictionary();
        unitDictionary.setName(unit_name);
        unitDicRepo.save(unitDictionary);

        return "redirect:" + path;
    }
}
