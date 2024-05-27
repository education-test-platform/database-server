package com.mdemydovych.nadiya.storage.examination.core.domain;

import com.mdemydovych.nadiya.storage.user.domain.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.Date;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Getter
@Setter
@Entity(name = "examinations")
public class Examination {

  @Id
  @UuidGenerator
  private String id;

  private String title;

  @ManyToOne
  @JoinColumn(name = "teacher_id", nullable = false)
  private User teacher;

  @Column(updatable = false)
  private Date created;

  @OneToMany(mappedBy = "examination", cascade = CascadeType.ALL)
  private Set<Question> questions;
}
