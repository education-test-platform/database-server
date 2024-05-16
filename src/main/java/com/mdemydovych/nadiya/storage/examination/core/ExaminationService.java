package com.mdemydovych.nadiya.storage.examination.core;

import com.mdemydovych.nadiya.model.examination.core.ExaminationDto;
import com.mdemydovych.nadiya.storage.examination.core.domain.Examination;
import com.mdemydovych.nadiya.storage.examination.core.exception.ExaminationNotFoundException;
import com.mdemydovych.nadiya.storage.examination.core.mapper.ExaminationMapper;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExaminationService {

  private final ExaminationRepository repository;

  private final ExaminationMapper mapper;

  public String save(ExaminationDto examinationDto) {
    Examination toSave = mapper.toEntity(examinationDto);
    Examination saved = repository.save(toSave);
    return saved.getId().toString();
  }

  public List<ExaminationDto> findByTeacher(String teacherId) {
    return repository.findByTeacherId(teacherId)
        .stream()
        .map(mapper::toDto)
        .toList();
  }

  public ExaminationDto findById(String id) {
    return repository.findById(UUID.fromString(id))
        .map(mapper::toDto)
        .orElseThrow(() -> new ExaminationNotFoundException("Examination not found"));
  }
}
