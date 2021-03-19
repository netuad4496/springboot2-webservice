package com.jojoldu.book.springboot.domain.posts;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

//모든 Entity 상위 클래스로 Date를 자동으로 관리
@Getter

//JPA Entity 클래스들이 Base을 상속할 경우 필드들도 칼럼으로 인식
@MappedSuperclass

//Auditing 기능 포함
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {

    // 저장될 때 시간이 자동으로 저장
    @CreatedDate
    private LocalDateTime createdDate;

    //값을 변경할 때 시간 자동 저장
    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
