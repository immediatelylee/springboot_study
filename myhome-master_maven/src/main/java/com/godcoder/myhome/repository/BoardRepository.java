package com.godcoder.myhome.repository;

import com.godcoder.myhome.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board,Long> {}
