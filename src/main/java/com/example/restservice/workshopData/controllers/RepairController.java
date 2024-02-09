package com.example.restservice.workshopData.controllers;

import com.example.restservice.equipmentData.equipmentDomain.Category;
import com.example.restservice.equipmentData.equipmentDomain.Element;
import com.example.restservice.equipmentData.equipmentRepos.ElementRepo;
import com.example.restservice.equipmentData.equipmentRepos.ElementsCompositeRepo;
import com.example.restservice.equipmentData.equipmentRepos.ProxyRepo;
import com.example.restservice.storageData.storageDomain.Condition;
import com.example.restservice.storageData.storageDomain.Equipment;
import com.example.restservice.storageData.storageRepos.ConditionRepo;
import com.example.restservice.storageData.storageRepos.EquipmentRepo;
import com.example.restservice.storageData.storageRepos.GoodsRepo;
import com.example.restservice.workshopData.workshopDomain.*;
import com.example.restservice.workshopData.workshopRepos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

@Controller
@RequestMapping("/workshop")
public class RepairController {

    @Autowired
    private CompletedWorkRepo completedWorkRepo;

    @Autowired
    private ConditionRepo conditionRepo;

    @Autowired
    private ConsumptionOfMaterialRepo consumptionOfMaterialRepo;

    @Autowired
    private EquipmentRepo storageEquipmentRepo;

    @Autowired
    private ElementRepo elementRepo;

    @Autowired
    private ElementsCompositeRepo elementsCompositeRepo;

    @Autowired
    private WorkshopEquipmentRepo workshopEquipmentRepo;

    @Autowired
    private GoodsRepo goodsRepo;

    @Autowired
    private ProxyRepo proxyRepo;

    @Autowired
    private WorkshopProxyRepo workshopProxyRepo;

    @Autowired
    private RepairCardOfModuleRepo repairCardOfModuleRepo;

    @Autowired
    private RepairCardOfEquipmentRepo repairCardOfEquipmentRepo;

    @Autowired
    private SparePartRepo sparePartRepo;

    @Autowired
    private WorkshopElementRepo workshopElementRepo;

    @Autowired
    private WorkshopModuleRepo workshopModuleRepo;

    @Autowired
    private WorkshopUnitRepo workshopUnitRepo;

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

        Iterable<Long> equipmentsId = workshopElementRepo.getAllId();
        Iterable<Element> element = elementRepo.findAllById(equipmentsId);
        model.addAttribute("workshop_equipment", element);

        Iterable<Equipment> awaitingRepairs =
                storageEquipmentRepo.getEquipmentByCondition(2L);
        model.addAttribute("awaiting_repairs", awaitingRepairs);

        Iterable<RepairCardOfEquipment> inRepairs =
                repairCardOfEquipmentRepo.getCardInRepair();
        model.addAttribute("in_repairs", inRepairs);

        Iterable<Equipment> inDiagnostics =
                storageEquipmentRepo.getEquipmentByCondition(6L);
        model.addAttribute("in_diagnostics", inDiagnostics);

        Iterable<Equipment> inClearing =
                storageEquipmentRepo.getEquipmentByCondition(7L);
        model.addAttribute("in_clearing", inClearing);

        Iterable<RepairType> repairTypes = List.of(RepairType.values());
        model.addAttribute("repair_types", repairTypes);


