package com.sit.cov.hackatron.backend.resource;

import com.sit.cov.hackatron.backend.model.Store;
import com.sit.cov.hackatron.backend.model.StoreList;
import com.sit.cov.hackatron.backend.service.StoreService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(StoreResource.STORE_ENDPOINT)
public class StoreResource {

    public static final String STORE_ENDPOINT = "/store-api/";
    private final StoreService storeService;

    @GetMapping(value="/nearestStore")
    @ResponseBody
    public ResponseEntity<Store> getNearestStore(@RequestParam("longitude") String longitude,
            @RequestParam("latitude") String latitude) {
        return storeService.getNearestStore(longitude, latitude);
    }

    @GetMapping(value="/stores")
    @ResponseBody
    public ResponseEntity<StoreList> getStores(@RequestParam("longitude") String longitude,
            @RequestParam("latitude") String latitude, @RequestParam String span) {
        return storeService.getStores(longitude, latitude, span);
    }
}