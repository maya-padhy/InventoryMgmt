package com.maya.networkinventorybackend.repository;

import com.maya.networkinventorybackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByApprovedBySuperAdmin(boolean approved);
    User findByUsername(String username);
}
