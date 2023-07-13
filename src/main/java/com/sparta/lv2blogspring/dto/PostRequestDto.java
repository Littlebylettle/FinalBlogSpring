package com.sparta.lv2blogspring.dto;


import lombok.Getter;

@Getter
public class PostRequestDto {
    private String title;
    private String name;
    private String content;
    private String password;
}
