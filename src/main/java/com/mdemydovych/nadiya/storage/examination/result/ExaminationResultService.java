package com.mdemydovych.nadiya.storage.examination.result;

import com.mdemydovych.nadiya.model.examination.result.ExaminationResultDto;
import com.mdemydovych.nadiya.storage.examination.result.domain.ExaminationResult;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExaminationResultService {

  private final ExaminationResultRepository repository;

  private final ExaminationResultMapper mapper;


  public void save(ExaminationResultDto resultDto) {
    ExaminationResult toSave = mapper.toEntity(resultDto);
    repository.save(toSave);
  }

  public ExaminationResultDto findStudentExamResult(String studentId, String examId) {
    return repository.findByStudentIdAndExaminationId(studentId, examId)
        .map(mapper::toDto)
        .orElse(null);
  }

  public List<ExaminationResultDto> findAllStudentExamResults(String studentId) {
    return repository.findAllByStudentId(studentId)
        .stream()
        .map(mapper::toDto)
        .toList();
  }

  public List<ExaminationResultDto> findAllExaminationResults(String examId) {
    return repository.findAllByExamination_Id(examId)
        .stream()
        .map(mapper::toDto)
        .toList();
  }
}
