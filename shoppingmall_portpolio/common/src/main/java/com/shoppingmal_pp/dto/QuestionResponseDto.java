package com.shoppingmal_pp.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Builder
@ToString
public class QuestionResponseDto {

    private Long id;
    private String message;
    private boolean answerState;
    private Integer answerCount;
    private String createdDate;
    private LocalDateTime modifiedDate;
    private com.shoppingmall.dto.UserResponseDto.QuestionUserResponseDto questionUserResponseDto;
}
