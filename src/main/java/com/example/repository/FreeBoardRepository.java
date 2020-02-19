package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.FreeBoard;
import com.example.model.Users;

@Repository
public interface FreeBoardRepository extends JpaRepository<FreeBoard, Long>{
}
