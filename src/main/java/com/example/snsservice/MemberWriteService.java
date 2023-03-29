package com.example.snsservice;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.snsservice.MemberRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberWriteService {

    private final MemberRepository memberRepository;

    @Transactional
    public MemberResponseDto createMember(MemberRequestDto memberRequestDto)
    {
        Member member= Member.builder().
                nickname(memberRequestDto.nickname()).
                email(memberRequestDto.email()).
                birthday(memberRequestDto.birthday()).build();

        memberRepository.save(member);


        return new MemberResponseDto(member.getId(),member.getNickname(),member.getEmail(),member.getBirthday(),member.getCreatedAt());


    }

}
