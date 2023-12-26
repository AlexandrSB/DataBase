package com.example.restservice.workshopData.controllers;

import com.example.restservice.equipmentData.equipmentDomain.Element;
import com.example.restservice.equipmentData.equipmentRepos.ElementRepo;
import com.example.restservice.storageData.storageDomain.Condition;
import com.example.restservice.storageData.storageDomain.Contragent;
import com.example.restservice.storageData.storageDomain.Equipment;
import com.example.restservice.storageData.storageRepos.ConditionRepo;
import com.example.restservice.storageData.storageRepos.EquipmentRepo;
import com.example.restservice.workshopData.workshopRepos.RepairRepo;
import com.example.restservice.workshopData.workshopRepos.SparesRepo;
import com.example.restservice.workshopData.workshopRepos.WorkshopEquipmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/workshop")
public class RepairController {

    @Autowired
    private RepairRepo repairRepo;

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


    @GetMapping
    public String workshop(Model model) {

//        Iterable<Equipment> equipment = equipmentRepo.findAll();
        Iterable<Long> equipmentsId = equipmentRepo.getAllId();
        Iterable<Element> element = elementRepo.findAllById(equipmentsId);
        model.addAttribute("workshop_equipment", element);

        Iterable<Equipment> awaitingRepairs =
                storageEquipmentRepo.getEquipmentByAwaitingRepairs();
        model.addAttribute("awaiting_repairs", awaitingRepairs);

        return "workshopWorkshop";
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

        Optional<Condition> optionalCondition = conditionRepo.findById(1L);
        Condition condition = optionalCondition.orElseThrow();

        Optional<Equipment> optionalEquipment = storageEquipmentRepo.findById(Long.valueOf(elem_id));
        Equipment equipment = optionalEquipment.orElseThrow();

        equipment.setCondition(condition);
        storageEquipmentRepo.save(equipment);

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
