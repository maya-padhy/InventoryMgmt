package com.maya.networkinventorybackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssetIdAndQuantity {
    private String assetName;
    private Long quantity;
}
