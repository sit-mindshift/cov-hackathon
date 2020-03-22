package com.sit.cov.hackatron.backend.service;

import com.sit.cov.hackatron.backend.model.Store;
import com.sit.cov.hackatron.backend.model.StoreList;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.apache.commons.lang.StringUtils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class StoreService {

    private final WebClient webClient;
    // TODO Create configuration Files
    public static final String STORE_SEARCH_ENDPOINT = "https://mobile.lidl.de/Mobile-Server/service/1337/StoreSearch/nearestStore/DE/";
    public static final String STORES_SEARCH_ENDPOINT = "https://mobile.lidl.de/Mobile-Server/service/1337/StoreSearch/DE/";

    public ResponseEntity<Store> getNearestStore(String latitude, String longitude) {
        return ResponseEntity.ok().body(webClient.get().uri(buildURI(latitude, longitude))
                .accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(Store.class).block());
    }

    private String buildURI(String latitude, String longitude) {
        return STORE_SEARCH_ENDPOINT + "/" + latitude + "/" + longitude + "/";
    }

    public ResponseEntity<StoreList> getStores(String latitude, String longitude, String span) {

        // Fill up to needed length
        if (latitude.length() < 8) {
            latitude = StringUtils.rightPad(latitude, 8, "0");
        }

        // Fill up to needed length
        if (longitude.length() <= (5 + longitude.indexOf("."))) {
            longitude = StringUtils.rightPad(longitude, 6 + longitude.indexOf("."), "0");
        }

        // Trim down to needed length
        latitude = latitude.replace(".", "").substring(0, Math.min(latitude.length(), 7));
        longitude = longitude.replace(".", "").substring(0, Math.min(longitude.length(), 5 + longitude.indexOf(".")));


        return ResponseEntity.ok().body(webClient.get().uri(buildStoresURI(latitude, longitude, span))
                .accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(StoreList.class).block());
    }

    private String buildStoresURI(String latitude, String longitude, String span) {
        return STORES_SEARCH_ENDPOINT + "/" + latitude + "/" + span + "/" + longitude + "/" + span;
    }
}
