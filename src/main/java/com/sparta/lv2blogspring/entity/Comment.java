package com.sparta.lv2blogspring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "comment")
public class Comment extends TimeStamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String body;

    @ManyToOne
    @JoinColumn(name = "post_id")   //게시글에 댓글을 다는 것이기 때문에 연관관계가 있음 댓글 다수 게시물 하나 -> ManyToOne
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id")  //유저 한명이 여러개의 코멘트가 가능 -> ManyToOne
    private User user;

    public Comment(String body) {
        this.body = body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}