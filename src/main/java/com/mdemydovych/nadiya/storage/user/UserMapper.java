package com.mdemydovych.nadiya.storage.user;

import com.mdemydovych.nadiya.model.user.UserDto;
import com.mdemydovych.nadiya.storage.user.domain.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

  UserDto toDto(User entity);
}
