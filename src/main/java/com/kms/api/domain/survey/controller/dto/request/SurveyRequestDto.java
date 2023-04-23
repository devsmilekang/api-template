package com.kms.api.domain.survey.controller.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public record SurveyRequestDto(
    String name
){
    @Builder
    public SurveyRequestDto{}
}
