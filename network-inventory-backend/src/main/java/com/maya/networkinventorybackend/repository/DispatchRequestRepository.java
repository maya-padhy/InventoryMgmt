package com.maya.networkinventorybackend.repository;

import com.maya.networkinventorybackend.model.DispatchAsset;
import com.maya.networkinventorybackend.model.DispatchRequest;
import com.maya.networkinventorybackend.model.NetworkAsset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DispatchRequestRepository extends JpaRepository<DispatchRequest, Long> {
    @Query(value = "select * from network_asset",nativeQuery = true)
    List<DispatchAsset> findByDispatchRequest(Long id);
}