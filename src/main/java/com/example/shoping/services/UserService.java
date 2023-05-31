package com.example.shoping.services;

import com.example.shoping.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto updateUserById(UserDto userDto,String userId);
    UserDto getUserById(String id);

}
