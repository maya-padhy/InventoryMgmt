package com.maya.networkinventorybackend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "network_assets")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NetworkAsset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private String type;
    private String supplierName;
    private String model;
    private int qty;
    private int price;
    private String status;


//    @ManyToMany
//    @JoinTable(
//            name = "network_asset_supplier",
//            joinColumns = @JoinColumn(name = "network_asset_id"),
//            inverseJoinColumns = @JoinColumn(name = "supplier_id")
//    )
//    private Set<Supplier> suppliers = new HashSet<>();
}
