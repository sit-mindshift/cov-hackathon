package com.sit.cov.hackatron.backend.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Document(collection = "timeslot")
public class ReservedTimeSlots {
    @Id
    private String userId;
    private List<TimeSlot> timeSlots;
    private List<TimeSlot> invalidTimeslSlots;

    public ReservedTimeSlots(String userId, List<TimeSlot> timeSlots) {
        this.userId = userId;
        this.timeSlots = timeSlots;
    }
}
