package com.example.restservice.equipmentData.controllers;

import com.example.restservice.equipmentData.equipmentDomain.*;
import com.example.restservice.equipmentData.equipmentRepos.GroupRepo;
import com.example.restservice.equipmentData.equipmentRepos.EquipmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/equipment1")
public class EquipmentController {
    @Autowired
    private EquipmentRepo equipmentRepo;

    @Autowired
    private GroupRepo groupRepo;

    @GetMapping("/")
    public String equipment(Map<String, Object> model) {
//        Iterable<EnumTypeOfEquipment> enumTypeOfEquipments =
//                List.of(EnumTypeOfEquipment.values());
//        model.put("types", enumTypeOfEquipments);

//        Iterable<Firma> enumFirmas = List.of(Firma.values());
//        model.put("firmas", enumFirmas);

        Iterable<Group> equipmentGroups = groupRepo.findAll();
        model.put("groups", equipmentGroups);

        Iterable<Equipment> equipments = equipmentRepo.findAll();
        model.put("equipments", equipments);

        return "equipment";
    }

    @PostMapping("equipments")
    public String equip(
            @RequestParam String firmName,
            @RequestParam String myModel,
            @RequestParam String type,
            Map<String, Object> model) {

        Iterable<EnumTypeOfEquipment> enumTypeOfEquipments =
                List.of(EnumTypeOfEquipment.values());
        model.put("types", enumTypeOfEquipments);

//////        Iterable<Firma> enumFirmas = List.of(Firma.values());
//////        model.put("firmas", enumFirmas);
////
////        Firma firma = Firma.valueOf(firmName);
////        EnumTypeOfEquipment enumTypeOfEquipment =
////                EnumTypeOfEquipment.valueOf(type);
//        try {
//            Equipment equipment = new Equipment(firma, myModel, enumTypeOfEquipment);
//            equipmentRepo.save(equipment);
//        } catch (Exception e) {
//            return "main";
//        }

        Iterable<Equipment> equipments = equipmentRepo.findAll();
        model.put("equipments", equipments);

        Iterable<Group> equipmentGroups = groupRepo.findAll();
        model.put("groups", equipmentGroups);

        return "equipment";
    }

    @GetMapping("/equipments")
    public String allEquipments(Map<String, Object> model) {

        Iterable<Equipment> equipments = equipmentRepo.findAll();
        model.put("equipments", equipments);

        return "allEquipments";
    }

    @GetMapping("/{group_id}")
    public String equipmentViewForm(
            @PathVariable String group_id,
            Model model
    ) {
        model.addAttribute("group", groupRepo.getById(Long.valueOf(group_id)));

        Iterable<Equipment> equipment = equipmentRepo.findAll();
        model.addAttribute("equipment", equipment);

        return "equipView";
    }
}
