package com.example.restservice.equipmentData.controllers;

import com.example.restservice.equipmentData.equipmentDomain.Unit;
import com.example.restservice.equipmentData.equipmentRepos.UnitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UnitController {

    @Autowired
    private UnitRepo unitRepo;

    @PostMapping("addUnit")
    private String addUnit(
            @RequestParam String unit_name,
            @RequestParam String path
    ) {

        if (unitRepo.findByName(unit_name).isPresent()) {
            return "redirect:" + path;
        }

        Unit unit = new Unit();
        unit.setName(unit_name);
        unitRepo.save(unit);

        return "redirect:" + path;
    }
}
