package com.sit.cov.hackatron.backend.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "storeId",
    "storeOperatorId",
    "storeOperatorUrl",
    "zipcode",
    "country",
    "city",
    "citydistrict",
    "street",
    "housenumber",
    "x",
    "y",
    "oh",
    "warehouseKey",
    "positionId",
    "nf",
    "hasBakeshop",
    "hasDisabledParking",
    "hasPackingStation",
    "hasParking",
    "taxFreeShoppingIsPossible",
    "hasHotDrinks",
    "hasECharger",
    "lidlPlus",
    "hasClickAndCollect",
    "dataPath"
})
public class Store {
    @JsonProperty("storeId")
    private String storeId;
    @JsonProperty("storeOperatorId")
    private String storeOperatorId;
    @JsonProperty("storeOperatorUrl")
    private String storeOperatorUrl;
    @JsonProperty("zipcode")
    private String zipcode;
    @JsonProperty("country")
    private String country;
    @JsonProperty("city")
    private String city;
    @JsonProperty("citydistrict")
    private String citydistrict;
    @JsonProperty("street")
    private String street;
    @JsonProperty("housenumber")
    private String housenumber;
    @JsonProperty("x")
    private Double x;
    @JsonProperty("y")
    private Double y;
    @JsonProperty("oh")
    private String oh;
    @JsonProperty("warehouseKey")
    private String warehouseKey;
    @JsonProperty("positionId")
    private String positionId;
    @JsonProperty("nf")
    private Boolean nf;
    @JsonProperty("hasBakeshop")
    private Boolean hasBakeshop;
    @JsonProperty("hasDisabledParking")
    private Boolean hasDisabledParking;
    @JsonProperty("hasPackingStation")
    private Boolean hasPackingStation;
    @JsonProperty("hasParking")
    private Boolean hasParking;
    @JsonProperty("taxFreeShoppingIsPossible")
    private Boolean taxFreeShoppingIsPossible;
    @JsonProperty("hasHotDrinks")
    private Boolean hasHotDrinks;
    @JsonProperty("hasECharger")
    private Boolean hasECharger;
    @JsonProperty("lidlPlus")
    private Boolean lidlPlus;
    @JsonProperty("hasClickAndCollect")
    private Boolean hasClickAndCollect;
    @JsonProperty("dataPath")
    private String dataPath;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("storeId")
    public String getStoreId() {
        return storeId;
    }

    @JsonProperty("storeId")
    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    @JsonProperty("storeOperatorId")
    public String getStoreOperatorId() {
        return storeOperatorId;
    }

    @JsonProperty("storeOperatorId")
    public void setStoreOperatorId(String storeOperatorId) {
        this.storeOperatorId = storeOperatorId;
    }

    @JsonProperty("storeOperatorUrl")
    public String getStoreOperatorUrl() {
        return storeOperatorUrl;
    }

    @JsonProperty("storeOperatorUrl")
    public void setStoreOperatorUrl(String storeOperatorUrl) {
        this.storeOperatorUrl = storeOperatorUrl;
    }

    @JsonProperty("zipcode")
    public String getZipcode() {
        return zipcode;
    }

    @JsonProperty("zipcode")
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("citydistrict")
    public String getCitydistrict() {
        return citydistrict;
    }

    @JsonProperty("citydistrict")
    public void setCitydistrict(String citydistrict) {
        this.citydistrict = citydistrict;
    }

    @JsonProperty("street")
    public String getStreet() {
        return street;
    }

    @JsonProperty("street")
    public void setStreet(String street) {
        this.street = street;
    }

    @JsonProperty("housenumber")
    public String getHousenumber() {
        return housenumber;
    }

    @JsonProperty("housenumber")
    public void setHousenumber(String housenumber) {
        this.housenumber = housenumber;
    }

    @JsonProperty("x")
    public Double getLongitude() {
        return x;
    }

    @JsonProperty("x")
    public void setLongitude(Double x) {
        this.x = x;
    }

