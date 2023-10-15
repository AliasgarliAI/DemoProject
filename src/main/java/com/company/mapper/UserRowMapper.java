package com.company.mapper;

import com.company.model.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();

        user.setId(rs.getLong("Id"));
        user.setFirstName(rs.getString("first_name"));
        user.setLastName(rs.getString("last_name"));
        user.setUserName(rs.getString("user_name"));
        user.setPhoneNumber(rs.getString("phone_number"));
        user.setPassword(rs.getString("password"));
        user.setEmail(rs.getString("email"));
        user.setProfileImageUrl(rs.getString("profile_image_url"));
        user.setNotLocked(rs.getBoolean("is_not_locked"));
        user.setNotLocked(rs.getBoolean("is_active"));
        user.setLastLoginDate(rs.getTimestamp("last_login_date").toLocalDateTime());
        user.setLastLoginDateDisplay(rs.getTimestamp("last_login_date_display").toLocalDateTime());
        user.setJoinDate(rs.getTimestamp("join_date").toLocalDateTime());


        return user;
    }

}
