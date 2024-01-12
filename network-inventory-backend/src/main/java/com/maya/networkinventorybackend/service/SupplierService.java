package com.maya.networkinventorybackend.service;


import com.maya.networkinventorybackend.model.NetworkAsset;
import com.maya.networkinventorybackend.model.Supplier;
import com.maya.networkinventorybackend.repository.NetworkAssetRepository;
import com.maya.networkinventorybackend.repository.SupplierRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class SupplierService {

    @Autowired
    SupplierRepository supplierRepository;
    @Autowired
    NetworkAssetRepository networkAssetRepository;



    public Supplier createSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    public Supplier getSupplierById(Long id) {
        return supplierRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Supplier not found with ID: " + id));
    }

    public Supplier updateSupplier(Long id, Supplier updatedSupplier) {
        Supplier existingSupplier = getSupplierById(id);
        existingSupplier.setName(updatedSupplier.getName());
        existingSupplier.setEmail(updatedSupplier.getEmail());
        existingSupplier.setPhoneNumber(updatedSupplier.getPhoneNumber());
        existingSupplier.setAddress(updatedSupplier.getAddress());
        existingSupplier.setWebsite(updatedSupplier.getWebsite());
        return supplierRepository.save(existingSupplier);
    }

    public void deleteSupplier(Long id) {
        supplierRepository.deleteById(id);
    }

    public List<NetworkAsset> getAssetsSuppliedBySupplier(String supplierName) {
        return networkAssetRepository.findBySupplierName(supplierName);
    }
}

