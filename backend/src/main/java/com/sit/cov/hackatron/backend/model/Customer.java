package com.sit.cov.hackatron.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@Document(collection = "customer")
public class Customer {
    @Id
    private String id;

    private String firstName;
    private String lastName;
    private String email;

    @CreatedDate
    private Date createdOn;

    @LastModifiedDate
    private Date updatedOn;

}
