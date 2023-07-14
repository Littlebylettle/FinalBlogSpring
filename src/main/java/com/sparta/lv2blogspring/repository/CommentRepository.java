package com.sparta.lv2blogspring.repository;

import com.sparta.lv2blogspring.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
