package com.mdemydovych.nadiya.storage.examination.core.mapper;

import com.mdemydovych.nadiya.model.examination.core.PictureDto;
import com.mdemydovych.nadiya.storage.examination.core.domain.Picture;
import com.mdemydovych.nadiya.storage.examination.core.domain.Question;
import java.util.Objects;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class PictureMapper {

  public Picture toEntity(PictureDto dto, Question question) {
    if (Objects.isNull(dto)) {
      return null;
    }
    Picture picture = new Picture();
    picture.setId(Objects.nonNull(dto.getId()) ? UUID.fromString(dto.getId()) : null);
    picture.setPicture(dto.getPicture());
    picture.setQuestion(question);
    return picture;
  }

  public PictureDto toDto(Picture picture) {
    if (Objects.isNull(picture)) {
      return null;
    }
    PictureDto result = new PictureDto();
    result.setId(picture.getId().toString());
    result.setPicture(picture.getPicture());
    return result;
  }
}
