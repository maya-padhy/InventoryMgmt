package com.maya.networkinventorybackend.repository;

import com.maya.networkinventorybackend.model.AssetTypes;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssetTypesRepository extends JpaRepository<AssetTypes,Integer>
{

    @Query("SELECT DISTINCT assettypes.type FROM AssetTypes assettypes")
    List<String> findDistinctTypes();

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO asset_types (type) VALUES (:newType)", nativeQuery = true)
    void saveDistinctType(@Param("newType") String newType);

    @Modifying
    @Transactional
    @Query("DELETE FROM AssetTypes a WHERE a.type = :type")
    void deleteByType(@Param("type") String type);
}
