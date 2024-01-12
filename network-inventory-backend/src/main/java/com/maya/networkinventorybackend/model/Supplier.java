package com.maya.networkinventorybackend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "suppliers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String website;

//    @ManyToMany(mappedBy = "suppliers")
//    private Set<NetworkAsset> suppliedAssets = new HashSet<>();
}
