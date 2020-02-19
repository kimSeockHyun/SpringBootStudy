package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>{
	Users findByUserIdAndUserPw(String user_id, String user_pw);
}
