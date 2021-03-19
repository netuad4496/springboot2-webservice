package com.jojoldu.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//posts 클래스는 실제 DB 테이블과 매칭될 클래스로 JPA를 사용하면 수정을 통해 작업할 수 있습니다.

//클래스 내 모든 필드의 Getter 메소드를 자동생성
@Getter

//기본 생성자 자동 추가
@NoArgsConstructor

//테이블과 링크될 클래스
@Entity
public class Posts extends BaseTimeEntity {

//해당 테이블의 PK(기본키) 필드
    @Id
//PK 생성 규칙 / IDENTITY = DB의 identity 컬럼을 이용
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//테이블의 칼럼
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

//빌더 패턴 클래스 생성 / 현재 모든 선택적 인자를 다 받고 있음
    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}

