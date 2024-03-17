package com.example.restservice.storageData.controllers;

import com.example.restservice.equipmentData.equipmentDomain.Category;
import com.example.restservice.equipmentData.equipmentDomain.Proxy;
import com.example.restservice.equipmentData.equipmentRepos.ProxyRepo;
import com.example.restservice.storageData.storageDomain.*;
import com.example.restservice.storageData.storageRepos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;

@Controller
@RequestMapping("/storage/parcel")
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

    @Autowired
    private GoodsTrackingFromContragentRepo
            goodsTrackingFromContragentRepo;

    @Autowired
    private GoodsTrackingDateRepo goodsTrackingDateRepo;

    @Autowired
    private ContragentRepo contragentRepo;
    @Autowired
    private StorageRepo storageRepo;


    @ModelAttribute
    private void addAttributes(Model model) {
        Iterable<String> goodsNamesOnlyParcels = goodsRepo
                .findAllOnlyNameByCategory(
                        Category.ЗАПЧАСТЬ
                );
        model.addAttribute("goods_names_only_parcels", goodsNamesOnlyParcels);

        Iterable<String> quantities = quantityRepo.getQuantitiesName();
        model.addAttribute("quantities", quantities);

        Iterable<Proxy> proxies = proxyRepo.findAll();
        model.addAttribute("proxies", proxies);
    }

    @GetMapping
    public String getParcels(Model model) {

        Iterable<Good> goods = goodsRepo.findAllNotEquipment();
        model.addAttribute("goods_not_equipment", goods);

//        Iterable<Proxy> proxies = proxyRepo.findAll();
//        model.addAttribute("proxies", proxies);
//
        return "storageParcels";
    }


    @GetMapping("{id}")
    private String newParcel(
            @PathVariable String id,
            Model model
    ) {

        Long party_id = Long.valueOf(id);
        Iterable<Parcel> parcels = parcelRepo
                .findAllParcelsByPartyId(party_id);
        model.addAttribute("parcels", parcels);

        Iterable<Good> goods = goodsRepo
                .findAllWithLazy();
        model.addAttribute("goods", goods);

        Iterable<Proxy> proxies = proxyRepo.findAll();
        model.addAttribute("proxies", proxies);

        Iterable<Quantity> dimension =
                quantityRepo.findAll();
        model.addAttribute("quantities", dimension);

        model.addAttribute("party_id", id);
        model.addAttribute("contragents", contragentRepo.findAll());
        model.addAttribute("storages", storageRepo.findAll());

        return "newParty";
    }

    @PostMapping("addParcel")
    private String addParcel(
            @RequestParam String good_id,
            @RequestParam String parcel_name
    ) {

        Good good = goodsRepo.findById(Long.valueOf(good_id))
                .orElseThrow();
        Proxy proxy = proxyRepo.findByName(parcel_name)
                .orElseThrow();

        Parcel parcel = new Parcel();
        parcel.setGood(good);
        parcel.setName(proxy.getName());
        parcel.setProxyId(proxy.getId());

        parcelRepo.save(parcel);


        return "redirect:/storage/parcel";
    }

    @PostMapping("addToParcel/{id}")
    private String addToParcel(
            @RequestParam String pathToNewParty,
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
        parcel.setParty( party );
        parcelRepo.save( parcel );

        return "redirect:" + pathToNewParty;
    }

    @PostMapping("redirectToGoodsTrackingFromContragent")
    private String redirectToGoodsTrackingFromContragent(
            @RequestParam String party_id,
            @RequestParam String contragent_name,
            @RequestParam String storage_name,
            Model model) {

        Long id = Long.valueOf(party_id);
        Party party = partyRepo.findById(id).get();
        GoodsTrackingFromContragent goodsTrackingFromContragent = null;
        Contragent contragent = contragentRepo
                .findByName(contragent_name)
                .orElseThrow();
        Storage storage = storageRepo
                .findByName(storage_name)
                .orElseThrow();


        GoodsTrackingDate goodsTrackingDate = new GoodsTrackingDate();
        goodsTrackingDate.setCreatedOn(ZonedDateTime.now(ZoneId.systemDefault()));
        goodsTrackingDateRepo.save(goodsTrackingDate);

        goodsTrackingFromContragent = Optional.ofNullable(
                party.getGoodsTrackingFromContragent()
        ).orElse(new GoodsTrackingFromContragent());
        goodsTrackingFromContragent.setContragent(contragent);
        goodsTrackingFromContragent.setStorage(storage);
        goodsTrackingFromContragent.setGoodsTrackingDate(goodsTrackingDate);
        goodsTrackingFromContragent.setTypeOfGoodsMovement(
                TypeOfGoodsMovement.ARRIVAL);
        goodsTrackingFromContragentRepo.save(goodsTrackingFromContragent);

        party.setGoodsTrackingFromContragent(goodsTrackingFromContragent);
        partyRepo.save(party);

        return "redirect:/storage/contragents_party";
    }
}
