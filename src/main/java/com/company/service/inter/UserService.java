package com.company.service.inter;

import com.company.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto getUserById(Long id);
    UserDto getUserByUserName(String userName);
    UserDto getUserByEmail(String email);
    List<UserDto> getAllUsers();
    List<UserDto> getUsersByPage(int pageNumber,int pageSize);

    UserDto updateUser(UserDto userDto);
    boolean deleteAllUsers();
    boolean deleteUserById(Long id);
}
