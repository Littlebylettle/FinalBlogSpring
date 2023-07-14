package com.sparta.lv2blogspring.entity;

public enum UserRoleEnum {

    USER(Authority.USER),

    ADMIN(Authority.ADMIN);

    private final String authority;

    UserRoleEnum(String authority) {     //생성자를 만들때 authority필드에 user와 admin을 넣을 수 있도록 만듬.
        this.authority = authority;
    }

    public String getAuthority() {
        return this.authority;
    }

    public static class Authority {  //인라인 클래스
        public static final String USER = "ROLE_USER";
        public static final String ADMIN = "ROLE_ADMIN";
    }
}
