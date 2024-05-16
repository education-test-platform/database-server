package com.mdemydovych.nadiya.storage.controller;

import com.mdemydovych.nadiya.model.examination.result.ExaminationResultDto;
import com.mdemydovych.nadiya.storage.examination.result.ExaminationResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/examination/result")
public class ExaminationResultController {

  private final ExaminationResultService examinationResultService;

  @PostMapping("/save")
  public void save(ExaminationResultDto examinationResultDto) {
    examinationResultService.save(examinationResultDto);
  }

  @GetMapping("/find/{studentId}/{examId}")
  public ExaminationResultDto findExamResult(
      @PathVariable String examId, @PathVariable String studentId) {
    return examinationResultService.findStudentExamResult(studentId, examId);
  }
}
