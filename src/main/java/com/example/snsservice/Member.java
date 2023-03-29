package com.example.snsservice;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Table(name="Member")
@Entity
public class Member {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nickname;

    @Column(updatable = false)
    private String email;

    @Column
    private LocalDate birthday;

    @CreationTimestamp // INSERT 시 자동으로 값을 채워줌
    @Column
    private LocalDateTime createdAt = LocalDateTime.now();

    private static Long NICKNAME_MAX_LENGTH=10L;



    @Builder
    public Member(String nickname,String email,LocalDate birthday) {
        this.birthday=birthday;
        this.email=email;
        validNickname(nickname);
        this.nickname=nickname;

    }

    private void validNickname(String nickname)
    {
        Assert.isTrue(nickname.length()<=NICKNAME_MAX_LENGTH,"닉네임은 10글자 이하로 작성해주세요");
    }

    public void updateNickname(String newname) //객체와 관련된 기능은 객체 안에서 구현하면 단위 테스트 짜기 용이함
    {
        Objects.requireNonNull(newname);
        validNickname(newname);
        nickname=newname;
    }


}
