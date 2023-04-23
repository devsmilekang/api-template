package com.kms.api.domain.survey.controller;

import com.kms.api.domain.survey.controller.dto.response.SurveyResponseDto;
import com.kms.api.domain.survey.controller.dto.response.assembler.SurveyResponseDtoAssembelr;
import com.kms.api.domain.survey.service.SurveyService;
import com.kms.api.domain.survey.service.vo.SurveyVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class SurveyQueryController {

    private final SurveyService surveyService;

    @GetMapping("/surveys/{surveyId}")
    public SurveyResponseDto getSurvey(@PathVariable Long surveyId){
        SurveyVo survey = surveyService.getSurveyById(surveyId);
        return SurveyResponseDtoAssembelr.of(survey);
    }

}
