package com.example.restservice.workshopData.controllers;

import com.example.restservice.equipmentData.equipmentDomain.Element;
import com.example.restservice.equipmentData.equipmentRepos.ElementRepo;
import com.example.restservice.storageData.storageDomain.Condition;
import com.example.restservice.storageData.storageDomain.Equipment;
import com.example.restservice.storageData.storageDomain.Good;
import com.example.restservice.storageData.storageRepos.ConditionRepo;
import com.example.restservice.storageData.storageRepos.EquipmentRepo;
import com.example.restservice.storageData.storageRepos.GoodsRepo;
import com.example.restservice.workshopData.workshopDomain.RepairNotation;
import com.example.restservice.workshopData.workshopRepos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/workshop")
public class RepairController {

    @Autowired
    private RepairRepo repairRepo;

    @Autowired
    private RepairNotationRepo repairNotationRepo;

    @Autowired
    private WorkshopEquipmentRepo equipmentRepo;

    @Autowired
    private EquipmentRepo storageEquipmentRepo;

    @Autowired
    private ConditionRepo conditionRepo;

    @Autowired
    private ElementRepo elementRepo;

    @Autowired
    private SparesRepo sparesRepo;

    @Autowired
    private GoodsRepo goodsRepo;

    @Autowired
    private ModelRepo modelRepo;

    @GetMapping
    public String workshop(Model model) {
//        """
//            Condition
//            0 -- Исправные
//            1 -- В ремонте
//            2 -- В ожидании ремонта
//            3 -- Донор
//            4 -- Списано
//            5 -- Закуп
//            6 -- На диагностике
//            7 -- В чистке
//            8 -- На кеше
//        """

//        Iterable<Equipment> equipment = equipmentRepo.findAll();
        Iterable<Long> equipmentsId = equipmentRepo.getAllId();
        Iterable<Element> element = elementRepo.findAllById(equipmentsId);
        model.addAttribute("workshop_equipment", element);

        Iterable<Equipment> awaitingRepairs =
                storageEquipmentRepo.getEquipmentByCondition(2L);
        model.addAttribute("awaiting_repairs", awaitingRepairs);

        Iterable<Equipment> inRepairs =
                storageEquipmentRepo.getEquipmentByCondition(1L);
        model.addAttribute("in_repairs", inRepairs);

        Iterable<Equipment> inDiagnostics =
                storageEquipmentRepo.getEquipmentByCondition(6L);
        model.addAttribute("in_diagnostics", inDiagnostics);

        Iterable<Equipment> inClearing =
                storageEquipmentRepo.getEquipmentByCondition(7L);
        model.addAttribute("in_clearing", inClearing);


        return "workshopWorkshop";
    }

    @GetMapping("/repair_card/{inventoryNumber}")
    public String repairCard(
            Model model,
            @PathVariable String inventoryNumber
    ) {

        Equipment equipment = storageEquipmentRepo.findByInventoryNumber(inventoryNumber)
                .orElseThrow();
        model.addAttribute("equipment", equipment);

        Element element = elementRepo.findById(equipment
                        .getGood()
                        .getId())
                .orElseThrow();
        model.addAttribute("element", element);

        Iterable<Element> elements_destination =
                elementRepo.findElementDestinationAll(element.getId());
        model.addAttribute("elem_destination", elements_destination);

        Iterable<RepairNotation> repairNotations = repairNotationRepo
                .findAllByModel(equipment.getGood().getName());
        model.addAttribute("repair_notation", repairNotations);

        return "workshopRepairCard";
    }

    @GetMapping("/repair")
    public String repair(Model model) {

        return "workshopRepair";
    }

    @GetMapping("/diagnostics")
    public String diagnostics(Model model) {

        return "workshopDiagnostics";
    }

    @GetMapping("/clearing")
    public String clearing(Model model) {

        return "workshopClearing";
    }

    @PostMapping("set_repair")
    private String setRepair(
            Model model,
            @RequestParam String elem_id
    ) {

        Condition condition = conditionRepo.findById(1L).orElseThrow();

        Equipment equipment = storageEquipmentRepo
                .findById(Long.valueOf(elem_id))
                .orElseThrow();
        equipment.setCondition(condition);
        storageEquipmentRepo.save(equipment);

        com.example.restservice.workshopData.workshopDomain.Model workshopModel =
                modelRepo.findByName(equipment.getGood().getName())
                        .orElse(new com.example.restservice.workshopData.workshopDomain.Model());
        if (workshopModel.getName() == null) {
            workshopModel.setName(equipment.getGood().getName());
            modelRepo.save(workshopModel);
        }

        com.example.restservice.workshopData.workshopDomain.Equipment workshopEquipment =
                equipmentRepo.findById(equipment.getId())
                        .orElse(new com.example.restservice.workshopData.workshopDomain.Equipment());
        workshopEquipment.setId(equipment.getId() );
        workshopEquipment.setInventoryNumber(equipment.getInventoryNumber());
        workshopEquipment.setModel(workshopModel);
        equipmentRepo.save(workshopEquipment);

        return "redirect:/workshop";
    }

    @PostMapping("set_diagnostic")
    private String setDiagnostic(
            @RequestParam String elem_id
    ) {

        return "redirect:/workshop";
    }

    @PostMapping("set_clearing")
    private String setClearing(
            @RequestParam String elem_id
    ) {

        return "redirect:/workshop";
    }
}
