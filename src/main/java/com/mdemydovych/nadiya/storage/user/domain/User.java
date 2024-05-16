package com.mdemydovych.nadiya.storage.user.domain;

import com.mdemydovych.nadiya.model.user.UserRole;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import java.util.Date;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Getter
@Setter
@Entity(name = "users")
public class User {

  @Id
  private UUID id;

  private String username;

  private String email;

  @Column(name = "registration_date", updatable = false)
  private Date registrationDate;

  @Enumerated(EnumType.STRING)
  private UserRole role;
}
