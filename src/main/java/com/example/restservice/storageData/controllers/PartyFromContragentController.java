package com.example.restservice.storageData.controllers;

import com.example.restservice.equipmentData.equipmentDomain.Proxy;
import com.example.restservice.equipmentData.equipmentRepos.ProxyRepo;
import com.example.restservice.storageData.storageDomain.*;
import com.example.restservice.storageData.storageRepos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


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

    @Autowired
    private ContragentRepo contragentRepo;

    @Autowired
    private StorageRepo storageRepo;

    @Autowired
    private ParcelRepo parcelRepo;

    @GetMapping("/contragents_party")
    private String contragentsParty(
            Model model
    ) {

        Iterable<Contragent> contragents = contragentRepo.findAll();
        model.addAttribute("contragents", contragents);

        Iterable<Storage> storages = storageRepo.findAll();
        model.addAttribute("storages", storages);

        Iterable<Party> partyFromContragents = partyRepo.findAll();
        model.addAttribute(
                "partyFromContragents", partyFromContragents
        );

        return "storageContragentsParty";
    }

    @PostMapping("addToParty")
    private String addToParty (
            @RequestParam String party_name,
            Model model
    ) {

        if (party_name.isBlank()) {
            return "redirect:/storage/contragents_party";
        }

        Party party = new Party();
        party.setName(party_name);
        partyRepo.save(party);

        return "redirect:/storage/parcel/" + party.getId();
    }

}