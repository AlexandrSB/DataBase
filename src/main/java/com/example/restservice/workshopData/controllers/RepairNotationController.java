package com.example.restservice.workshopData.controllers;

import com.example.restservice.equipmentData.equipmentDomain.Proxy;
import com.example.restservice.equipmentData.equipmentRepos.ProxyRepo;
import com.example.restservice.workshopData.workshopDomain.*;
import com.example.restservice.workshopData.workshopRepos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("repair_notation")
public class RepairNotationController {

    @Autowired
    private CompletedWorkRepo completedWorkRepo;

    @Autowired
    private ConsumptionOfMaterialRepo consumptionOfMaterialRepo;

    @Autowired
    private ProxyRepo proxyRepo;

    @Autowired
    private TypeOfOperationRepo typeOfOperationRepo;

    @Autowired
    private TypeOfSparePartRepo typeOfSparePartRepo;
    @Autowired
    private WorkshopUnitRepo workshopUnitRepo;

    @Autowired
    private WorkshopModuleRepo workshopModuleRepo;
    @Autowired
    private RepairCardOfModuleRepo repairCardOfModuleRepo;

    @Autowired
    private RepairCardOfEquipmentRepo repairCardOfEquipmentRepo;

    @PostMapping("add_operation")
    private String addRepairNotation(
            @RequestParam String repair_card_id,
            @RequestParam String unit_id,
            @RequestParam String repair_notation_name,
            @RequestParam String proxy_name,
            @RequestParam String operation_type_name
    ) {

        UUID repairCardId = UUID.fromString(repair_card_id);
        Long unitId = Long.valueOf(unit_id);
        OperationType operationType = OperationType.valueOf(operation_type_name);

        RepairCardOfEquipment repairCardOfEquipment =
                 repairCardOfEquipmentRepo
                .findById(repairCardId)
                .orElseThrow();

        WorkshopUnit workshopUnit = workshopUnitRepo
                .findById(unitId)
                .orElseThrow();

        Optional<Proxy> proxy = proxyRepo
                .findByName(proxy_name);

        TypeOfSparePart typeOfSparePart = null;
        if(proxy.isPresent()) {
            typeOfSparePart = typeOfSparePartRepo
                    .findByName(proxy.get().getName())
                    .orElse(new TypeOfSparePart());
            if (typeOfSparePart.getName() == null) {
                typeOfSparePart.setId(proxy.get().getId());
                typeOfSparePart.setName(proxy.get().getName());
                typeOfSparePartRepo.save(typeOfSparePart);
            }
        }

        CompletedWork completedWork = new CompletedWork();
        completedWork.setNotation(repair_notation_name);
        completedWork.setTypeOfSparePart(typeOfSparePart);
        completedWork.setRepairType(repairCardOfEquipment.getRepairType());
        completedWorkRepo.save(completedWork);

        TypeOfOperation typeOfOperation = new TypeOfOperation();
        typeOfOperation.setOperationType(operationType);
        typeOfOperation.setCompletedWork(completedWork);
        typeOfOperation.setWorkshopUnit(workshopUnit);
        typeOfOperationRepo.save(typeOfOperation);

        return "redirect:/workshop/repair_card/"
                + repair_card_id +"/"
                + unit_id;
    }

    @PostMapping("check_operation")
    private String checkOperation(
            @RequestParam String repair_card_id,
            @RequestParam String unit_id,
            @RequestParam(required = false) List<String> my_checkboxes,
            @RequestParam(required = false) List<String> quantity_of_spare
    ) {
        UUID repairCardUUID = UUID.fromString(repair_card_id);
        Long unitId = Long.valueOf(unit_id);
        List<ConsumptionOfMaterial> consumptionOfMaterialSet = new ArrayList<>();
        Long comId;

        RepairCardOfEquipment repairCardOfEquipment =
                repairCardOfEquipmentRepo
                        .findById(repairCardUUID)
                        .orElseThrow();

        WorkshopModule workshopModule = workshopModuleRepo
                .findModule(repairCardOfEquipment
                        .getWorkshopEquipment()
                        .getId(),
                        unitId)
                .orElseThrow();

        RepairCardOfModule repairCardOfModule = repairCardOfModuleRepo
                .findByUnitId(repairCardUUID, workshopModule.getId())
                .orElse(new RepairCardOfModule());
        if (repairCardOfModule.getRepairCardOfEquipment() == null) {
            repairCardOfModule.setWorkshopModule(workshopModule);
            repairCardOfModule.setRepairCardOfEquipment(repairCardOfEquipment);
            repairCardOfModuleRepo.save(repairCardOfModule);
        }

        CompletedWork completedWork = null;

        //TODO правильно обработать массив
        // (выполненные_работы_id, количество запчастей ...)
//        for (String s : my_checkboxes) {
        int j = 0;
        for(int i = 0; i < my_checkboxes.size(); i += 2) {
            j = i;
            comId = Long.valueOf(my_checkboxes.get(i));

            completedWork = completedWorkRepo
                    .findById(comId)
                    .orElseThrow();

            ConsumptionOfMaterial consumptionOfMaterial =
                    new ConsumptionOfMaterial();
            consumptionOfMaterial.setCompletedWork(completedWork);
            consumptionOfMaterial.setWorkshopModule(workshopModule);
            consumptionOfMaterial.setRepairCardOfModule(repairCardOfModule);
            consumptionOfMaterial.setQuantityOfMaterial(
                    Integer.valueOf(my_checkboxes.get(++j))
            );

            consumptionOfMaterialSet.add(consumptionOfMaterial);
        }
        consumptionOfMaterialRepo.saveAll(consumptionOfMaterialSet);

        return "redirect:/workshop/repair_card/"
                + repair_card_id + "/"
                + unit_id;
    }
}
