package com.sit.cov.hackatron.backend.resource;

import com.sit.cov.hackatron.backend.model.ReservedTimeSlots;
import com.sit.cov.hackatron.backend.model.TimeSlot;
import com.sit.cov.hackatron.backend.repository.ReservedTimeslotRepository;
import com.sit.cov.hackatron.backend.repository.TimeslotRepository;
import com.sit.cov.hackatron.backend.resource.util.ResponseUtil;
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

    private final ReservedTimeslotRepository reservedTimeslotRepository;

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

    @GetMapping(value = "/timeslot/{userID}")
    public ResponseEntity<ReservedTimeSlots> getTimeslotsForUser(@PathVariable String userID) {
        if (reservedTimeslotRepository.findById(userID).isPresent()) {
            return ResponseEntity.ok().body(reservedTimeslotRepository.findById(userID).get());
        } else {
            return ResponseEntity.ok().body(new ReservedTimeSlots());
        }
    }

    @PostMapping(value = "/timeslot/invalidate/{userID}/{timeSlotID}")
    public ReservedTimeSlots invalidateTimeslot(@PathVariable String userID, @PathVariable String timeSlotID) {

        Optional<ReservedTimeSlots> reservedTimeSlotsOptional = reservedTimeslotRepository.findById(userID);

        if (reservedTimeSlotsOptional.isPresent() && reservedTimeSlotsOptional.get().getTimeSlots() != null) {
            reservedTimeSlotsOptional.get().getTimeSlots().forEach(timeslot -> {
                if (timeslot.getId().equals(timeSlotID)) {
                    reservedTimeSlotsOptional.get().getInvalidTimeSlots().add(timeslot);
                }
            });

            List<TimeSlot> timeSlots = reservedTimeSlotsOptional.get().getTimeSlots().stream()
                    .filter(timeslot -> !timeSlotID.equals(timeslot.getId())).collect(Collectors.toList());
            reservedTimeSlotsOptional.get().setTimeSlots(timeSlots);

            return reservedTimeslotRepository.save(reservedTimeSlotsOptional.get());
        } else {
            return null;
        }
    }

    @PostMapping(value = "/timeslot/reserve/{userID}/{timeSlotID}")
    public ReservedTimeSlots reserveTimeslot(@PathVariable String userID, @PathVariable String timeSlotID) {

        Optional<TimeSlot> timeSlot = timeslotRepository.findById(timeSlotID);

        if (timeSlot.isPresent()) {
            Optional<ReservedTimeSlots> reservedTimeSlotsOptional = reservedTimeslotRepository.findById(userID);
            if (reservedTimeSlotsOptional.isPresent()) {
                // TODO check if user already has the timeslot assigned to prevent adding it twice
                reservedTimeSlotsOptional.get().getTimeSlots().add(timeSlot.get());
                return reservedTimeslotRepository.save(reservedTimeSlotsOptional.get());
            } else {
                List<TimeSlot> timeSlots = new ArrayList<TimeSlot>();
                timeSlots.add(timeSlot.get());
                ReservedTimeSlots reservedTimeSlots = new ReservedTimeSlots(userID, timeSlots);
                return reservedTimeslotRepository.save(reservedTimeSlots);
            }
        } else {
            return null;
        }
    }
}
