package com.sparta.lv2blogspring.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequestDto {
    private Long postId;  //어떤 게시글의 댓글인지를 알기 위해
    private String body;
}
