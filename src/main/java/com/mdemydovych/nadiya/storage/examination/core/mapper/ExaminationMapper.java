package com.mdemydovych.nadiya.storage.examination.core.mapper;


import com.mdemydovych.nadiya.model.examination.core.ExaminationDto;
import com.mdemydovych.nadiya.model.examination.core.QuestionDto;
import com.mdemydovych.nadiya.storage.examination.core.domain.Examination;
import com.mdemydovych.nadiya.storage.examination.core.domain.Question;
import com.mdemydovych.nadiya.storage.user.UserMapper;
import com.mdemydovych.nadiya.storage.user.domain.User;
import java.util.Date;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExaminationMapper {

  private final QuestionMapper questionMapper;

  private final UserMapper userMapper;

  public Examination toEntity(ExaminationDto dto) {
    Examination examination = new Examination();
    examination.setId(dto.getId());
    examination.setTitle(dto.getTitle());
    examination.setCreated(new Date());
    examination.setOpened(dto.isEnabled());
    Set<Question> questions = questionMapper.toEntity(dto.getQuestions(), examination);
    examination.setQuestions(questions);
    User user = new User();
    user.setId(dto.getTeacher().getId());
    examination.setTeacher(user);
    return examination;
  }

  public ExaminationDto toDto(Examination examination) {
    ExaminationDto result = new ExaminationDto();
    result.setId(examination.getId());
    result.setTitle(examination.getTitle());
    result.setEnabled(examination.isOpened());
    result.setTeacher(userMapper.toDto(examination.getTeacher()));
    Set<QuestionDto> questions = questionMapper.toDto(examination.getQuestions());
    result.setQuestions(questions);
    return result;
  }


}
