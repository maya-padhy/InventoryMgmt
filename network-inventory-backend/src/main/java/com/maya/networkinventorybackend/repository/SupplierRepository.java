package com.maya.networkinventorybackend.repository;

import com.maya.networkinventorybackend.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SupplierRepository extends JpaRepository<Supplier,Long> {
}
