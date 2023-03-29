package com.example.snsservice;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record MemberResponseDto(Long id, String nickname, String email, LocalDate birthday, LocalDateTime createdAt) {
}
