package com.sit.cov.hackatron.backend.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "store")
public class DBStore {

    private Long id;

    private String ar;

    private String city;

    private String cityDistrict;

    private String country;

    private boolean hasBakeshop;

    private String houseNumber;

    private boolean nf;

    /**
     * opening hours
     */
    private String oh;

    private String storeOperatorId;

    private String storeOperatorUrl;

    private String street;

    private double x;

    private double y;

    private String zipCode;

    private String storeId;

    private String warehouseKey;

    private boolean lidlPlus;

    private boolean hasClickAndCollect;

    private boolean hasHotDrinks;

    private boolean hasDisabledParking;

    private boolean hasECharger;

    private boolean hasPackingStation;

    private boolean hasParking;

    private boolean taxFreeShoppingIsPossible;

    private String positionId;
}
