package com.maya.networkinventorybackend.control;

import com.maya.networkinventorybackend.model.NetworkAsset;
import com.maya.networkinventorybackend.service.NetworkAssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/network-assets")
public class NetworkAssetController {

    @Autowired
    NetworkAssetService networkAssetService;



    // Create a new network asset
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public NetworkAsset createNetworkAsset(@RequestBody NetworkAsset networkAsset) {
        System.out.println("Creating network asset.....");
        return networkAssetService.createNetworkAsset(networkAsset);
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public List<NetworkAsset> getAllNetworkAssets() {
        return networkAssetService.getAllNetworkAssets();
    }

    // Get a specific network asset by ID

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}")
    public NetworkAsset getNetworkAssetById(@PathVariable Long id) {
        return networkAssetService.getNetworkAssetById(id);
    }

    // Update a network asset

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/{id}")
    public NetworkAsset updateNetworkAsset(@PathVariable Long id, @RequestBody NetworkAsset networkAsset) {
        return networkAssetService.updateNetworkAsset(id, networkAsset);
    }

    // Delete a network asset
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/{id}")
    public void deleteNetworkAsset(@PathVariable Long id) {
        networkAssetService.deleteNetworkAsset(id);
    }



    // Deactivate a network asset by ID
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/toggle-status/{id}")
    public NetworkAsset deactivateNetworkAsset(@PathVariable Long id) {
        return networkAssetService.toggleAssetStatus(id);
    }

    @GetMapping("/asset-types")
    public List<String> getAllAssetTypes() {
        return networkAssetService.getAllAssetTypes();
    }

    @PostMapping("/asset-types")
    public void addAssetType(@RequestBody String newType) {
         networkAssetService.addAssetType(newType);
    }

    @DeleteMapping("/asset-types/{type}")
    public void deleteAssetType(@PathVariable String type) {
        networkAssetService.deleteAssetTypeByType(type);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/unstock/{id}")
    public NetworkAsset unstockNetworkAsset(@PathVariable Long id, @RequestParam int unstockQty) {
        return networkAssetService.unstockNetworkAsset(id, unstockQty);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/restock/{id}")
    public NetworkAsset restockNetworkAsset(@PathVariable Long id, @RequestParam int restockQty) {
        return networkAssetService.restockNetworkAsset(id, restockQty);
    }




}

