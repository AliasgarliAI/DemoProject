package com.company.repository;

import com.company.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;


    public void insert(User user){
        String query =  "insert into \"user\" " +
                "(first_name, last_name, user_name," +
                "phone_number, password, email," +
                "profile_image_url, is_not_locked, is_active," +
                "last_login_date,last_login_date_display,join_date) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(query,
                user.getFirstName(),user.getLastName(),user.getUserName(),
                user.getPhoneNumber(),user.getPassword(),user.getEmail(),
                user.getProfileImageUrl(),user.isNotLocked(),user.isActive(),
                user.getLastLoginDate(),user.getLastLoginDateDisplay(),user.getJoinDate());
    }
}
