package com.mypractice.user.repository;

import com.mypractice.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findUserByUserId(Long id);
}
