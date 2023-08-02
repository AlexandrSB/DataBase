package com.example.restservice.storageData.storageDomain;

import com.example.restservice.storageData.storageDomain.Equipment;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = {"id", "storageName", "description"})
@NoArgsConstructor(force = true)
//@RequiredArgsConstructor(onConstructor = @__( @Autowired))
@EnableAutoConfiguration
@Table(name = "storage", schema = "public")
public class Storage {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "storage_id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String storageName;

    @Column( name = "quantity")
    private Integer quantity;

    @Column( name = "delivery_date" )
    private Date deliveryDate;

    @Column( name = "issue_date" )
    private Date issueDate;

    @Column( name = "descriprion" )
    private String description;

    @Column( name = "equipment_id" )
    private Equipment equipment;

    @ManyToMany
    @JoinTable(
            name = "goods_storage",
            joinColumns = {
                    @JoinColumn( name = "storage_id" )
            },
            inverseJoinColumns = {
                    @JoinColumn( name = "goods_id" )
            }
    )
    private Set< Goods > goods = new HashSet<>();
}
