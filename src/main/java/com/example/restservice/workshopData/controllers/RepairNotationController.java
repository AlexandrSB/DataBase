package com.example.restservice.workshopData.controllers;

import com.example.restservice.workshopData.workshopDomain.*;
import com.example.restservice.workshopData.workshopRepos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
@RequestMapping("repair_notation")
public class RepairNotationController {

    @Autowired
    private CompletedWorkRepo completedWorkRepo;

    @Autowired
    private TypeOfOperationRepo typeOfOperationRepo;

    @Autowired
    private WorkshopUnitRepo workshopUnitRepo;

    @Autowired
    private RepairCardOfModuleRepo repairCardOfModuleRepo;

    @Autowired
    private RepairCardOfEquipmentRepo repairCardOfEquipmentRepo;

    @PostMapping("add_repair_notation")
    private String addRepairNotation(
            @RequestParam String repair_card_id,
            @RequestParam String unit_id,
            @RequestParam String repair_notation_name
    ) {

        UUID repairCardId = UUID.fromString(repair_card_id);
        Long unitId = Long.valueOf(unit_id);

        RepairCardOfEquipment repairCardOfEquipment =
                 repairCardOfEquipmentRepo
                .findById(repairCardId)
                .orElseThrow();

        WorkshopUnit workshopUnit = workshopUnitRepo
                .findById(unitId)
                .orElseThrow();

        CompletedWork completedWork = new CompletedWork();
        completedWork.setNotation(repair_notation_name);
//        completedWork.setConsumptionOfMaterials();
        completedWork.setRepairType(repairCardOfEquipment.getRepairType());
        completedWorkRepo.save(completedWork);

        TypeOfOperation typeOfOperation = new TypeOfOperation();
        typeOfOperation.setOperationType(OperationType.REPAIR);
        typeOfOperation.setCompletedWork(completedWork);
        typeOfOperation.setWorkshopUnit(workshopUnit);
        typeOfOperationRepo.save(typeOfOperation);

        return "redirect:/workshop/repair_card/"
                + repair_card_id +"/"
                + unit_id;
    }

}
