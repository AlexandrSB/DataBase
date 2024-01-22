package com.example.restservice.workshopData.controllers;

import com.example.restservice.workshopData.workshopDomain.RepairCard;
import com.example.restservice.workshopData.workshopDomain.WorkshopModule;
import com.example.restservice.workshopData.workshopDomain.WorkshopUnit;
import com.example.restservice.workshopData.workshopRepos.WorkshopUnitRepo;
import com.example.restservice.workshopData.workshopRepos.WorkshopModuleRepo;
import com.example.restservice.workshopData.workshopRepos.RepairCardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("repair_notation")
public class RepairNotationController {

    @Autowired
    private RepairCardRepo repairCardRepo;

    @Autowired
    private WorkshopUnitRepo workshopUnitRepo;

    @Autowired
    private WorkshopModuleRepo workshopModuleRepo;

    @PostMapping("add_repair_notation")
    private String addRepairNotation(
            @RequestParam String workshop_module_id,
            @RequestParam String equipment_inventory_number,
            @RequestParam String repair_notation_name
    ) {

        Long workshopModuleId = Long.valueOf(workshop_module_id);

        WorkshopModule workshopModule = workshopModuleRepo
                .findById(workshopModuleId)
                .orElseThrow();

        RepairCard repairCard = new RepairCard();
//        repairCard.setWorkshopModules(repair_notation_name);

        repairCard.setWorkshopModules(
                workshopModule.getWorkshopUnit().getWorkshopModules()
        );
        repairCardRepo.save(repairCard);

        return "redirect:/workshop/repair_card/"
                + equipment_inventory_number +"/"
                + workshop_module_id;
    }

}
