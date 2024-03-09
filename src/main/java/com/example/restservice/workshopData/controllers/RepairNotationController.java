package com.example.restservice.workshopData.controllers;

import com.example.restservice.equipmentData.equipmentDomain.Element;
import com.example.restservice.equipmentData.equipmentDomain.Proxy;
import com.example.restservice.equipmentData.equipmentRepos.ElementRepo;
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
    private ElementRepo elementRepo;

    @Autowired
    private ProxyRepo proxyRepo;

    @Autowired
    private SparePartRepo sparePartRepo;

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
            @RequestParam(required = false) String element_name,
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

        Optional<Element> element = elementRepo
                .findByName(element_name);

        SparePart sparePart = null;
        if(element.isPresent()) {
            sparePart = sparePartRepo
                    .findByName(element.get().getName())
                    .orElse(new SparePart());
            if (sparePart.getName() == null) {
                sparePart.setId(element.get().getId());
                sparePart.setName(element.get().getName());
                sparePartRepo.save(sparePart);
            }
        }

        CompletedWork completedWork = new CompletedWork();
        completedWork.setNotation(repair_notation_name);
        completedWork.setSparePart(sparePart);
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
            @RequestParam String path,
            @RequestParam String repair_card_id,
            @RequestParam String unit_id,
            @RequestParam(required = false) String completed_work_id,
            @RequestParam(required = false) String spare_type_name,
            @RequestParam(required = false, defaultValue = "0") String quantity_of_spare
    ) {
        if (completed_work_id == null) {
            return "redirect:" + path;
        }
        UUID repairCardUUID = UUID.fromString(repair_card_id);
        Long unitId = Long.valueOf(unit_id);
        Long cwId = Long.valueOf(completed_work_id);
        Integer quantityOfSpare = Integer.valueOf(quantity_of_spare);
        TypeOfSparePart typeOfSparePart = null;

        Element element = elementRepo
                .findById(unitId)
                .orElseThrow();

        CompletedWork completedWork = completedWorkRepo
                .findById(cwId)
                .orElseThrow();

        RepairCardOfEquipment repairCardOfEquipment =
                repairCardOfEquipmentRepo
                        .findById(repairCardUUID)
                        .orElseThrow();

        WorkshopModule workshopModule = workshopModuleRepo
                .findModule(repairCardOfEquipment
                        .getWorkshopElement()
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

        SparePart sparePart = sparePartRepo
                .findById(unitId)
                .orElse(new SparePart());
        if (sparePart.getId() == null) {
            sparePart.setId(unitId);
            sparePart.setName(element.getName());
            sparePartRepo.save(sparePart);
        }

        if(spare_type_name != null) {
            Proxy proxy = proxyRepo
                    .findByName(spare_type_name)
                    .orElseThrow();

            typeOfSparePart = typeOfSparePartRepo
                    .findByName(spare_type_name)
                    .orElse(new TypeOfSparePart());
            if (typeOfSparePart.getId() == null) {
                typeOfSparePart.setId(proxy.getId());
                typeOfSparePart.setName(spare_type_name);
                typeOfSparePart.setSparePart(sparePart);
                typeOfSparePartRepo.save(typeOfSparePart);
            }
        }

            ConsumptionOfMaterial consumptionOfMaterial =
                    new ConsumptionOfMaterial();
            consumptionOfMaterial.setCompletedWork(completedWork);
            consumptionOfMaterial.setWorkshopModule(workshopModule);
            consumptionOfMaterial.setRepairCardOfModule(repairCardOfModule);
            consumptionOfMaterial.setQuantityOfMaterial(quantityOfSpare);
            if(typeOfSparePart != null) {
                consumptionOfMaterial.setTypeOfSparePart(typeOfSparePart);
            }
            consumptionOfMaterialRepo.save(consumptionOfMaterial);

        return "redirect:" + path;
    }
}
