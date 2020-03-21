package com.sit.cov.hackatron.backend.service;

import com.sit.cov.hackatron.backend.model.Store;
import com.sit.cov.hackatron.backend.model.StoreList;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

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

    public ResponseEntity<Store> getNearestStore(String longitude, String latitude) {
        return ResponseEntity.ok().body(webClient.get().uri(buildURI(longitude, latitude))
                .accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(Store.class).block());
    }

    private String buildURI(String longitude, String latitude) {
        return STORE_SEARCH_ENDPOINT + "/" + longitude + "/" + latitude + "/";
    }

    public ResponseEntity<StoreList> getStores(String longitude, String latitude, String span) {
        return ResponseEntity.ok().body(webClient.get().uri(buildStoresURI(longitude, latitude, span))
                .accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(StoreList.class).block());
    }

    private String buildStoresURI(String longitude, String latitude, String span) {
        return STORES_SEARCH_ENDPOINT + "/" + longitude + "/" + span + "/" + latitude + "/" + span;
    }
}