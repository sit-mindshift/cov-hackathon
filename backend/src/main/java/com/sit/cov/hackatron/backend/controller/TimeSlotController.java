package com.sit.cov.hackatron.backend.controller;

import com.sit.cov.hackatron.backend.model.ReservedTimeSlots;
import com.sit.cov.hackatron.backend.model.TimeSlot;
import com.sit.cov.hackatron.backend.repository.ReservedTimeslotRepository;
import com.sit.cov.hackatron.backend.repository.TimeslotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class TimeSlotController {

    @Autowired
    private TimeslotRepository timeslotRepository;

    @Autowired
    private ReservedTimeslotRepository reservedTimeslotRepository;

    @GetMapping(value = "/timeslots")
    public List<TimeSlot> getAllTimeslots() {
        List<TimeSlot> timeSlots = timeslotRepository.findAll();
        return timeSlots;
    }

    @GetMapping(value = "/timeslot/{id}")
    public Optional<TimeSlot> findTimeSlotById(@PathVariable String id) {

        Optional<TimeSlot> timeslot = timeslotRepository.findById(id);
        return timeslot;
    }

    @PostMapping(value = "/timeslot")
    public TimeSlot saveTimeslot(@RequestBody TimeSlot timeslot) {

        TimeSlot savedTimeSlot = timeslotRepository.save(timeslot);
        return savedTimeSlot;
    }

    @PostMapping(value = "/timeslot/invalidate/{userID}/{timeSlotID}")
    public ReservedTimeSlots invalidateTimeslot(@PathVariable String userID, @PathVariable String timeSlotID) {

        Optional<ReservedTimeSlots> reservedTimeSlotsOptional = reservedTimeslotRepository.findById(userID);

        if (reservedTimeSlotsOptional.isPresent() && reservedTimeSlotsOptional.get().getTimeSlots() != null) {
            reservedTimeSlotsOptional.get().getTimeSlots().stream().forEach(timeslot -> {
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
