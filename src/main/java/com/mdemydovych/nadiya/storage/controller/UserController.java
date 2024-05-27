package com.mdemydovych.nadiya.storage.controller;

import com.mdemydovych.nadiya.model.user.UserDto;
import com.mdemydovych.nadiya.model.user.UserRole;
import com.mdemydovych.nadiya.storage.user.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

  private final UserService userService;

  @GetMapping("/find/{email}")
  public UserDto findUserByEmail(@PathVariable String email) {
    return userService.findByEmail(email);
  }

  @GetMapping("/find/by/role")
  public List<UserDto> findUserByEmail(@RequestParam(name = "role") UserRole role) {
    return userService.findUsersByRole(role);
  }
}
