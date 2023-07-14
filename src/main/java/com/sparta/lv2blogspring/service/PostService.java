package com.sparta.lv2blogspring.service;

import com.sparta.lv2blogspring.dto.PostListResponseDto;
import com.sparta.lv2blogspring.dto.PostRequestDto;
import com.sparta.lv2blogspring.dto.PostResponseDto;
import com.sparta.lv2blogspring.entity.Post;
import com.sparta.lv2blogspring.entity.User;
import com.sparta.lv2blogspring.entity.UserRoleEnum;
import com.sparta.lv2blogspring.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public PostResponseDto createPost(PostRequestDto requestDto, User user) {
        Post post = new Post(requestDto);
        post.setUser(user);

        postRepository.save(post);

        return new PostResponseDto(post);
    }

    public PostListResponseDto getPosts() {
        List<PostResponseDto> postList = postRepository.findAll().stream()
                .map(PostResponseDto::new)
                .collect(Collectors.toList());

        return new PostListResponseDto(postList);
    }

    public PostResponseDto getPostById(Long id) {
        Post post = findPost(id);

        return new PostResponseDto(post);
    }

    public void deletePost(Long id, User user) {
        Post post = findPost(id);
        //게시글 작성자와 요청자가 같은지 또는 관리자인지 체크 -> 아닐시 예외 발생
        if (!user.getRole().equals(UserRoleEnum.ADMIN) && !post.getUser().equals(user)) {
            throw new RejectedExecutionException();
        }

        postRepository.delete(post);
    }

    @Transactional
    public PostResponseDto updatePost(Long id, PostRequestDto requestDto, User user) {
        Post post = findPost(id);
        //게시글 작성자와 요청자가 같은지 또는 관리자인지 체크 -> 아닐시 예외 발생
        if (!user.getRole().equals(UserRoleEnum.ADMIN) && !post.getUser().equals(user)) {
            throw new RejectedExecutionException();
        }

        post.setTitle(requestDto.getTitle());
        post.setContent(requestDto.getContent());

        return new PostResponseDto(post);
    }

    public Post findPost(long id) {
        return postRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 게시글은 존재하지 않습니다.")
        );
    }
}