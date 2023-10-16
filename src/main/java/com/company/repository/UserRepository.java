package com.company.repository;

import com.company.mapper.UserRowMapper;
import com.company.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
@RequiredArgsConstructor
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;
    private final UserRowMapper userRawMapper;

    public Optional<List<User>> getUsersByPage(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;

        String query = "Select * from \"users\" limit ? offset ?";

        List<User> users = jdbcTemplate.query(query, userRawMapper, pageSize, offset);

        return Optional.of(users);
    }

    public Optional<List<User>> getAllUsers() {
        String query = "Select * from \"users\"";

        List<User> users = jdbcTemplate.query(query, userRawMapper);

        return Optional.of(users);
    }

    public Optional<User> getUserByUserName(String userName) {
        String query = "select * from \"users\" u where u.user_name = ? limit 1";

        User user = jdbcTemplate.queryForObject(query, userRawMapper, userName);

        return Optional.ofNullable(user);
    }

    public Optional<User> getUserByUserEmail(String email) {
        String query = "select * from \"users\" u where u.email = ? ";

        User user = jdbcTemplate.queryForObject(query, userRawMapper, email);

        return Optional.ofNullable(user);
    }

    public Optional<User> getUserByPhoneNumber(String phoneNumber) {
        String query = "select * from \"users\" u where u.phone_number = ?";

        User user = jdbcTemplate.queryForObject(query, userRawMapper, phoneNumber);

        return Optional.ofNullable(user);
    }

    public void createUser(User user) {
        String query = "insert into \"users\" " +
                "(first_name, last_name, user_name," +
                "phone_number, password, email," +
                "profile_image_url, is_not_locked, is_active," +
                "last_login_date,last_login_date_display,join_date) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(query,
                user.getFirstName(), user.getLastName(), user.getUserName(),
                user.getPhoneNumber(), user.getPassword(), user.getEmail(),
                user.getProfileImageUrl(), user.isNotLocked(), user.isActive(),
                user.getLastLoginDate(), user.getLastLoginDateDisplay(), user.getJoinDate());
    }

    public User updateUser(User user) {
        String query = "UPDATE \"users\" " +
                "SET " +
                "first_name = ?, last_name = ?, user_name = ?, " +
                "phone_number = ?, password = ?, email = ?, " +
                "profile_image_url = ?, is_not_locked = ?, is_active= ?, " +
                "last_login_date = ?, last_login_date_display =?, join_date = ? " +
                "WHERE Id = ?";

        return jdbcTemplate.queryForObject(query, userRawMapper,
                user.getFirstName(), user.getLastName(), user.getUserName(),
                user.getPhoneNumber(), user.getPassword(), user.getEmail(),
                user.getProfileImageUrl(), user.isNotLocked(), user.isActive(),
                user.getLastLoginDate(), user.getLastLoginDateDisplay(), user.getJoinDate(), user.getId());
    }

    public boolean deleteAllUsers() {
        String query = "DELETE from \"users\"";

        int result = jdbcTemplate.update(query);

        return result > 0;
    }

    public boolean deleteUserById(long id) {
        String query = "delete from \"users\" u where u.Id =? ";

        int result = jdbcTemplate.update(query, id);

        return result > 0;
    }

    public boolean deleteUserByUserName(String userName){
        String query = "delete from \"users\" u where u.user_name = ?";

        int result = jdbcTemplate.update(query, userName);

        return result > 0;
    }
}
