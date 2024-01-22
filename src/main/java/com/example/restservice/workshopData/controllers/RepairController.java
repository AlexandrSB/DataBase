package com.example.restservice.workshopData.controllers;

import com.example.restservice.equipmentData.equipmentDomain.Element;
import com.example.restservice.equipmentData.equipmentRepos.ElementRepo;
import com.example.restservice.equipmentData.equipmentRepos.ProxyRepo;
import com.example.restservice.storageData.storageDomain.Condition;
import com.example.restservice.storageData.storageDomain.Equipment;
import com.example.restservice.storageData.storageRepos.ConditionRepo;
import com.example.restservice.storageData.storageRepos.EquipmentRepo;
import com.example.restservice.storageData.storageRepos.GoodsRepo;
import com.example.restservice.workshopData.workshopDomain.RepairCard;
import com.example.restservice.workshopData.workshopDomain.WorkshopEquipment;
import com.example.restservice.workshopData.workshopDomain.WorkshopModule;
import com.example.restservice.workshopData.workshopDomain.WorkshopUnit;
import com.example.restservice.workshopData.workshopRepos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/workshop")
public class RepairController {

    @Autowired
    private RepairCardRepo repairCardRepo;

    @Autowired
    private WorkshopEquipmentRepo workshopEquipmentRepo;

    @Autowired
    private EquipmentRepo storageEquipmentRepo;

    @Autowired
    private ConditionRepo conditionRepo;

    @Autowired
    private ElementRepo elementRepo;

    @Autowired
    private SparePartRepo sparePartRepo;

    @Autowired
    private GoodsRepo goodsRepo;

    @Autowired
    private WorkshopUnitRepo workshopUnitRepo;

    @Autowired
    private WorkshopModuleRepo workshopModuleRepo;

    @Autowired
    private ProxyRepo proxyRepo;

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
        Iterable<Long> equipmentsId = workshopEquipmentRepo.getAllId();
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

        Iterable<RepairCard> repairCard = repairCardRepo
                .findAllByModelName(equipment.getGood().getName());
        model.addAttribute("repair_card", repairCard);

        return "workshopRepairCard";
    }

    @GetMapping("/repair_card/{inventory_number}/{element_id}")
    public String moduleRepair(
            Model model,
            @PathVariable String inventory_number,
            @PathVariable String element_id
    ) {
        Long elementId = Long.valueOf(element_id);
        Equipment equipment = null;
        Element element = null;

        Optional<Equipment> optionalEquipment = storageEquipmentRepo
                .findByInventoryNumber(inventory_number);

        if (optionalEquipment.isPresent()) {
            equipment = optionalEquipment.get();
        } else {
            return "redirect:/workshop";
        }
        model.addAttribute("equipment", equipment);

        Optional<Element> optionalElement = elementRepo.findById(elementId);
        if (optionalElement.isPresent()) {
            element = optionalElement.get();
        } else {
            return "redirect:/workshop";
        }

        WorkshopUnit workshopUnit = workshopUnitRepo.findById(element.getId())
                .orElse(new WorkshopUnit());
        if (workshopUnit.getName() == null) {
            workshopUnit.setId(element.getId());
            workshopUnit.setName(element.getName());
            workshopUnitRepo.save(workshopUnit);
        }

        WorkshopModule workshopModule = workshopModuleRepo.findById(elementId)
                .orElse(new WorkshopModule());
        if (workshopModule.getId() == null) {
            workshopModule.setId(elementId);
            workshopModule.setWorkshopUnit(workshopUnit);
            workshopModuleRepo.save(workshopModule);
        }
        model.addAttribute("workshop_module", workshopModule);

        Iterable<RepairCard> repairCards = repairCardRepo
                .findAllByModelName(workshopUnit.getName());
        model.addAttribute("repair_card", repairCards);

        Iterable<Element> elements_destination =
                elementRepo.findElementDestinationAll(element.getId());
        model.addAttribute("elements_destination", elements_destination);

        return "workshopOperation";
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

        WorkshopUnit workshopUnit = workshopUnitRepo.findByName(equipment.getGood().getName())
                .orElse(new WorkshopUnit());
        if (workshopUnit.getName() == null) {
            workshopUnit.setName(equipment.getGood().getName());
            workshopUnitRepo.save(workshopUnit);
        }

        WorkshopEquipment workshopEquipment =
                workshopEquipmentRepo.findById(equipment.getId())
                        .orElse(new WorkshopEquipment());
        if(workshopEquipment.getId() == null) {
            workshopEquipment.setId(equipment.getId());
            workshopEquipment.setInventoryNumber(equipment.getInventoryNumber());
            workshopEquipment.setModel(workshopUnit.getName());
            workshopEquipmentRepo.save(workshopEquipment);
        }

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
