package com.krzywdek19.student_diary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SomeDataRepository extends JpaRepository<SomeData, Long> {
}
