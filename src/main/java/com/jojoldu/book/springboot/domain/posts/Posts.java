package com.jojoldu.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity //jpa의 어노테이션 위 둘의 롬복의 어노테이션 //테이블과 링크될 클래스임을 나타냄
public class Posts {

    @Id //해당 테이블의pk필드를 나타냅
    @GeneratedValue(strategy = GenerationType.IDENTITY) // pk의 생성 규칙을 나타냅니다.
    private Long id;

    @Column(length = 500, nullable = false) // 테이블의 컬럼을 나타내며 굳이 선언하지 않더라도 해당클래스의 필드는 모드 칼럼이 됨
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false) //
    private  String content;

    private String author;

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
