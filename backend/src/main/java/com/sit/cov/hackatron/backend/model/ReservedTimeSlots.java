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
@Document(collection = "reservedTimeSlots")
public class ReservedTimeSlots {
    @Id
    private String userId;
    private List<ReservedTimeSlotItem> timeSlots;
    private List<ReservedTimeSlotItem> invalidTimeSlots = new ArrayList<>();
}
