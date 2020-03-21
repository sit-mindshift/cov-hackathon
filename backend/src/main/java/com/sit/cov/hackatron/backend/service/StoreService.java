package com.sit.cov.hackatron.backend.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;

import com.sit.cov.hackatron.backend.model.Store;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(StoreService.STORE_SEARCH_ENDPOINT)
public class StoreService {

    private final WebClient webClient;
    //TODO Create configuration Files
    public static final String STORE_SEARCH_ENDPOINT = "https://mobile.lidl.de/Mobile-Server/service/1337/StoreSearch/nearestStore/DE/";
    public static final String STORES_SEARCH_ENDPOINT = "https://mobile.lidl.de/Mobile-Server/service/1337/StoreSearch/DE/";

    public ResponseEntity<Store> getStores(String longitude, String latitude) {
        return ResponseEntity.ok().body(webClient.get().uri(buildStoresURI(longitude,latitude)).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(Store.class)
        .block());
    }

    /**
     * Example: https://mobile.lidl.de/Mobile-Server/service/1337/StoreSearch/DE/4912851/50000/925886/50000
     * @param longitude the longitude. Example: 4912851
     * @param latitude the latitude. Example: 925886
     * @param span the size of the map you search on. Example 50000
     * @return
     */
    public ResponseEntity<Store> getStores(String longitude, String latitude,String span) {
        return ResponseEntity.ok().body(webClient.get().uri(buildStoresURI(longitude,latitude)).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(Store.class)
                .block());
    }

    private String buildStoresURI(String longitude, String latitude){
        return STORE_SEARCH_ENDPOINT + "/" + longitude + "/" + latitude + "/";
    }

    private String buildStoresURI(String longitude, String latitude, String span){
        return STORES_SEARCH_ENDPOINT + "/" + longitude + "/" + span + "/" + latitude + "/" + span;
    }
}