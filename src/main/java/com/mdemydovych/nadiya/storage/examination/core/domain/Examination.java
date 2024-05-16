package com.mdemydovych.nadiya.storage.examination.core.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.Date;
import java.util.Set;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Getter
@Setter
@Entity(name = "examinations")
public class Examination {

  @Id
  @GeneratedValue
  @JdbcTypeCode(SqlTypes.VARCHAR)
  private UUID id;

  private String title;

  @Column(name = "teacher_id")
  private String teacherId;

  @Column(updatable = false)
  private Date created;

  @OneToMany(mappedBy = "examination", cascade = CascadeType.ALL)
  private Set<Question> questions;
}
