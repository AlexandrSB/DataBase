package com.example.restservice.controllers;

import com.example.restservice.equipmentData.equipmentDomain.Component;
import com.example.restservice.equipmentData.equipmentDomain.EnumFirma;
import com.example.restservice.equipmentData.equipmentDomain.EnumTypeOfEquipment;
import com.example.restservice.equipmentData.equipmentDomain.Equipment;
import com.example.restservice.equipmentData.equipmentRepo.EquipmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class EquipmentController {
    @Autowired
    private EquipmentRepo equipmentRepo;


    @GetMapping("/equipment")
    public String equipment(Map<String, Object> model) {
        Iterable<EnumTypeOfEquipment> enumTypeOfEquipments =
                List.of(EnumTypeOfEquipment.values());
        model.put("types", enumTypeOfEquipments);

        Iterable<EnumFirma> enumFirmas = List.of(EnumFirma.values());
        model.put("firmas", enumFirmas);

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

        Iterable<EnumFirma> enumFirmas = List.of(EnumFirma.values());
        model.put("firmas", enumFirmas);

        EnumFirma enumFirma = EnumFirma.valueOf(firmName);
        EnumTypeOfEquipment enumTypeOfEquipment =
                EnumTypeOfEquipment.valueOf(type);
        try {
            Equipment equipment = new Equipment(enumFirma, myModel, enumTypeOfEquipment);
            equipmentRepo.save(equipment);
        } catch (Exception e) {
            return "main";
        }

        Iterable<Equipment> equipments = equipmentRepo.findAll();
        model.put("equipments", equipments);

        return "equipment";
    }

    @GetMapping("/equipments")
    public String allEquipments(Map<String, Object> model) {

        Iterable<Equipment> equipments = equipmentRepo.findAll();
        model.put("equipments", equipments);

        return "allEquipments";
    }

    @GetMapping("equipments/{equipment}")
    public String equipmentViewForm(
            @PathVariable Equipment equipment,
            Model model
    ) {
        model.addAttribute("equip", equipment);

        Iterable<Component> comp = equipment.getElements();
        model.addAttribute("component", comp);

        return "equipView";
    }
}
