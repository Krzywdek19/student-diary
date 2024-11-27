package com.krzywdek19.student_diary.common;

import jakarta.persistence.Embeddable;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@Embeddable
@NoArgsConstructor
@EqualsAndHashCode
public class Address {
    private String city;
    private String street;
    private int buildingNumber;
}
