package com.example.PlaceFinder.repository;

import com.example.PlaceFinder.DBManager;
import com.example.PlaceFinder.entity.User;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Component
public class UserRepository {
    @Autowired
    private ApplicationContext ctx;
    @Autowired
    private DBManager service;

    public User findByUsername(String username) {
        return service.getUser(username);
    }
}
