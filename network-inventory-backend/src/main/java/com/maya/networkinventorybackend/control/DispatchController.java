package com.maya.networkinventorybackend.control;

import com.maya.networkinventorybackend.model.AssetIdAndQuantity;
import com.maya.networkinventorybackend.model.DispatchAsset;
import com.maya.networkinventorybackend.model.DispatchRequest;
import com.maya.networkinventorybackend.model.NetworkAsset;
import com.maya.networkinventorybackend.repository.DispatchRequestRepository;
import com.maya.networkinventorybackend.service.MailService;
import com.maya.networkinventorybackend.service.NetworkAssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RequestMapping("/api/network-assets/dispatch")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class DispatchController {

    @Autowired
    private NetworkAssetService networkAssetService;
    @Autowired
    private DispatchRequestRepository dispatchRequestRepository;
    @Autowired
    private MailService mailService;


    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("")
    public ResponseEntity<?> dispatchInventory(@RequestBody DispatchRequest dispatchRequest) {
        try {
            System.out.println("Received Dispatch Request: " + dispatchRequest.toString());
            String customer_mail=dispatchRequest.getCustomerEmail();

            List<DispatchAsset> dispatchAssets = dispatchRequest.getAssets();

            // Iterate through dispatched assets and update quantities
//            for (DispatchAsset asset : dispatchAssets) {
                // Ensure the asset has a valid ID before attempting to update it
//                if (asset.getAssetName() != null) {
//                    networkAssetService.unstockAsset(asset.getId(), asset.getQuantity());

                    // Set the dispatchRequest for the asset
//                    asset.setDispatchRequest(dispatchRequest);
//                }
//            }

            // Create a new dispatch request and save it in the database
            DispatchRequest savedRequest = dispatchRequestRepository.save(dispatchRequest);

            mailService.sendMail(customer_mail,"Dispatch Details",dispatchRequest.toString());

            // Handle other dispatch-related tasks, such as sending notifications

            return ResponseEntity.ok("{\"message\": \"Inventory dispatched successfully\"}");
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\": \"Error dispatching inventory\"}");
        }
    }



    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/update-quantity")
    public ResponseEntity<?> unstockInventory(@RequestBody List<AssetIdAndQuantity> dispatchAssets) {
        try {
            for (AssetIdAndQuantity asset : dispatchAssets) {

                System.out.println("HI");
                System.out.println("Asset ID: " + asset.getAssetName() + ", Quantity: " + asset.getQuantity());

                networkAssetService.unstockAsset(asset.getAssetName(), asset.getQuantity());
            }
            return ResponseEntity.ok("{\"message\": \"Inventory unstocked successfully\"}");
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"error\": \"Error unstocking inventory\"}");
        }
    }

//    @CrossOrigin(origins = "http://localhost:4200")
//    @GetMapping("/dispatch-history")
//    public List<DispatchRequest> getDispatchHistory() {
//        return dispatchRequestRepository.findAll();
//    }


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/dispatch-history")
    public List<DispatchRequest> getDispatchHistoryWithAssets() {
        List<DispatchRequest> dispatchs = new ArrayList<>();
        return dispatchRequestRepository.findAll();
//        System.out.println("sdfg"+dispatchRequests);
//        dispatchRequests.forEach(dispatchRequest -> {
//            List<DispatchAsset> assets = dispatchRequestRepository.findByDispatchRequest(dispatchRequest.getId());
//            System.out.println("displaying assets...");
//            System.out.println(assets);
//            dispatchRequest.setAssets(assets);
//            dispatchs.add(dispatchRequest);
//        });
//        return dispatchs;
    }

}

