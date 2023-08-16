package com.example.restservice.equipmentData.equipmentDomain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import static com.example.restservice.equipmentData.SQL_queries.getRecursiveGroup;

@Entity
@Data
@NoArgsConstructor(force = true)
@Table(name = "groups", schema = "public")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "group_id", nullable = false, unique = true)
    private Long id;

    @NonNull
    @Column(name = "group_name")
    private String groupName;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Group parent;

    public Group(@NonNull String groupName) {
        this.groupName = groupName;
    }

    public Group(@NonNull String groupName, @NonNull Group group) {
        this.groupName = groupName;
        this.parent = group;
    }

    public Group setParent(@NonNull Group group) {
        this.parent = group;
        return this;
    }
}
