package com.example.restservice.workshopData.controllers;

import com.example.restservice.equipmentData.equipmentDomain.Category;
import com.example.restservice.equipmentData.equipmentDomain.Element;
import com.example.restservice.equipmentData.equipmentDomain.ElementsComposite;
import com.example.restservice.equipmentData.equipmentDomain.Proxy;
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
import com.example.restservice.workshopData.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
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
    @Autowired
    private TypeOfOperationRepo typeOfOperationRepo;

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
//            8 -- На кеше
//        """
// TODO сделать функцию проверки оборудования в ремонте(со склада)
        Iterable<Long> equipmentsId = workshopElementRepo.getAllId();
        Iterable<Element> element = elementRepo.findAllById(equipmentsId);
        model.addAttribute("workshop_equipment", element);

        Iterable<RepairCardOfEquipment> inRepairs =
                repairCardOfEquipmentRepo.getCardInRepair();
        model.addAttribute("repair_cards", inRepairs);

//        Iterable<Equipment> inDiagnostics =
//                storageEquipmentRepo.getEquipmentByCondition(6L);
//        model.addAttribute("in_diagnostics", inDiagnostics);
//
//        Iterable<Equipment> inClearing =
//                storageEquipmentRepo.getEquipmentByCondition(7L);
//        model.addAttribute("in_clearing", inClearing);
//

        return "workshopRepair";
    }

    @GetMapping("/awaiting")
    public String awaitingRepair(
            Model model
    ) {
        Iterable<Equipment> awaitingRepairs =
                storageEquipmentRepo.getEquipmentByCondition(2L);
        model.addAttribute("awaiting_repairs", awaitingRepairs);

        Iterable<RepairType> repairTypes = List.of(RepairType.values());
        model.addAttribute("repair_types", repairTypes);

        return "workshopAwaitingRepairs";
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

        // TODO это нормально?
        Proxy proxy = proxyRepo
                .findByName(repairCardOfEquipment.getEquipmentName())
                .orElseThrow();
        Element element = elementRepo
                .findById(proxy.getModule().getId())
                .orElseThrow();
        model.addAttribute("element", element);

        Iterable<Element> elements_destination =
                elementRepo.findElementDestinationAll(element.getId());
        model.addAttribute("elem_destination", elements_destination);

        Iterable<RepairCardOfModule> repairCardOfModules =
                repairCardOfModuleRepo.findByRepairCardId(repairCardId);
        model.addAttribute("repair_cards_of_modules", repairCardOfModules);

        Iterable<TypeOfOperation> typeOfOperations =
                typeOfOperationRepo.findAll();
        model.addAttribute("type_of_operations", typeOfOperations);
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

    // TODO изменить функцию по заполнению Мастерской
    @PostMapping("take_elements")
    private String takeElements(
            @RequestParam String path
    ) {
        WorkshopEquipment workshopEquipment = null;
        WorkshopElement workshopElement = null;
        Set<WorkshopEquipment> workshopEquipmentSet = new HashSet<>();
        Set<WorkshopProxy> workshopProxies = new HashSet<>();
        Set<WorkshopElement> workshopElements = new HashSet<>();
        List<WorkshopModule> workshopModules = new ArrayList<>();
        List<WorkshopUnit> workshopUnits = new ArrayList<>();

        Iterable<Element> elements = elementRepo.findAll();
        Iterable<Equipment> storageEquipments =
                storageEquipmentRepo.findAllWithLazy();

        for(Element e: elements) {
            if (e.getCategory().equals(Category.ОБОРУДОВАНИЕ)) {
                workshopEquipment = workshopEquipmentRepo
                        .findById(e.getId())
                        .orElse(new WorkshopEquipment());
                workshopEquipment = WorkshopEquipmentService
                        .fullWorkshopEquipment(
                                workshopEquipment, e.getId(), e.getName()
                        );
                workshopEquipmentSet.add(workshopEquipment);

                for (Proxy p : e.getProxies()) {
                    WorkshopProxy workshopProxy = workshopProxyRepo
                            .findById(p.getId())
                            .orElse(new WorkshopProxy());
                    workshopProxy.setId(p.getId());
                    workshopProxy.setName(p.getName());
                    workshopProxy.setWorkshopEquipment(workshopEquipment);
                    workshopProxies.add(workshopProxy);
                }
            } else if (e.getCategory().equals(Category.МОДУЛЬ)) {
                WorkshopUnit wu = workshopUnitRepo
                        .findById(e.getId())
                        .orElse(new WorkshopUnit());
                wu.setId(e.getId());
                wu.setName(e.getName());
                workshopUnits.add(wu);

//                for (Proxy p: e.getProxies()) {
//                    WorkshopModule workshopModule = workshopModuleRepo
//                            .findById(p.getId())
//                            .orElse(new WorkshopModule());
//                    workshopModule.setName(p.getName());
//                    workshopModule.setWorkshopUnit(wu);
//                    workshopModules.add(workshopModule);
//                }
//            } else if (e.getCategory().equals(Category.ЗАПЧАСТЬ)) {
//
            }
        }

        for (Equipment e : storageEquipments) {
            workshopElement = workshopElementRepo
                    .findById(e.getId())
                    .orElse(new WorkshopElement());
            workshopElement.setId(e.getId());
            workshopElement.setPrefixInventoryNumber(
                    String.valueOf(e.getPrefixInventoryNumber().getPrefix())
            );
            workshopElement.setInventoryNumber(e.getInventoryNumber());
//            workshopElement.setWorkshopProxy(
//                    workshopProxyRepo.findById(e.getId()).orElseThrow()
//            );
            workshopElements.add(workshopElement);
        }

        workshopEquipmentRepo.saveAll(workshopEquipmentSet);
        workshopProxyRepo.saveAll(workshopProxies);
        workshopUnitRepo.saveAll(workshopUnits);
        workshopModuleRepo.saveAll(workshopModules);
        workshopElementRepo.saveAll(workshopElements);



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

//        WorkshopUnit workshopUnit = workshopUnitRepo.findByName(
//                storageEquipment.getGood().getName()
//                )
//                .orElse(new WorkshopUnit());
//        if (workshopUnit.getId() == null) {
//            workshopUnit.setId(storageEquipment.getGood().getId());
//            workshopUnit.setName(storageEquipment.getGood().getName());
//            workshopUnitRepo.save(workshopUnit);
//        }
//
        WorkshopElement workshopElement =
                workshopElementRepo.findByInventoryNumber(
                        storageEquipment.getInventoryNumber()
                        )
                        .orElse(new WorkshopElement());
        if(workshopElement.getId() == null) {
            workshopElement.setId(storageEquipment.getId());
            workshopElement.setPrefixInventoryNumber(
		            storageEquipment.getPrefixInventoryNumber().getPrefix()
            );
            workshopElement.setInventoryNumber(storageEquipment.getInventoryNumber());
            workshopElementRepo.save(workshopElement);
        }

        RepairCardOfEquipment repairCardOfEquipment = new RepairCardOfEquipment();
        repairCardOfEquipment.setWorkshopElement(workshopElement);
        repairCardOfEquipment.setRepairType(repairType);
        repairCardOfEquipment.setEquipmentName(storageEquipment.getGood().getName());
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

        // TODO заменить тайм-зону из настроек
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
