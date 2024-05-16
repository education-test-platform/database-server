package com.mdemydovych.nadiya.storage.user;

import com.mdemydovych.nadiya.model.user.UserDto;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.UUID;
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

  public List<UserDto> findByIds(List<UUID> ids) {
    return userRepository.findAllById(ids).stream()
        .map(mapper::toDto)
        .toList();
  }

}
