package com.sit.cov.hackatron.backend.resource;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Iterables;
import com.sit.cov.hackatron.backend.model.DBStore;
import com.sit.cov.hackatron.backend.repository.StoreRepository;
import com.sit.cov.hackatron.backend.resource.exception.StoreImportException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping(StoreImportResource.STORE_IMPORT_BASE_URL)
@Slf4j
@RequiredArgsConstructor
public class StoreImportResource {

    public static final String STORE_IMPORT_BASE_URL = "/store-import";

    private final StoreRepository storeRepository;

    private static final int TRANSACTION_BATCH_SIZE = 100;

    @RequestMapping("/do-import")
    public ResponseEntity doImport() {

        log.info("Starting store import.");

        if (!storeRepository.findAll().isEmpty()) {
            log.error("Cannot import stores from local file. There are already some stores in the database.");
            throw new StoreImportException("Cannot import stores from local file. There are already some stores in the database.");
        }

        try {
            InputStream input = new ClassPathResource("stores.json").getInputStream();

            var mapper = new ObjectMapper();

            List<DBStore> DBStores = mapper.readValue(input, new TypeReference<List<DBStore>>() {
            });

            log.info("Read {} stores from local file.", DBStores.size());

            Iterables.partition(DBStores, TRANSACTION_BATCH_SIZE).forEach(storeRepository::saveAll);

        } catch (Exception e) {
            log.error("Something went wrong...", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }

        log.info("Store import successful.");

        return ResponseEntity.ok("Imported " + storeRepository.findAll().size() + " stores from local file.");
    }

    @GetMapping("delete-stores")
    public ResponseEntity<HttpStatus> deleteAllSavedStores() {

        log.info("Deleting all stores.");

        storeRepository.deleteAll();

        log.info("All stores have been deleted.");

        return ResponseEntity.ok().build();
    }
}
