package com.mdemydovych.nadiya.storage.examination.core.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Getter
@Setter
@Entity(name = "questions")
public class Question {

  @Id
  @GeneratedValue
  @JdbcTypeCode(SqlTypes.VARCHAR)
  private UUID id;

  private String description;

  private byte[] variants;

  @ManyToOne
  @JoinColumn(name = "examination_id", nullable = false)
  private Examination examination;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "picture_id", referencedColumnName = "id")
  private Picture picture;

}
