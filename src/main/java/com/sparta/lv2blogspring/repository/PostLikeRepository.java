package com.sparta.lv2blogspring.repository;

import com.sparta.lv2blogspring.entity.Post;
import com.sparta.lv2blogspring.entity.PostLike;
import com.sparta.lv2blogspring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostLikeRepository extends JpaRepository<PostLike, Long> {
    Optional<PostLike> findByUserAndPost(User user, Post post);
}
