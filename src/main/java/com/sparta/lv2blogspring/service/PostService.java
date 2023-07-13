package com.sparta.lv2blogspring.service;

import com.sparta.lv2blogspring.dto.PostRequestDto;
import com.sparta.lv2blogspring.dto.PostResponseDto;
import com.sparta.lv2blogspring.entity.Post;
import com.sparta.lv2blogspring.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<PostResponseDto> getPostList() {
        return postRepository.findAllByOrderByCreateAtDesc().stream() //
                .map(PostResponseDto::new).toList();
    }
    //DB조회 리스트 -> 스트림 -> PostResponsDto로 변환 -> Stream 다시 List 변환

    public PostResponseDto getPost(Long id) {
        Post post = findPost(id);
        return new PostResponseDto(post);

    }

    public PostResponseDto createPost(PostRequestDto postRequestDto) {
        Post post = new Post(postRequestDto);
        Post savePost = postRepository.save(post);
        return new PostResponseDto(savePost);
    }

    @Transactional
    public PostResponseDto updatePost(Long id, PostRequestDto postRequestDto) {
        Post post = findPost(id);
        post.checkPassword(postRequestDto.getPassword());

        post.setTitle(postRequestDto.getTitle());
        post.setName(postRequestDto.getName());
        post.setContent(postRequestDto.getContent());

        return new PostResponseDto(post);
    }

    public void deletePost(Long id, String password) {
       Post post = findPost(id);
       post.checkPassword(password);

       postRepository.delete(post);
    }
    private Post findPost(Long id) {
        return postRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 글이 존재하지 않습니다."));
    }

}


