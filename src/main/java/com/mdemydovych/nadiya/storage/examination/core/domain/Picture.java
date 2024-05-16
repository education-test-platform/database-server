package com.mdemydovych.nadiya.storage.examination.core.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Getter
@Setter
@Entity(name = "pictures")
public class Picture {

  @Id
  @GeneratedValue
  @JdbcTypeCode(SqlTypes.VARCHAR)
  private UUID id;

  private byte[] picture;

  @OneToOne(cascade = CascadeType.ALL, mappedBy = "picture")
  private Question question;
}
