package com.mdemydovych.nadiya.storage.examination.core.mapper;


import com.mdemydovych.nadiya.model.examination.core.ExaminationDto;
import com.mdemydovych.nadiya.model.examination.core.QuestionDto;
import com.mdemydovych.nadiya.storage.examination.core.domain.Examination;
import com.mdemydovych.nadiya.storage.examination.core.domain.Question;
import java.util.Date;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExaminationMapper {

  private final QuestionMapper questionMapper;

  public Examination toEntity(ExaminationDto dto) {
    Examination examination = new Examination();
    examination.setId(Objects.nonNull(dto.getId()) ? UUID.fromString(dto.getId()) : null);
    examination.setTitle(dto.getTitle());
    examination.setTeacherId(dto.getTeacherId());
    examination.setCreated(new Date());
    Set<Question> questions = questionMapper.toEntity(dto.getQuestions(), examination);
    examination.setQuestions(questions);
    return examination;
  }

  public ExaminationDto toDto(Examination examination) {
    ExaminationDto result = new ExaminationDto();
    result.setId(examination.getId().toString());
    result.setTitle(examination.getTitle());
    result.setTeacherId(examination.getTeacherId());
    Set<QuestionDto> questions = questionMapper.toDto(examination.getQuestions());
    result.setQuestions(questions);
    return result;
  }


}
