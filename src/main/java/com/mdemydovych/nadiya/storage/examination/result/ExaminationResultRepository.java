package com.mdemydovych.nadiya.storage.examination.result;


import com.mdemydovych.nadiya.storage.examination.result.domain.ExaminationResult;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

interface ExaminationResultRepository extends JpaRepository<ExaminationResult, String> {

  Optional<ExaminationResult> findByStudentIdAndExaminationId(
      String studentId, String examinationId);

  List<ExaminationResult> findAllByStudentId(String studentId);

  List<ExaminationResult> findAllByExamination_Id(String examinationId);
}
