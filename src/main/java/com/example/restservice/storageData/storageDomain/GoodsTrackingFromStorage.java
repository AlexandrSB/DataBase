package com.example.restservice.storageData.storageDomain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class GoodsTrackingFromStorage {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(mappedBy = "goodsTrackingFromStorage", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private PartyFromStorage partyFromStorage;

    @ManyToOne
    @JoinColumn(name = "storage_id")
    private Storage storage;

    @ManyToOne
    @JoinColumn(name = "workshop_id")
    private Workshop workshop;

    @ManyToOne
    @JoinColumn(name = "goods_tracking_date_id")
    private GoodsTrackingDate goodsTrackingDate;
}
