package com.kms.api.domain.survey.service;

import com.kms.api.domain.survey.entity.Survey;
import com.kms.api.domain.survey.repository.SurveyRepository;
import com.kms.api.domain.survey.service.vo.SurveyVo;
import com.kms.api.domain.survey.service.vo.assembler.SurveyVoAssembler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SurveyService {

    private final SurveyRepository surveyRepository;

    @Transactional
    public SurveyVo create(SurveyVo surveyVo) {
        Survey survey = Survey.create(surveyVo);
        Survey savedSurvey = surveyRepository.save(survey);

        return SurveyVoAssembler.of(savedSurvey);
    }
}
