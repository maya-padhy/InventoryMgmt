package com.maya.networkinventorybackend.service;


import com.maya.networkinventorybackend.model.NetworkAsset;
import com.maya.networkinventorybackend.repository.AssetTypesRepository;
import com.maya.networkinventorybackend.repository.NetworkAssetRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NetworkAssetService {

    @Autowired
    NetworkAssetRepository networkAssetRepository;
    @Autowired
    AssetTypesRepository assetTypesRepository;


    public NetworkAsset createNetworkAsset(NetworkAsset networkAsset) {
        String newType = networkAsset.getType();
        assetTypesRepository.saveDistinctType(newType);
        System.out.println("Createnetser"+networkAsset);
        return networkAssetRepository.save(networkAsset);

        
    }

    public List<NetworkAsset> getAllNetworkAssets() {
        return networkAssetRepository.findAll();
    }

    public NetworkAsset getNetworkAssetById(Long id) {
        return networkAssetRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Network Asset not found with ID: " + id));
    }

    public NetworkAsset updateNetworkAsset(Long id, NetworkAsset updatedNetworkAsset) {
        NetworkAsset existingNetworkAsset = getNetworkAssetById(id);

        // Update the existing network asset with the new data
        existingNetworkAsset.setName(updatedNetworkAsset.getName());
        existingNetworkAsset.setType(updatedNetworkAsset.getType());
        existingNetworkAsset.setSupplierName(updatedNetworkAsset.getSupplierName());
        existingNetworkAsset.setModel(updatedNetworkAsset.getModel());
        existingNetworkAsset.setQty(updatedNetworkAsset.getQty());
        existingNetworkAsset.setPrice(updatedNetworkAsset.getPrice());
        existingNetworkAsset.setStatus(updatedNetworkAsset.getStatus());


        return networkAssetRepository.save(existingNetworkAsset);
    }

    public void deleteNetworkAsset(Long id) {
        networkAssetRepository.deleteById(id);
    }




    public NetworkAsset toggleAssetStatus( Long id) {
        NetworkAsset existingNetworkAsset = getNetworkAssetById(id);

        // Toggle the status between "Active" and "Deactivated"
        if (existingNetworkAsset.getStatus().equals("Active")) {
            existingNetworkAsset.setStatus("Deactivated");
        } else {
            existingNetworkAsset.setStatus("Active");
        }

        return networkAssetRepository.save(existingNetworkAsset);
    }

    public List<String> getAllAssetTypes() {
        return assetTypesRepository.findDistinctTypes();
    }


    @Modifying
    @Transactional
    public void addAssetType(String newType) {
//        networkAssetRepository.saveDistinctType(newType);
         assetTypesRepository.saveDistinctType(newType);
    }

    @Modifying
    @Transactional
    public void deleteAssetTypeByType(String type) {
        assetTypesRepository.deleteByType(type);
    }


    @Transactional
    public NetworkAsset unstockNetworkAsset(Long id, int unstockQty) {
        NetworkAsset asset = networkAssetRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Network Asset not found with ID: " + id));

        // Check if unstock quantity is valid
        if (unstockQty <= 0 || unstockQty > asset.getQty()) {
            throw new IllegalArgumentException("Invalid unstock quantity.");
        }

        asset.setQty(asset.getQty() - unstockQty);
        return networkAssetRepository.save(asset);
    }


    @Transactional
    public NetworkAsset unstockAsset(String assetName, Long unstockQty) {

        System.out.println("Im in unstockAsset service");

        NetworkAsset asset = networkAssetRepository.findByName(assetName).get();

        // Check if unstock quantity is valid
        if (unstockQty <= 0 || unstockQty > asset.getQty()) {
            throw new IllegalArgumentException("Invalid unstock quantity.");
        }

        asset.setQty((int) (asset.getQty() - unstockQty));
        return networkAssetRepository.save(asset);
    }



    @Transactional
    public NetworkAsset restockNetworkAsset(Long id, int restockQty) {
        NetworkAsset asset = networkAssetRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Network Asset not found with ID: " + id));

        // Check if restock quantity is valid
        if (restockQty <= 0) {
            throw new IllegalArgumentException("Invalid restock quantity.");
        }

        asset.setQty(asset.getQty() + restockQty);
        return networkAssetRepository.save(asset);
    }


}
