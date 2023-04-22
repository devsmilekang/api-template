package com.kms.api.domain.survey.controller.dto.response;

import lombok.Builder;
import lombok.Setter;

public record SurveyResponseDto(Long id, String name) {

    @Builder
    public SurveyResponseDto{}
}
