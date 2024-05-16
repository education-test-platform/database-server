package com.mdemydovych.nadiya.storage.examination.result;


import com.mdemydovych.nadiya.storage.examination.result.domain.ExaminationResult;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

interface ExaminationResultRepository extends JpaRepository<ExaminationResult, UUID> {

  Optional<ExaminationResult> findByStudentIdAndExaminationId(
      String studentId, String examinationId);
}
