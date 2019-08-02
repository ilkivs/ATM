package com.ilkiv.atm.service.impl;

import com.ilkiv.atm.dao.UserJdbcTemplate;
import com.ilkiv.atm.model.User;
import com.ilkiv.atm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserJdbcTemplate userJdbcTemplate;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public void putMoney(User user, double sum) {
        userJdbcTemplate.putMoney(user, sum);
    }

    public void getMoney(User user, double sum) {
        userJdbcTemplate.getMoney(user, sum);
    }

    public void translateMoney(User sender, User receiver, double sum) {
        userJdbcTemplate.getMoney(sender, sum);
        userJdbcTemplate.putMoney(receiver, sum);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
