package com.maya.networkinventorybackend.repository;

import com.maya.networkinventorybackend.model.NetworkAsset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NetworkAssetRepository extends JpaRepository<NetworkAsset, Long> {
    // Custom query methods if needed
//
//    @Modifying
//    @Transactional
//    @Query(value = "INSERT INTO network_assets (type) VALUES (:newType)", nativeQuery = true)
//    void saveDistinctType(@Param("newType") String newType);
    @Query("SELECT DISTINCT na.type FROM NetworkAsset na")
    List<String> findDistinctTypes();

    List<NetworkAsset> findBySupplierName(String supplierName);

    Optional<NetworkAsset> findByName(String assetName);

}

