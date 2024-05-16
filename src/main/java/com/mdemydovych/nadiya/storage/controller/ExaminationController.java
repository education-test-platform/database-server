package com.mdemydovych.nadiya.storage.controller;

import com.mdemydovych.nadiya.model.examination.core.ExaminationDto;
import com.mdemydovych.nadiya.storage.examination.core.ExaminationService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/examination")
public class ExaminationController {

  private final ExaminationService examinationService;

  @PostMapping("/save")
  public String save(@RequestBody ExaminationDto dto) {
    return examinationService.save(dto);
  }

  @GetMapping("/find/{id}")
  public ExaminationDto findById(@PathVariable String id) {
    return examinationService.findById(id);
  }

  @GetMapping("/find/teacher/{id}")
  public List<ExaminationDto> findByTeacherId(@PathVariable String id) {
    return examinationService.findByTeacher(id);
  }
}
