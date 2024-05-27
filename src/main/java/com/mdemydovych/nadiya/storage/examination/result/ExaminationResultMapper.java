package com.mdemydovych.nadiya.storage.examination.result;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mdemydovych.nadiya.model.examination.result.AnswerDto;
import com.mdemydovych.nadiya.model.examination.result.ExaminationResultDto;
import com.mdemydovych.nadiya.storage.examination.core.domain.Examination;
import com.mdemydovych.nadiya.storage.examination.core.mapper.ExaminationMapper;
import com.mdemydovych.nadiya.storage.examination.result.domain.ExaminationResult;
import com.mdemydovych.nadiya.storage.user.UserMapper;
import com.mdemydovych.nadiya.storage.utils.ZipUtils;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class ExaminationResultMapper {

  private final ObjectMapper objectMapper = new ObjectMapper();

  private final ExaminationMapper examinationMapper;

  private final UserMapper userMapper;

  @SneakyThrows
  public ExaminationResult toEntity(ExaminationResultDto dto) {
    ExaminationResult result = new ExaminationResult();
    result.setId(dto.getId());
    result.setAnswers(ZipUtils.zipText(objectMapper.writeValueAsString(dto.getAnswers())));
    result.setScore(dto.getScore());
    result.setStudent(userMapper.toEntity(dto.getStudent()));
    Examination examination = new Examination();
    examination.setId(dto.getExamination().getId());
    result.setExamination(examination);
    return result;
  }

  public ExaminationResultDto toDto(ExaminationResult entity) {
    ExaminationResultDto result = new ExaminationResultDto();
    result.setAnswers(mapAnswers(entity));
    result.setId(entity.getId());
    result.setScore(entity.getScore());
    result.setStudent(userMapper.toDto(entity.getStudent()));
    result.setExamination(examinationMapper.toDto(entity.getExamination()));
    return result;
  }

  @SneakyThrows
  private List<AnswerDto> mapAnswers(ExaminationResult result) {
    String beforeMap = ZipUtils.unZipText(result.getAnswers());
    return objectMapper.readValue(beforeMap, new TypeReference<>() {
    });
  }
}
