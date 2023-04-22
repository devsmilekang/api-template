package com.kms.api.domain.survey.controller;

import com.kms.api.domain.survey.controller.dto.request.SurveyRequestDto;
import com.kms.api.domain.survey.controller.dto.response.SurveyResponseDto;
import com.kms.api.domain.survey.controller.dto.response.assembler.SurveyResponseDtoAssembelr;
import com.kms.api.domain.survey.service.SurveyService;
import com.kms.api.domain.survey.service.vo.SurveyVo;
import com.kms.api.domain.survey.service.vo.assembler.SurveyVoAssembler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class SurveyCommandController {

    private final SurveyService surveyService;

    @PostMapping("/surveys")
    public SurveyResponseDto createSurvey(@RequestBody SurveyRequestDto surveyRequestDto){
        SurveyVo surveyVo = surveyService.create(SurveyVoAssembler.of(surveyRequestDto));
        return SurveyResponseDtoAssembelr.of(surveyVo);
    }
}
