package com.example.thymeleaf_layout2.repository;

import com.example.thymeleaf_layout2.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board,Long> {}
