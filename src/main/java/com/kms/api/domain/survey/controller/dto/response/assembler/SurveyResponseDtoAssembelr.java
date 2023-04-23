package com.kms.api.domain.survey.controller.dto.response.assembler;

import com.kms.api.domain.survey.controller.dto.response.SurveyResponseDto;
import com.kms.api.domain.survey.service.vo.SurveyVo;

public class SurveyResponseDtoAssembelr {

    public static SurveyResponseDto of(SurveyVo surveyVo) {
        if(surveyVo == null ){
            return null;
        }
        return SurveyResponseDto.builder()
                .id(surveyVo.getId())
                .name(surveyVo.getName())
                .build();
    }
}
