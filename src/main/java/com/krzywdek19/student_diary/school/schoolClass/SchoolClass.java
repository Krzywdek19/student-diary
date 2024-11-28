package com.krzywdek19.student_diary.school.schoolClass;

import com.krzywdek19.student_diary.school.School;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SchoolClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int classGrade;
    private char classSign;
    @ManyToOne
    private School school;
}
