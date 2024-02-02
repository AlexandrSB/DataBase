package com.example.restservice.equipmentData.equipmentDomain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor(force = true)
@Table(name = "elements_group", schema = "public")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @NonNull
    @Column(name = "name", unique = true)
    private String name;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Group parent;

    public Group(@NonNull String name) {
        this.name = name;
    }

    public Group(@NonNull String name, @NonNull Group group) {
        this.name = name;
        this.parent = group;
    }

    public Group setParent(@NonNull Group group) {
        this.parent = group;
        return this;
    }
}
