package com.krzywdek19.student_diary.school;

import com.krzywdek19.student_diary.common.Address;
import com.krzywdek19.student_diary.school.schoolClass.SchoolClass;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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
    @Embedded
    private Address address;
    private SchoolType schoolType;
    @OneToMany(mappedBy = "school", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<SchoolClass> schoolClasses = new ArrayList<>();
    private int studentCount;
    private int classCount;

    public void addSchoolClass(SchoolClass schoolClass){
        schoolClasses.add(schoolClass);
        schoolClass.setSchool(this);
    }
}
