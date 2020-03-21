package com.sit.cov.hackatron.backend.controller;

import com.sit.cov.hackatron.backend.model.TimeSlot;
import com.sit.cov.hackatron.backend.repository.TimeslotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TimeSlotController {

    @Autowired
    private TimeslotRepository timeslotRepository;


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

    @PostMapping(value = "/timeslot/reserve/{id}")
    public TimeSlot reserveTimeslot(@PathVariable String id) {
        TimeSlot timeslot;
        Optional<TimeSlot> ret = timeslotRepository.findById(id);
        if (ret.isPresent()) {
            timeslot = ret.get();
            timeslot.reserved = true;
            return timeslotRepository.save(timeslot);
        } else {
            return null;
        }
    }
}