    @JsonProperty("y")
    public Double getLatitude() {
        return y;
    }

    @JsonProperty("y")
    public void setLatitude(Double y) {
        this.y = y;
    }

    @JsonProperty("oh")
    public String getOpeningHours() {
        return oh;
    }

    @JsonProperty("oh")
    public void setOpeningHours(String oh) {
        this.oh = oh;
    }

    @JsonProperty("warehouseKey")
    public String getWarehouseKey() {
        return warehouseKey;
    }

    @JsonProperty("warehouseKey")
    public void setWarehouseKey(String warehouseKey) {
        this.warehouseKey = warehouseKey;
    }

    @JsonProperty("positionId")
    public String getPositionId() {
        return positionId;
    }

    @JsonProperty("positionId")
    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }

    @JsonProperty("nf")
    public Boolean getNf() {
        return nf;
    }

    @JsonProperty("nf")
    public void setNf(Boolean nf) {
        this.nf = nf;
    }

    @JsonProperty("hasBakeshop")
    public Boolean getHasBakeshop() {
        return hasBakeshop;
    }

    @JsonProperty("hasBakeshop")
    public void setHasBakeshop(Boolean hasBakeshop) {
        this.hasBakeshop = hasBakeshop;
    }

    @JsonProperty("hasDisabledParking")
    public Boolean getHasDisabledParking() {
        return hasDisabledParking;
    }

    @JsonProperty("hasDisabledParking")
    public void setHasDisabledParking(Boolean hasDisabledParking) {
        this.hasDisabledParking = hasDisabledParking;
    }

    @JsonProperty("hasPackingStation")
    public Boolean getHasPackingStation() {
        return hasPackingStation;
    }

    @JsonProperty("hasPackingStation")
    public void setHasPackingStation(Boolean hasPackingStation) {
        this.hasPackingStation = hasPackingStation;
    }

    @JsonProperty("hasParking")
    public Boolean getHasParking() {
        return hasParking;
    }

    @JsonProperty("hasParking")
    public void setHasParking(Boolean hasParking) {
        this.hasParking = hasParking;
    }

    @JsonProperty("taxFreeShoppingIsPossible")
    public Boolean getTaxFreeShoppingIsPossible() {
        return taxFreeShoppingIsPossible;
    }

    @JsonProperty("taxFreeShoppingIsPossible")
    public void setTaxFreeShoppingIsPossible(Boolean taxFreeShoppingIsPossible) {
        this.taxFreeShoppingIsPossible = taxFreeShoppingIsPossible;
    }

    @JsonProperty("hasHotDrinks")
    public Boolean getHasHotDrinks() {
        return hasHotDrinks;
    }

    @JsonProperty("hasHotDrinks")
    public void setHasHotDrinks(Boolean hasHotDrinks) {
        this.hasHotDrinks = hasHotDrinks;
    }

    @JsonProperty("hasECharger")
    public Boolean getHasECharger() {
        return hasECharger;
    }

    @JsonProperty("hasECharger")
    public void setHasECharger(Boolean hasECharger) {
        this.hasECharger = hasECharger;
    }

    @JsonProperty("lidlPlus")
    public Boolean getLidlPlus() {
        return lidlPlus;
    }

    @JsonProperty("lidlPlus")
    public void setLidlPlus(Boolean lidlPlus) {
        this.lidlPlus = lidlPlus;
    }

    @JsonProperty("hasClickAndCollect")
    public Boolean getHasClickAndCollect() {
        return hasClickAndCollect;
    }

    @JsonProperty("hasClickAndCollect")
    public void setHasClickAndCollect(Boolean hasClickAndCollect) {
        this.hasClickAndCollect = hasClickAndCollect;
    }

    @JsonProperty("dataPath")
    public String getDataPath() {
        return dataPath;
    }

    @JsonProperty("dataPath")
    public void setDataPath(String dataPath) {
        this.dataPath = dataPath;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
