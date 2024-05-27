package com.mdemydovych.nadiya.storage.user;

import com.mdemydovych.nadiya.model.user.UserDto;
import com.mdemydovych.nadiya.model.user.UserRole;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  private final UserMapper mapper;

  @SneakyThrows
  public UserDto findByEmail(String email) {
    return userRepository.findByEmail(email)
        .map(mapper::toDto)
        .orElseThrow(() -> new UserPrincipalNotFoundException("User not found " + email));
  }

  public List<UserDto> findByIds(List<String> ids) {
    return userRepository.findAllById(ids).stream()
        .map(mapper::toDto)
        .toList();
  }

  public List<UserDto> findUsersByRole(UserRole role) {
    return userRepository.findAllByRole(role).stream()
        .map(mapper::toDto)
        .toList();
  }
}
