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
    private ParcelRepo parcelRepo;



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

    @GetMapping("/new_party")
    private String newParty() {
        return "newParty";
    }

    @PostMapping("addToParty")
    private String addToParty (
            @RequestParam String party_name,
            @RequestParam String good_name,
            @RequestParam String quantity_dimension,
            @RequestParam String quantity,
            @RequestParam String proxy_name,
            Model model
    ) {

        Party party = new Party();
        QuantityAccount quantityAccount = new QuantityAccount();
        Quantity dimension = quantityRepo.
                findByDimension(quantity_dimension)
                .get();
        quantityAccount.setQuantity(Integer.valueOf(quantity));
        quantityAccount.addDimension(dimension);
        Good good = null;
        Proxy proxy = null;
        try {
            good = goodsRepo.findByName( good_name ).orElseThrow(
                    () -> new Exception("good not found! " + good_name )
            );
            proxy = proxyRepo.findByName( proxy_name ).orElseThrow(
                    () -> new Exception("proxy not found! " + proxy_name)
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
//        quantityAccountRepo.save(quantityAccount);
        party.setName(party_name);

//        partyRepo.save(party);

        Parcel parcel = new Parcel();
        parcelRepo.save(parcel);


        return "redirect:/storage/parcel/" + parcel.getId();
    }
}
