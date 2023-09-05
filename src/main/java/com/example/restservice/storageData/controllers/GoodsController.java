package com.example.restservice.storageData.controllers;

import com.example.restservice.equipmentData.equipmentDomain.Element;
import com.example.restservice.equipmentData.equipmentRepos.ElementRepo;
import com.example.restservice.storageData.storageDomain.*;
import com.example.restservice.storageData.storageRepos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
@RequestMapping("/storage")
public class GoodsController {

    @Autowired
    private GoodsRepo goodsRepo;

    @Autowired
    private ElementRepo elementRepo;

    @Autowired
    private ConditionRepo conditionRepo;

    @Autowired
    private EquipmentRepo equipmentRepo;

    @Autowired
    private ContragentRepo contragentRepo;

    @Autowired
    private StorageRepo storageRepo;

    @Autowired
    private WorkshopRepo workshopRepo;

    @Autowired
    private QuantityAccountRepo quantityAccountRepo;



    @GetMapping("/goods")
    public String showGoods(Model model) {

        Iterable<Good> goods = goodsRepo.findAll();
        model.addAttribute("goods", goods);

        Iterable<Element> elements = elementRepo.findAll();
        model.addAttribute("elements", elements);

        Iterable<Condition> conditions = conditionRepo.findAll();
        model.addAttribute("conditions", conditions);

        Map<String, String> mapOfGoods = new HashMap<>();
        List<Map<String, String>> listOfGoods = new ArrayList<>();
        String elem_type;
        Optional<String> gd_elem;

        for ( Good good : goods ) {
            mapOfGoods.put("id", String.valueOf(good.getId()));
            mapOfGoods.put("name", good.getName());
            mapOfGoods.put("condition", good.getCondition().getName());
            gd_elem = Optional.ofNullable(elementRepo.findById(
                    Long.valueOf(
                            good.getExternalEquipId()
                    )
            ).get().getElementType().getType());


            mapOfGoods.put("type", gd_elem.orElse("none"));
            listOfGoods.add(mapOfGoods);

        }
        model.addAttribute("mapOfGoods", mapOfGoods );

        return "goods";
    }

    @GetMapping("/arrival")
    public String arrivalGoods(
            Model model
    ) {

        Iterable<Good> goods = goodsRepo.findAll();
        model.addAttribute("goods", goods);

        Iterable<Contragent> contragents = contragentRepo.findAll();
        model.addAttribute("contragents", contragents);

        Iterable<Storage> storages = storageRepo.findAll();
        model.addAttribute("storages", storages);

        Iterable<QuantityAccount> quantityAccount = quantityAccountRepo.findAll();
        model.addAttribute("quantities", quantityAccount );

        return "arrival";
    }

    @GetMapping("/expense")
    public String expenseGoods(
            Model model
    ) {

        Iterable<Good> goods = goodsRepo.findAll();
        model.addAttribute("goods", goods);

        Iterable<Workshop> workshops = workshopRepo.findAll();
        model.addAttribute("workshops", workshops);

        Iterable<Storage> storages = storageRepo.findAll();
        model.addAttribute("storages", storages);

        Iterable<QuantityAccount> quantityAccount = quantityAccountRepo.findAll();
        model.addAttribute("quantities", quantityAccount );

        return "expense";
    }

    @PostMapping("add_goods")
    public String addGoogs(
            @RequestParam String element_name,
            @RequestParam( required = false ) String description,
            @RequestParam( required = false ) String inventory_number,
            @RequestParam( required = false ) String barcode,
            @RequestParam String condition_name,
            Model model
    ) {
        if ( element_name.isEmpty() ) {
            return "goods";
        }

        Condition condition =
                conditionRepo.findByName(condition_name).get();

        Element element =
                elementRepo.findByName( element_name ).get();

        Equipment equipment = new Equipment();

        Good good = new Good();
        good.setName( element.getName() );
        good.setExternalEquipId( element.getId() );
        good.setCondition( condition );
        goodsRepo.save(good);

        if ( !inventory_number.isEmpty() &&
                inventory_number.length() > 5 ) {
            equipment.setId( good.getId() );
            equipment.setInventoryNumber( inventory_number);
            equipment.setGood( good );
            equipmentRepo.save( equipment );
        }

        return "redirect:/storage/goods";
    }
}