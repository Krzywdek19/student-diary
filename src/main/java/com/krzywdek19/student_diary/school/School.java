package com.krzywdek19.student_diary.school;

import com.krzywdek19.student_diary.common.Address;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "school")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class School {
    @GeneratedValue
    @Id
    private Long id;
    private String name;
    private Address address;
    private SchoolType schoolType;
    private int studentCount;
    private int classCount;
}
