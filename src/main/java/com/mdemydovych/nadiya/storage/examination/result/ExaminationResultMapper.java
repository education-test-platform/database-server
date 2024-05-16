package com.mdemydovych.nadiya.storage.examination.result;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mdemydovych.nadiya.model.examination.result.AnswerDto;
import com.mdemydovych.nadiya.model.examination.result.ExaminationResultDto;
import com.mdemydovych.nadiya.storage.examination.result.domain.ExaminationResult;
import com.mdemydovych.nadiya.storage.utils.ZipUtils;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

@Component
class ExaminationResultMapper {

  private final ObjectMapper objectMapper = new ObjectMapper();

  @SneakyThrows
  public ExaminationResult toEntity(ExaminationResultDto dto) {
    ExaminationResult result = new ExaminationResult();
    result.setExaminationId(dto.getExaminationId());
    result.setId(Objects.nonNull(dto.getId()) ? UUID.fromString(dto.getId()) : null);
    result.setAnswers(ZipUtils.zipText(objectMapper.writeValueAsString(dto.getAnswers())));
    result.setScore(dto.getScore());
    result.setStudentId(dto.getStudentId());
    return result;
  }

  public ExaminationResultDto toDto(ExaminationResult entity) {
    ExaminationResultDto result = new ExaminationResultDto();
    result.setExaminationId(entity.getExaminationId());
    result.setAnswers(mapAnswers(entity));
    result.setId(entity.getId().toString());
    result.setScore(entity.getScore());
    result.setStudentId(entity.getStudentId());
    return result;
  }

  @SneakyThrows
  private List<AnswerDto> mapAnswers(ExaminationResult result) {
    String beforeMap = ZipUtils.unZipText(result.getAnswers());
    return objectMapper.readValue(beforeMap, new TypeReference<>() {
    });
  }
}
