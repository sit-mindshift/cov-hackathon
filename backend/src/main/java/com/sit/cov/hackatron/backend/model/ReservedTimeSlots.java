package com.sit.cov.hackatron.backend.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "timeslot")
public class ReservedTimeSlots {
    @Id
    private String userId;
    private List<TimeSlot> timeSlots;
    private List<TimeSlot> invalidTimeSlots = new ArrayList<>();

    public ReservedTimeSlots(String userId, List<TimeSlot> timeSlots) {
        this.userId = userId;
        this.timeSlots = timeSlots;
    }
}
