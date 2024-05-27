package com.mdemydovych.nadiya.storage.examination.result.domain;

import com.mdemydovych.nadiya.storage.examination.core.domain.Examination;
import com.mdemydovych.nadiya.storage.user.domain.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Getter
@Setter
@Entity(name = "examination_results")
public class ExaminationResult {

  @Id
  @UuidGenerator
  private String id;

  @ManyToOne
  @JoinColumn(name = "student_id", nullable = false)
  private User student;

  private String score;

  private byte[] answers;

  @ManyToOne
  @JoinColumn(name = "examination_id", nullable = false)
  private Examination examination;
}
