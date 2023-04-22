package com.kms.api.domain.survey.entity;

import com.kms.api.domain.survey.service.vo.SurveyVo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

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
