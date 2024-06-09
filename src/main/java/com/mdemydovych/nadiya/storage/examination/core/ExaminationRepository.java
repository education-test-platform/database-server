package com.mdemydovych.nadiya.storage.examination.core;

import com.mdemydovych.nadiya.storage.examination.core.domain.Examination;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ExaminationRepository extends JpaRepository<Examination, String> {

  List<Examination> findByTeacher_Id(String teacherId);

  @Query(
      "SELECT a FROM examinations a WHERE a.id NOT IN (SELECT b.examination.id FROM examination_results b where b.student.id = :studentId)"
          + "AND exists (SELECT 1 FROM assigments c WHERE c.id.studentId = :studentId AND c.id.teacherId = a.teacher.id) AND a.opened = true")
  List<Examination> findActiveStudentExams(String studentId);
}
