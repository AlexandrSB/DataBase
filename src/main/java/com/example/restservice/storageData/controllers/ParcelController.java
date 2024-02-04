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


    @ModelAttribute
    private void addAttributes(Model model) {
        Iterable<String> goodsNamesOnlyParcels = goodsRepo.getGoodsNamesOnlyParcels();
        model.addAttribute("goods_names_only_parcels", goodsNamesOnlyParcels);

        Iterable<String> quantities = quantityRepo.getQuantitiesName();
        model.addAttribute("quantities", quantities);

        Iterable<Proxy> proxies = proxyRepo.findAll();
        model.addAttribute("proxies", proxies);
    }

    @GetMapping
    public String getParcels(Model model) {

        Iterable<Parcel> parcels = parcelRepo.findAllParcelsWithGood();
        model.addAttribute("parcelsWithGoods", parcels);

        Iterable<Proxy> proxies = proxyRepo.findAll();
        model.addAttribute("proxies", proxies);

        return "storageParcels";
    }


    @GetMapping("{id}")
    private String newParcel(
            @PathVariable String id,
            Model model
    ) {

        Long party_id = Long.valueOf(id);
//        Iterable<Parcel> parcels = partyRepo
//                .findAllParcelsWithPartyId(party_id);
        Iterable<Parcel> parcels = parcelRepo
                .findAllParcelsWithGoodAndQuandtityAccountAndParty(
                        party_id
                );
        model.addAttribute("parcels", parcels);

        model.addAttribute("party_id", id);

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

        return "redirect:/storage/parcel/" + party.getId();
    }

    @PostMapping("redirectToGoodsTrackingFromContragent")
    private String redirectToGoodsTrackingFromContragent(
            @RequestParam String party_id,
            Model model) {

        GoodsTrackingFromContragent goodsTrackingFromContragent =
                new GoodsTrackingFromContragent();

        Long id = Long.valueOf(party_id);
        Party party = partyRepo.findById(id).get();

        goodsTrackingFromContragent.addParty(party);
        goodsTrackingFromContragentRepo.save(
                goodsTrackingFromContragent
        );

        return "redirect:/storage/goods_tracking_from_contragent/" +
                goodsTrackingFromContragent.getId();
    }
}
