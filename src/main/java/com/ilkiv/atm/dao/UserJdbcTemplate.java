package com.ilkiv.atm.dao;

import com.ilkiv.atm.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;

@Component
public class UserJdbcTemplate {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void putMoney(User user, double sum) {
        String query = "UPDATE USERS SET account = ? WHERE id = ?;";
        jdbcTemplate.update(query, ps -> {
            ps.setDouble(1, getAccount(user) + sum);
            ps.setLong(2, user.getId());
            ps.executeUpdate();
        });
    }

    public void getMoney(User user, double sum) {
        String query = "UPDATE USERS SET account = ? WHERE id = ?;";
        jdbcTemplate.update(query, ps -> {
            ps.setDouble(1, getAccount(user) - sum);
            ps.setLong(2, user.getId());
            ps.executeUpdate();
        });
    }

    private double getAccount(User user) {
        String query = "SELECT * FROM USERS WHERE id = ?";
        User User = jdbcTemplate.execute(query, (PreparedStatementCallback<User>) ps -> {
            ps.setLong(1, user.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new User(rs.getLong(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDouble(6));
            } else {
                return null;
            }
        });
        return user.getAccount();
    }

    public UserDetails getByAccountNumber(String accountNumber) {
        return null;
    }
}
