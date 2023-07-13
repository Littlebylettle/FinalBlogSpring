package com.sparta.lv2blogspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing //엔티티에 대한 수정 및 감사 기능은 엔티티의 생성일, 수정일, 생성자, 수정자 등과 같은 정보를 자동으로 관리할 수 있게 해줌
//보통 이러한 정보는 감사 로그를 생성하거나 엔티티의 변경 이력을 추적하는 데 사용
@SpringBootApplication
public class Lv2BlogSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lv2BlogSpringApplication.class, args);
    }

}
