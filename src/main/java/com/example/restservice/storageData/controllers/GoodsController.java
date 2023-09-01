package com.example.restservice.storageData.controllers;

import com.example.restservice.equipmentData.equipmentDomain.Element;
import com.example.restservice.equipmentData.equipmentRepos.ElementRepo;
import com.example.restservice.storageData.storageDomain.Condition;
import com.example.restservice.storageData.storageDomain.Equipment;
import com.example.restservice.storageData.storageDomain.Good;
import com.example.restservice.storageData.storageRepos.ConditionRepo;
import com.example.restservice.storageData.storageRepos.EquipmentRepo;
import com.example.restservice.storageData.storageRepos.GoodsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/storage/goods")
public class GoodsController {

    @Autowired
    private GoodsRepo goodsRepo;

    @Autowired
    private ElementRepo elementRepo;

    @Autowired
    private ConditionRepo conditionRepo;

    @Autowired
    private EquipmentRepo equipmentRepo;

    @GetMapping
    public String showGoods(Model model) {

        Iterable<Good> goods = goodsRepo.findAll();
        model.addAttribute("goods", goods);

        Iterable<Element> elements = elementRepo.findAll();
        model.addAttribute("elements", elements);

        Iterable<Condition> conditions = conditionRepo.findAll();
        model.addAttribute("conditions", conditions);

        Map<String, String> mapOfGoods = new HashMap<>();
        String elem_type;
        Optional<String> gd_elem;

        for ( Good dg : goods ) {
            mapOfGoods.put("id", String.valueOf(dg.getId()));
            mapOfGoods.put("name", dg.getName());
            mapOfGoods.put("condition", dg.getCondition().getName());
            gd_elem = Optional.ofNullable(elementRepo.findById(
                    Long.valueOf(
                            dg.getExternal_equip_id()
                    )
            ).get().getElementType().getType());


            mapOfGoods.put("type", gd_elem.orElse("none"));

        }

        model.addAttribute("mapOfGoods", mapOfGoods );

        return "goods";
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
        good.setExternal_equip_id( element.getId() );
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