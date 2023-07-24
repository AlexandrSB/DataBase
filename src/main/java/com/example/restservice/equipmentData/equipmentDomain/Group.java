package com.example.restservice.equipmentData.equipmentDomain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Table(name = "groups", schema = "public")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "group_id", nullable = false)
    private Long id;

    @NonNull
    @Column(name = "group_name")
    private String groupName;

    @ManyToOne
    @JoinColumn(name = "id")
    @Column(name = "parent_id")
    private Long parent;

//    @OneToMany
//    @JoinColumn(name = "parent")
//    Set<Groups> toParent = new HashSet<>();
//
//    public Set<Groups> addParent(Groups groups) {
//        this.toParent.add(groups);
//        return this.toParent;
//    }
//
//    public Set<Groups> addParents(Set<Groups> groups) {
//        this.toParent.addAll(groups);
//        return this.toParent;
//    }
}
