package com.sit.cov.hackatron.backend.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.http.MediaType;

import com.sit.cov.hackatron.backend.model.Store;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class StoreService {

    private final WebClient webClient;
    //TODO Create configuration Files
    public static final String STORE_SEARCH_ENDPOINT = "https://mobile.lidl.de/Mobile-Server/service/1337/StoreSearch/nearestStore/DE/";

    public ResponseEntity<Store> getStores(String longitude, String latitude) {
        return ResponseEntity.ok().body(webClient.get().uri(buildURI(longitude,latitude)).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(Store.class)
        .block());
    }

    private String buildURI(String longitude, String latitude){
        return STORE_SEARCH_ENDPOINT + "/" + longitude + "/" + latitude + "/";
    }
}