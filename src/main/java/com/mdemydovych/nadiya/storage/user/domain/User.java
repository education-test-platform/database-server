package com.mdemydovych.nadiya.storage.user.domain;

import com.mdemydovych.nadiya.model.user.UserRole;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "users")
public class User {

  @Id
  private String id;

  private String username;

  private String email;

  @Column(name = "registration_date", updatable = false)
  private Date registrationDate;

  @Enumerated(EnumType.STRING)
  private UserRole role;
}
