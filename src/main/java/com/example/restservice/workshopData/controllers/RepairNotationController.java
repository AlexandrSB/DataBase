package com.example.restservice.workshopData.controllers;

import com.example.restservice.storageData.storageDomain.Equipment;
import com.example.restservice.storageData.storageRepos.EquipmentRepo;
import com.example.restservice.workshopData.workshopDomain.Model;
import com.example.restservice.workshopData.workshopDomain.RepairNotation;
import com.example.restservice.workshopData.workshopRepos.ModelRepo;
import com.example.restservice.workshopData.workshopRepos.RepairNotationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("repair_notation")
public class RepairNotationController {

    @Autowired
    private RepairNotationRepo repairNotationRepo;

    @Autowired
    private ModelRepo modelRepo;

    @Autowired
    private EquipmentRepo equipmentRepo;

    @PostMapping("add_repair_notation")
    private String addRepairNotation(
            @RequestParam String equipment_id,
            @RequestParam String repair_notation_name
    ) {

        Equipment equipment = equipmentRepo.findById(
                Long.valueOf(equipment_id)
        ).orElseThrow();

        RepairNotation repairNotation = new RepairNotation();
        repairNotation.setNotation(repair_notation_name);

        Model model = modelRepo.findByName(equipment_id)
                .orElse(new Model());
        if (model.getName() == null) {
            model.setName(equipment.getGood().getName());
        }

        repairNotation.addModel(model);

        modelRepo.save(model);
        repairNotationRepo.save(repairNotation);

        return "redirect:/workshop/repair_card/" + equipment_id;
    }

}
