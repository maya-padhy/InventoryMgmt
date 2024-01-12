package com.maya.networkinventorybackend.control;



import com.maya.networkinventorybackend.model.NetworkAsset;
import com.maya.networkinventorybackend.model.Supplier;
import com.maya.networkinventorybackend.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {

    @Autowired
    SupplierService supplierService;


    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public Supplier createSupplier(@RequestBody Supplier supplier) {
        return supplierService.createSupplier(supplier);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public List<Supplier> getAllSuppliers() {
        return supplierService.getAllSuppliers();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}")
    public Supplier getSupplierById(@PathVariable Long id) {
        return supplierService.getSupplierById(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/{id}")
    public Supplier updateSupplier(@PathVariable Long id, @RequestBody Supplier updatedSupplier) {
        return supplierService.updateSupplier(id, updatedSupplier);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/{id}")
    public void deleteSupplier(@PathVariable Long id) {
        supplierService.deleteSupplier(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{supplierName}/supplied-assets")
    public List<NetworkAsset> getAssetsSuppliedBySupplier(@PathVariable String supplierName) {
        return supplierService.getAssetsSuppliedBySupplier(supplierName);
    }
}

