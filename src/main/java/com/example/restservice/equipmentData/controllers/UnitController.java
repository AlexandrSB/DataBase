package com.example.restservice.equipmentData.controllers;

import com.example.restservice.equipmentData.equipmentDomain.*;
import com.example.restservice.equipmentData.equipmentRepos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.Set;

@Controller
public class UnitController {

    @Autowired
    private UnitRepo unitRepo;

    @Autowired
    private UnitDictionaryRepo unitDicRepo;

    @Autowired
    private AttributeRepo attributeRepo;

    @Autowired
    private AttributeDictionaryRepo attributeDictionaryRepo;


    @PostMapping("addUnitName")
    private String addUnitName(
            @RequestParam String attr_dic_id,
            @RequestParam String unit_name,
            @RequestParam String path
    ) {
        Long attrId = Long.valueOf(attr_dic_id);

        if (unitDicRepo.findByName(unit_name).isPresent()) {
            return "redirect:" + path;
        }

        AttributeDictionary attributeDictionary =
                attributeDictionaryRepo
                        .findById(attrId)
                        .orElseThrow();

        UnitDictionary unitDictionary = new UnitDictionary();
        unitDictionary.setName(unit_name);
        unitDictionary.setAttributeDictionary(attributeDictionary);
        unitDicRepo.save(unitDictionary);

        return "redirect:" + path;
    }

    @PostMapping("addUnit")
    private String addUnit(
            @RequestParam String attr_id,
            @RequestParam String unit_dic_name,
            @RequestParam String path
    ) {
        //TODO привязать Unit к Attribute
        Long attrId = Long.valueOf(attr_id);

        Attribute attribute =
                attributeRepo.findById(attrId)
                        .orElseThrow();

        UnitDictionary unitDictionary =
                unitDicRepo.findByName(unit_dic_name)
                        .orElseThrow();

        Unit unit = new Unit();
        unit.setUnitDictionary(unitDictionary);
        unit.setAttribute(attribute);
        unitRepo.save(unit);


        return "redirect:" + path;
    }
}
