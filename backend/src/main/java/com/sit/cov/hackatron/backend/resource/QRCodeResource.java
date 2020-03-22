package com.sit.cov.hackatron.backend.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.MediaType;
import reactor.core.publisher.Mono;

import com.sit.cov.hackatron.backend.service.QRCodeGeneratorService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class QRCodeResource {

    public static final String QR_ENDPOINT = "/qr-api/";
    private final QRCodeGeneratorService qrCodeGeneratorService;

    @GetMapping(value = QR_ENDPOINT, produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseBody
    public Mono<ResponseEntity<String>> getQRCode(@RequestParam(value = "value", required = true) String value) {
        return qrCodeGeneratorService.generateQRCode(value, 256, 256)
                .map(imageBuff -> ResponseEntity.ok().body(imageBuff));
    }
}