        return "workshopWorkshop";
    }

    @GetMapping("/repair_card/{repair_card_id}")
    public String repairCard(
            Model model,
            @PathVariable String repair_card_id
    ) {

        UUID repairCardId = UUID.fromString(repair_card_id);

        RepairCardOfEquipment repairCardOfEquipment =
                repairCardOfEquipmentRepo
                .findById(repairCardId)
                .orElseThrow();
        model.addAttribute("repair_card", repairCardOfEquipment);

        WorkshopElement workshopElement = repairCardOfEquipment.getWorkshopElement();
        model.addAttribute("equipment", workshopElement);

        Element element = elementRepo.findById(workshopElement
                        .getWorkshopEquipment().getId())
                .orElseThrow();
        model.addAttribute("element", element);

        Iterable<Element> elements_destination =
                elementRepo.findElementDestinationAll(element.getId());
        model.addAttribute("elem_destination", elements_destination);

        Iterable<RepairCardOfModule> repairCardOfModules =
                repairCardOfModuleRepo.findByRepairCardId(repairCardId);
        model.addAttribute("repair_cards_of_modules", repairCardOfModules);

        Iterable<ConsumptionOfMaterial> consumptionOfMaterials =
                consumptionOfMaterialRepo.findAll();
        model.addAttribute("consumption_of_materials", consumptionOfMaterials);

        return "workshopRepairCard";
    }

    @GetMapping("/repair_card/{repair_card_id}/{unit_id}")
    public String moduleRepair(
            Model model,
            @PathVariable String repair_card_id,
            @PathVariable String unit_id
    ) {
        Long unitId = Long.valueOf(unit_id);
        UUID repairCardId = UUID.fromString(repair_card_id);

        RepairCardOfEquipment repairCardOfEquipment = repairCardOfEquipmentRepo
                .findById(repairCardId)
                .orElseThrow();
        model.addAttribute("repair_card", repairCardOfEquipment);

        Element element = null;

        Optional<Element> optionalElement = elementRepo
                .findById(unitId);
        if (optionalElement.isPresent()) {
            element = optionalElement.get();
        } else {
            return "redirect:/workshop";
        }

        WorkshopUnit workshopUnit = workshopUnitRepo.findById(unitId)
                .orElse(new WorkshopUnit());
        if (workshopUnit.getName() == null) {
            workshopUnit.setId(unitId);
            workshopUnit.setName(element.getName());
            workshopUnitRepo.save(workshopUnit);
        }
        model.addAttribute("unit", workshopUnit);

        WorkshopModule workshopModule = workshopModuleRepo
                .findModule(
                        repairCardOfEquipment
                                .getWorkshopElement()
                                .getId(),
                        workshopUnit.getId()
                )
                .orElse(new WorkshopModule());
        if (workshopModule.getName() == null) {
            workshopModule.setName(workshopUnit.getName());
            workshopModule.setWorkshopUnit(workshopUnit);
            workshopModule.setWorkshopElement(
                    repairCardOfEquipment
                            .getWorkshopElement()
            );
            workshopModuleRepo.save(workshopModule);
        }
        model.addAttribute("workshop_module", workshopModule);

//        SparePart sparePart = sparePartRepo.findById(
//                element.getProxies()
//        )

        Iterable<CompletedWork> completedWorks = completedWorkRepo
                .findAllByUnitId(workshopUnit.getId());
        model.addAttribute("completed_works", completedWorks);

        Iterable<Element> elements_destination =
                elementRepo.findElementDestinationAll(element.getId());
        model.addAttribute("elements_destination", elements_destination);

        Iterable<Element> elementsCompositeSet =
                elementsCompositeRepo.findAllByElemDestination(element);
        model.addAttribute("elements_composite", elementsCompositeSet);

        Iterable<Element> elements_proxy =
                elementRepo.findAllProxy(element.getId());
        model.addAttribute("elements_proxy", elements_proxy);

        Iterable<ConsumptionOfMaterial> consumptionOfMaterials =
                consumptionOfMaterialRepo.findAllWithLazy(
                        workshopModule.getId()
                );
        model.addAttribute("consumption_of_materials", consumptionOfMaterials);

        OperationType[] operationType = OperationType.values();
        model.addAttribute("operation_type", operationType);

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

    @PostMapping("take_elements")
    private String takeElements(
            @RequestParam String path
    ) {
        Iterable<Element> elements = elementRepo
                .findAllByCategory(Category.ОБОРУДОВАНИЕ);
        WorkshopEquipment workshopEquipment = null;
        Set<WorkshopEquipment> workshopEquipmentSet = new HashSet<>();

        for(Element e: elements) {
            workshopEquipment = workshopEquipmentRepo
                    .findById(e.getId())
                    .orElse(new WorkshopEquipment());
            workshopEquipment.setName(e.getName());
            workshopEquipmentSet.add(workshopEquipment);
        }
        workshopEquipmentRepo.saveAll(workshopEquipmentSet);



        return "redirect:" + path;
    }

    @PostMapping("set_repair")
    private String setRepair(
            Model model,
            @RequestParam String elem_id,
            @RequestParam String repair_type
    ) {
        RepairType repairType = RepairType.valueOf(repair_type);

        Condition condition = conditionRepo.findById(1L).orElseThrow();

        Equipment storageEquipment = storageEquipmentRepo
                .findById(Long.valueOf(elem_id))
                .orElseThrow();
        storageEquipment.setCondition(condition);
        storageEquipmentRepo.save(storageEquipment);

        WorkshopUnit workshopUnit = workshopUnitRepo.findByName(
                storageEquipment.getGood().getName()
                )
                .orElse(new WorkshopUnit());
        if (workshopUnit.getId() == null) {
            workshopUnit.setId(storageEquipment.getGood().getId());
            workshopUnit.setName(storageEquipment.getGood().getName());
            workshopUnitRepo.save(workshopUnit);
        }

        WorkshopElement workshopElement =
                workshopElementRepo.findByInventoryNumber(storageEquipment.getInventoryNumber())
                        .orElse(new WorkshopElement());
        if(workshopElement.getId() == null) {
            workshopElement.setId(storageEquipment.getId());
            workshopElement.setInventoryNumber(storageEquipment.getInventoryNumber());
            workshopElementRepo.save(workshopElement);
        }

        RepairCardOfEquipment repairCardOfEquipment = new RepairCardOfEquipment();
        repairCardOfEquipment.setWorkshopElement(workshopElement);
        repairCardOfEquipment.setRepairType(repairType);
        repairCardOfEquipmentRepo.save(repairCardOfEquipment);

        return "redirect:/workshop";
    }

    @PostMapping("/repair_card/endRepair")
    private String endRepair(
//        @ModelAttribute("repair_card") RepairCardOfEquipment repair_card
        @RequestParam String repair_card_id,
        @RequestParam String storage_equipment_id
    ) {

        Long storageEquipmentId = Long.valueOf(storage_equipment_id);
        Condition condition = conditionRepo.findById(0L).orElseThrow();

        Equipment storageEquipment =
                storageEquipmentRepo.findById(storageEquipmentId)
                        .orElseThrow();
        storageEquipment.setCondition(condition);
        storageEquipmentRepo.save(storageEquipment);

        ZonedDateTime zonedDateTime = ZonedDateTime.of(
                LocalDateTime.now(), ZoneId.of("UTC+8"));


        UUID repairCardUUID = UUID.fromString(repair_card_id);
        RepairCardOfEquipment repairCardOfEquipment =
                repairCardOfEquipmentRepo.findById(repairCardUUID)
                        .orElseThrow();

        repairCardOfEquipment.setEndRepairTimestamp(
                zonedDateTime
        );
        repairCardOfEquipmentRepo.save(repairCardOfEquipment);

        return "redirect:/workshop";
    }

    @PostMapping("/repair_card/writeOff")
    private String writeOffEquipment(
            @RequestParam String repair_card_id,
            @RequestParam String storage_equipment_id
    ) {

        Long storageEquipmentId = Long.valueOf(storage_equipment_id);
        Condition condition = conditionRepo.findById(4L).orElseThrow();

        Equipment storageEquipment =
                storageEquipmentRepo.findById(storageEquipmentId)
                        .orElseThrow();
        storageEquipment.setCondition(condition);
        storageEquipmentRepo.save(storageEquipment);

        ZonedDateTime zonedDateTime = ZonedDateTime.of(
                LocalDateTime.now(), ZoneId.of("UTC+8"));


        UUID repairCardUUID = UUID.fromString(repair_card_id);
        RepairCardOfEquipment repairCardOfEquipment =
                repairCardOfEquipmentRepo.findById(repairCardUUID)
                        .orElseThrow();

        repairCardOfEquipment.setEndRepairTimestamp(
                zonedDateTime
        );
        repairCardOfEquipmentRepo.save(repairCardOfEquipment);

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
