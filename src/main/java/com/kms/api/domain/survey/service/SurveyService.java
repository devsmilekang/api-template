package com.kms.api.domain.survey.service;

import com.kms.api.domain.survey.entity.Survey;
import com.kms.api.domain.survey.repository.SurveyRepository;
import com.kms.api.domain.survey.service.vo.SurveyVo;
import com.kms.api.domain.survey.service.vo.assembler.SurveyVoAssembler;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class SurveyService {

    private final SurveyRepository surveyRepository;

    @Transactional
    public SurveyVo create(SurveyVo surveyVo) {
        Survey survey = Survey.create(surveyVo);
        Survey savedSurvey = surveyRepository.save(survey);

        return SurveyVoAssembler.of(savedSurvey);
    }

    public SurveyVo getSurveyById(Long id) {
        try {
            return SurveyVoAssembler.of(surveyRepository.getReferenceById(id));
        } catch (EntityNotFoundException exception) {
            log.warn("해당 서베이가 없습니다. 서베이 id : {}", id);
            return null;
        }
    }
}
