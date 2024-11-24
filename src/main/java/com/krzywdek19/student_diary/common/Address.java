package com.krzywdek19.student_diary.common;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Embeddable
@NoArgsConstructor
public class Address {
    private String city;
    private String street;
    private int buildingNumber;
}
