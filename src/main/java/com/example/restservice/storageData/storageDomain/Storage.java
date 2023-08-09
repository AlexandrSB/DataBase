package com.example.restservice.storageData.storageDomain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = {"id", "storageName", "description"})
@NoArgsConstructor(force = true)
@Table(name = "storage", schema = "public")
public class Storage {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String storageName;

    @Column( name = "quantity")
    private Integer quantity;

    @Column( name = "description" )
    private String description;

    @ManyToMany
    @JoinTable(
            name = "goods_storage",
            joinColumns = {
                    @JoinColumn( name = "storage_id" )
            },
            inverseJoinColumns = {
                    @JoinColumn( name = "goods_tracking_id" )
            }
    )
    private Set< GoodsTracking > goodsTrackings = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "storage_goods",
            joinColumns = {
                    @JoinColumn(name = "storage_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "goods_id")
            }
    )
    private Set< Goods > goods = new HashSet<>();
}
