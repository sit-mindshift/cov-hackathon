package com.sit.cov.hackatron.backend.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sit.cov.hackatron.backend.model.Coordinates;
import com.sit.cov.hackatron.backend.service.StoreService;
import com.sit.cov.hackatron.backend.model.Store;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(StoreResource.STORE_ENDPOINT)
public class StoreResource {

    public static final String STORE_ENDPOINT = "/store-api/";
    private final StoreService storeService;

    //TODO Use nicer models, create real Reponse Object
    @GetMapping
    @ResponseBody
    public ResponseEntity<Store> getStores(@RequestBody Coordinates coordinates) {
        return storeService.getStores(coordinates.getLongitude(), coordinates.getLatitude());
    }
}