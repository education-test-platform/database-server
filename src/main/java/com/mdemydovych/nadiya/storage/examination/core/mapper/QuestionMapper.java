package com.mdemydovych.nadiya.storage.examination.core.mapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mdemydovych.nadiya.model.examination.core.PictureDto;
import com.mdemydovych.nadiya.model.examination.core.QuestionDto;
import com.mdemydovych.nadiya.model.examination.core.VariantDto;
import com.mdemydovych.nadiya.storage.examination.core.domain.Examination;
import com.mdemydovych.nadiya.storage.examination.core.domain.Picture;
import com.mdemydovych.nadiya.storage.examination.core.domain.Question;
import com.mdemydovych.nadiya.storage.utils.ZipUtils;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class QuestionMapper {

  private final PictureMapper pictureMapper;

  private final ObjectMapper objectMapper = new ObjectMapper();

  public Set<Question> toEntity(Set<QuestionDto> list, Examination examination) {
    Set<Question> result = new HashSet<>();
    for (QuestionDto questionDto : list) {
      result.add(toEntity(questionDto, examination));
    }
    return result;
  }

  @SneakyThrows
  private Question toEntity(QuestionDto dto, Examination examination) {
    Question question = new Question();
    question.setId(dto.getId());
    question.setDescription(dto.getDescription());
    question.setExamination(examination);
    question.setVariants(ZipUtils.zipText(objectMapper.writeValueAsString(dto.getVariants())));
    Picture picture = pictureMapper.toEntity(dto.getPicture(), question);
    question.setPicture(picture);
    return question;
  }

  public Set<QuestionDto> toDto(Set<Question> list) {
    Set<QuestionDto> result = new HashSet<>();
    for (Question question : list) {
      result.add(toDto(question));
    }
    return result;
  }

  @SneakyThrows
  private QuestionDto toDto(Question question) {
    QuestionDto result = new QuestionDto();
    result.setId(question.getId().toString());
    result.setDescription(question.getDescription());
    result.setVariants(mapVariants(question));
    PictureDto picture = pictureMapper.toDto(question.getPicture());
    result.setPicture(picture);
    return result;
  }

  @SneakyThrows
  private List<VariantDto> mapVariants(Question question) {
    String beforeMap = ZipUtils.unZipText(question.getVariants());
    return objectMapper.readValue(beforeMap, new TypeReference<>() {
    });
  }
}
