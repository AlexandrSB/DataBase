package com.example.restservice.storageData.controllers;

import com.example.restservice.equipmentData.equipmentDomain.Proxy;
import com.example.restservice.equipmentData.equipmentRepos.ProxyRepo;
import com.example.restservice.storageData.storageDomain.*;
import com.example.restservice.storageData.storageRepos.*;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.cert.Extension;
import java.util.Optional;

@Controller
@RequestMapping("/storage")
public class ParcelController {

    @Autowired
    private ParcelRepo parcelRepo;

    @Autowired
    private QuantityRepo quantityRepo;

    @Autowired
    private QuantityAccountRepo quantityAccountRepo;

    @Autowired
    private ProxyRepo proxyRepo;

    @Autowired
    private GoodsRepo goodsRepo;

    @Autowired
    private PartyRepo partyRepo;


    @ModelAttribute
    private void addAttributes(Model model) {
        Iterable<Good> goods = goodsRepo.findAll();
        model.addAttribute("goods", goods);

        Iterable<Quantity> quantities = quantityRepo.findAll();
        model.addAttribute("quantities", quantities);

        Iterable<Proxy> proxies = proxyRepo.findAll();
        model.addAttribute("proxies", proxies);
    }

    @GetMapping("/parcel/{id}")
    private String newParcel(
            @PathVariable String id,
            Model model
    ) {

//        Iterable<Parcel> parcels = parcelRepo.findAllWithParties();
        Iterable<Parcel> parcels = parcelRepo.findAllWithParties();
        model.addAttribute("parcels", parcels);

        model.addAttribute("party_id", id);

        return "newParty";
    }

    @PostMapping("/parcel/addToParcel/{id}")
    private String addToParcel(
            @RequestParam String party_id,
            @RequestParam String good_name,
            @RequestParam String quantity_dimension,
            @RequestParam String quantity,
            @RequestParam String proxy_name,
            Model model
    ) {

        Good good = null;
        Proxy proxy = null;
        Parcel parcel = null;
        Party party = null;
        Quantity dimension = null;
        QuantityAccount quantityAccount = new QuantityAccount();
        parcel = new Parcel();

        try {
            party = partyRepo.findById(Long.valueOf(party_id))
                    .orElseThrow(
                            () -> new Exception("party not found! party id is: " + party_id)
                    );
            dimension = quantityRepo
                    .findByDimension(quantity_dimension)
                    .orElseThrow(
                            () -> new Exception("dimension not found! " + quantity_dimension)
                    );
            good = goodsRepo.findByName( good_name ).orElseThrow(
                    () -> new Exception("good not found! " + good_name )
            );
            proxy = proxyRepo.findByName( proxy_name ).orElseThrow(
                    () -> new Exception("proxy not found! " + proxy_name)
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        quantityAccount.setQuantity(Integer.valueOf(quantity));
        quantityAccount.setDimension(dimension);
        quantityAccountRepo.save(quantityAccount);

        parcel.setGood( good );
        parcel.setQuantityAccount( quantityAccount );
        parcelRepo.save( parcel );

        party.setParcel(parcel);
        partyRepo.save(party);

        return "redirect:/storage/parcel/" + parcel.getId();
    }
}
