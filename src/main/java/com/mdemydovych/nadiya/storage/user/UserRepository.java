package com.mdemydovych.nadiya.storage.user;

import com.mdemydovych.nadiya.storage.user.domain.User;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

interface UserRepository extends JpaRepository<User, UUID> {

  Optional<User> findByEmail(String email);
}
