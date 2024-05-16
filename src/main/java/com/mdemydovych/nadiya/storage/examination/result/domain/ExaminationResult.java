package com.mdemydovych.nadiya.storage.examination.result.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Getter
@Setter
@Entity(name = "examination_results")
public class ExaminationResult {

  @Id
  @GeneratedValue
  @JdbcTypeCode(SqlTypes.VARCHAR)

  @Column(name = "student_id")
  private String studentId;

  private String score;

  private byte[] answers;

  @Column(name = "examination_id", nullable = false)
  private String examinationId;
}
