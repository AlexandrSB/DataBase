package com.example.restservice.storageData.controllers;

import com.example.restservice.equipmentData.equipmentDomain.Proxy;
import com.example.restservice.equipmentData.equipmentRepos.ProxyRepo;
import com.example.restservice.storageData.storageDomain.Good;
import com.example.restservice.storageData.storageDomain.Party;
import com.example.restservice.storageData.storageDomain.Quantity;
import com.example.restservice.storageData.storageDomain.QuantityAccount;
import com.example.restservice.storageData.storageRepos.GoodsRepo;
import com.example.restservice.storageData.storageRepos.PartyRepo;
import com.example.restservice.storageData.storageRepos.QuantityAccountRepo;
import com.example.restservice.storageData.storageRepos.QuantityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/storage")
public class PartyFromContragentController {

    @Autowired
    private GoodsRepo goodsRepo;

    @Autowired
    private QuantityAccountRepo quantityAccountRepo;

    @Autowired
    private QuantityRepo quantityRepo;

    @Autowired
    private PartyRepo partyRepo;

    @Autowired
    private ProxyRepo proxyRepo;

    @GetMapping("/contragents_party")
    private String contragentsParty(
            Model model
    ) {

        Iterable<Good> goods = goodsRepo.findAll();
        model.addAttribute("goods", goods);

        Iterable<Proxy> proxies = proxyRepo.findAll();
        model.addAttribute("proxies", proxies);

        Iterable<QuantityAccount> quantityAccount = quantityAccountRepo.findAll();
        model.addAttribute("quantities_account", quantityAccount );

        Iterable<Quantity> quantities = quantityRepo.findAll();
        model.addAttribute("quantities", quantities);

        Iterable<Party> partyFromContragents = partyRepo.findAll();
        model.addAttribute(
                "partyFromContragents", partyFromContragents
        );

        return "contragentsParty";
    }

    @PutMapping("addToParty")
    private String addToParty (
            @RequestParam String good_name,
            @RequestParam String quantity_dimension,
            @RequestParam String quantity,
            Model model
    ) {

        Party party = new Party();
        QuantityAccount quantityAccount = new QuantityAccount();
        Good good = goodsRepo.findByName( "good_name").get();

        return "redirect:/storage/contragents_party";
    }
}
