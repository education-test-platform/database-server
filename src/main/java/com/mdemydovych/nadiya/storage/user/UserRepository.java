package com.mdemydovych.nadiya.storage.user;

import com.mdemydovych.nadiya.model.user.UserRole;
import com.mdemydovych.nadiya.storage.user.domain.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

interface UserRepository extends JpaRepository<User, String> {

  Optional<User> findByEmail(String email);

  List<User> findAllByRole(UserRole role);
}
