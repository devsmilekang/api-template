package com.kms.api.domain.survey.entity;

import com.kms.api.domain.survey.service.vo.SurveyVo;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class Survey {

    public static Survey create(SurveyVo surveyVo) {
        Survey survey = new Survey();
        survey.name = surveyVo.getName();
        return survey;
    }

    @Id
    @GeneratedValue
    Long id;

    @Column
    String name;
}
