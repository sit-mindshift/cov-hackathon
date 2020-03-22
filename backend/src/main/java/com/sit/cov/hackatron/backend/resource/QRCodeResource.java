package com.sit.cov.hackatron.backend.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.MediaType;
import reactor.core.publisher.Mono;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sit.cov.hackatron.backend.model.ReservedTimeSlots;
import com.sit.cov.hackatron.backend.service.QRCodeGeneratorService;
import com.sit.cov.hackatron.backend.repository.ReservedTimeslotsRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class QRCodeResource {

    public static final String QR_ENDPOINT = "/qr-api/";
    private final QRCodeGeneratorService qrCodeGeneratorService;
    private final ReservedTimeslotsRepository reservedTimeslotsRepository;

    @PostMapping(value = QR_ENDPOINT, produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseBody
    public Mono<ResponseEntity<String>> getQRCode(@RequestBody final String timeSlot) {
        return qrCodeGeneratorService.generateQRCode(timeSlot, 256, 256)
                .map(imageBuff -> ResponseEntity.ok().body(imageBuff));
    }

    @GetMapping(value = QR_ENDPOINT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String[]> getQRCodeForUser(@RequestParam final String userId) throws JsonProcessingException {

        final Optional<ReservedTimeSlots> reservedTimeSlots = reservedTimeslotsRepository.findById(userId);
        final List<String> qrCodes = new ArrayList<String>();
        if(reservedTimeSlots.isPresent()){
        reservedTimeSlots.get().getTimeSlots().forEach(timeslot -> {
            final ObjectMapper mapper = new ObjectMapper();
            try {
                // should include more then just timeslot
                String timeSlotJson = mapper.writeValueAsString(timeslot);
                qrCodes.add(qrCodeGeneratorService.generateQRCode(timeSlotJson, 256, 256).block());
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        });
        }
        return ResponseEntity.ok().body(qrCodes.stream().map(String::new).toArray(String[]::new));
    }
}