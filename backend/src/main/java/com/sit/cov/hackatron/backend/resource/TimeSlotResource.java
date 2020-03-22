package com.sit.cov.hackatron.backend.resource;

import com.sit.cov.hackatron.backend.model.ReservedTimeSlotItem;
import com.sit.cov.hackatron.backend.model.ReservedTimeSlots;
import com.sit.cov.hackatron.backend.model.TimeSlot;
import com.sit.cov.hackatron.backend.repository.ReservedTimeslotsRepository;
import com.sit.cov.hackatron.backend.repository.TimeslotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
@RequiredArgsConstructor
public class TimeSlotResource {

    private final TimeslotRepository timeslotRepository;

    private final ReservedTimeslotsRepository reservedTimeslotsRepository;

    @GetMapping(value = "/timeslots")
    public List<TimeSlot> getAllTimeslots() {
        return timeslotRepository.findAll();
    }

    @GetMapping(value = "/timeslots/{id}")
    public List<TimeSlot> getAllTimeslotsOfStore() {
        // TODO query slots from store
        return timeslotRepository.findAll();
    }

    @PostMapping(value = "/timeslot")
    public TimeSlot saveTimeslot(@RequestBody TimeSlot timeslot) {
        return timeslotRepository.save(timeslot);
    }

    @PostMapping(value = "/timeslots")
    public List<TimeSlot> saveAllTimeslots(@RequestBody List<TimeSlot> timeslots) {
        return timeslotRepository.saveAll(timeslots);
    }

    @GetMapping(value = "/timeslot/{userID}")
    public ResponseEntity<ReservedTimeSlots> getTimeslotsForUser(@PathVariable String userID) {
        if (reservedTimeslotsRepository.findById(userID).isPresent()) {
            return ResponseEntity.ok().body(reservedTimeslotsRepository.findById(userID).get());
        } else {
            return ResponseEntity.ok().body(new ReservedTimeSlots());
        }
    }

    @PostMapping(value = "/timeslot/invalidate/{userID}/{timeSlotID}")
    public ReservedTimeSlots invalidateTimeslot(@PathVariable String userID, @PathVariable String timeSlotID) {

        Optional<ReservedTimeSlots> reservedTimeSlotsOptional = reservedTimeslotsRepository.findById(userID);

        if (reservedTimeSlotsOptional.isPresent() && reservedTimeSlotsOptional.get().getTimeSlots() != null) {
            reservedTimeSlotsOptional.get().getTimeSlots().forEach(timeslot -> {
                if (timeslot.getTimeSlot().getId().equals(timeSlotID)) {
                    reservedTimeSlotsOptional.get().getInvalidTimeSlots().add(timeslot);
                }
            });

            List<ReservedTimeSlotItem> timeSlots = reservedTimeSlotsOptional.get().getTimeSlots().stream()
                    .filter(timeslot -> !timeSlotID.equals(timeslot.getTimeSlot().getId()))
                    .collect(Collectors.toList());
            reservedTimeSlotsOptional.get().setTimeSlots(timeSlots);

            return reservedTimeslotsRepository.save(reservedTimeSlotsOptional.get());
        } else {
            return null;
        }
    }

    @PostMapping(value = "/timeslot/reserve/{userID}/{storeID}/{timeSlotID}")
    public ReservedTimeSlots reserveTimeslot(@PathVariable String userID, @PathVariable String storeID,
            @PathVariable String timeSlotID) {

        Optional<TimeSlot> timeSlot = timeslotRepository.findById(timeSlotID);

        if (timeSlot.isPresent()) {
            ReservedTimeSlotItem reservedTimeSlot = ReservedTimeSlotItem.builder().storeID(storeID).userID(userID)
                    .timeSlot(timeSlot.get()).build();
            return buiReservedTimeSlots(userID, reservedTimeSlot);
        } else {
            return null;
        }
    }

    private ReservedTimeSlots buiReservedTimeSlots(String userID, ReservedTimeSlotItem reservedTimeSlot) {
        Optional<ReservedTimeSlots> reservedTimeSlotsOptional = reservedTimeslotsRepository.findById(userID);
        if (reservedTimeSlotsOptional.isPresent()) {
            if (!reservedTimeSlotsOptional.get().getTimeSlots().contains(reservedTimeSlot)) {
                reservedTimeSlotsOptional.get().getTimeSlots().add(reservedTimeSlot);
                return reservedTimeslotsRepository.save(reservedTimeSlotsOptional.get());
            } else {
                return null;
            }
        } else {
            List<ReservedTimeSlotItem> timeSlots = new ArrayList<ReservedTimeSlotItem>();
            timeSlots.add(reservedTimeSlot);
            ReservedTimeSlots reservedTimeSlots = new ReservedTimeSlots(userID, timeSlots, timeSlots);
            return reservedTimeslotsRepository.save(reservedTimeSlots);
        }
    }
}
