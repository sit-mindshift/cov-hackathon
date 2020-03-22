package com.sit.cov.hackatron.backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@AllArgsConstructor
@Builder
@EqualsAndHashCode(exclude = {"id", "timeSlot"})
@Document(collection = "reservedTimeslot")
public class ReservedTimeSlotItem {
    @Id
    private String id;
    private String userID;
    private String storeID;
    private TimeSlot timeSlot;
}
