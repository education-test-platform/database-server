package com.mdemydovych.nadiya.storage.assigment.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "assigments")
public class Assigment {

  @EmbeddedId
  private AssigmentId id;

  @Data
  @Embeddable
  @AllArgsConstructor
  @NoArgsConstructor
  public static class AssigmentId implements Serializable {

    @Column(name = "teacher_id")
    private String teacherId;

    @Column(name = "student_id")
    private String studentId;
  }
}
