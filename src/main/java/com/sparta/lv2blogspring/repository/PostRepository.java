package com.sparta.lv2blogspring.repository;

import com.sparta.lv2blogspring.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {

}
