package com.mdemydovych.nadiya.storage.controller;

import com.mdemydovych.nadiya.model.user.UserDto;
import com.mdemydovych.nadiya.storage.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
