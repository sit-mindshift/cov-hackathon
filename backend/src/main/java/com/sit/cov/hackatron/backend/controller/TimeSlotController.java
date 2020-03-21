package com.sit.cov.hackatron.backend.controller;

import com.sit.cov.hackatron.backend.model.Timeslot;
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
    public List<Timeslot> getAllTimeslots() {

        List<Timeslot> timeslots = timeslotRepository.findAll();
        return timeslots;
    }


    @GetMapping(value = "/timeslot/{id}")
    public Optional<Timeslot> findTimeSlotById(@PathVariable String id) {

        Optional<Timeslot> timeslot = timeslotRepository.findById(id);
        return timeslot;
    }

    @PostMapping(value = "/timeslot")
    public Timeslot saveTimeslot(@RequestBody Timeslot timeslot) {

        Timeslot savedTimeslot = timeslotRepository.save(timeslot);
        return savedTimeslot;
    }

    @PostMapping(value = "/timeslot/{id}")
    public Timeslot submitTimeslot(@PathVariable String id) {
        Timeslot timeslot;
        Optional<Timeslot> ret = timeslotRepository.findById(id);
        if (ret.isPresent()) {
            timeslot = ret.get();
            timeslot.reserved = true;
            return timeslotRepository.save(timeslot);
        } else {
            return new Timeslot();
        }
    }
}
