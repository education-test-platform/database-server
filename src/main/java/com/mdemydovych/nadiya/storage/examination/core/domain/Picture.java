package com.mdemydovych.nadiya.storage.examination.core.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Getter
@Setter
@Entity(name = "pictures")
public class Picture {

  @Id
  @UuidGenerator
  private String id;

  private byte[] picture;

  @OneToOne(cascade = CascadeType.ALL, mappedBy = "picture")
  private Question question;
}
