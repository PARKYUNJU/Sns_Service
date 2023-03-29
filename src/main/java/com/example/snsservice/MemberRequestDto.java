package com.example.snsservice;

import java.time.LocalDate;

public record MemberRequestDto(String nickname,
                               String email,
                               LocalDate birthday) {
}
