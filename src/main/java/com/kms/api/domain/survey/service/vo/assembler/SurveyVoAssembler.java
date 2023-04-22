package com.kms.api.domain.survey.service.vo.assembler;

import com.kms.api.domain.survey.controller.dto.request.SurveyRequestDto;
import com.kms.api.domain.survey.entity.Survey;
import com.kms.api.domain.survey.service.vo.SurveyVo;

public class SurveyVoAssembler {

    public static SurveyVo of(Survey survey) {
        SurveyVo surveyVo = new SurveyVo();
        surveyVo.setName(survey.getName());
        surveyVo.setId(survey.getId());
        return surveyVo;
    }

    public static SurveyVo of(SurveyRequestDto surveyRequestDto) {
        SurveyVo survey = new SurveyVo();
        survey.setName(surveyRequestDto.name());
        return survey;
    }
}
