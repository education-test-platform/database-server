package com.mdemydovych.nadiya.storage.examination.core.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Getter
@Setter
@Entity(name = "questions")
public class Question {

  @Id
  @UuidGenerator
  private String id;

  private String description;

  private byte[] variants;

  @ManyToOne
  @JoinColumn(name = "examination_id", nullable = false)
  private Examination examination;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "picture_id", referencedColumnName = "id")
  private Picture picture;

}
