package com.sit.cov.hackatron.backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
@EqualsAndHashCode(exclude = {"id"})
@Document(collection = "timeslot")
public class TimeSlot {
    @Id
    private String id;
    public LocalDate date;
    public LocalTime from;
    public LocalTime til;
}
