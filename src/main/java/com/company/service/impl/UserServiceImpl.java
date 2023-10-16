package com.company.service.impl;

import com.company.dto.UserDto;
import com.company.service.inter.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{



    @Override
    public UserDto getUserById(Long id) {
        return null;
    }

    @Override
    public UserDto getUserByUserName(String userName) {
        return null;
    }

    @Override
    public UserDto getUserByEmail(String email) {
        return null;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return null;
    }

    @Override
    public List<UserDto> getUsersByPage(int pageNumber, int pageSize) {
        return null;
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        return null;
    }

    @Override
    public boolean deleteAllUsers() {
        return false;
    }

    @Override
    public boolean deleteUserById(Long id) {
        return false;
    }
}
