package com.kms.api.domain.survey.controller;

import com.epages.restdocs.apispec.MockMvcRestDocumentationWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kms.api.domain.survey.controller.dto.request.SurveyRequestDto;
import com.kms.api.domain.survey.service.SurveyService;
import com.kms.api.domain.survey.service.vo.SurveyVo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;

import static com.epages.restdocs.apispec.MockMvcRestDocumentationWrapper.document;
import static com.epages.restdocs.apispec.MockMvcRestDocumentationWrapper.resourceDetails;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;

@WebMvcTest(SurveyCommandController.class)
@AutoConfigureRestDocs
class SurveyCommandControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SurveyService surveyService;

    @Test
    @DisplayName("서베이 생성")
    public void createSurvey() throws Exception {

        SurveyVo surveyVo = new SurveyVo();
        surveyVo.setId(1L);
        surveyVo.setName("테스트");
        BDDMockito.given(surveyService.create(any(SurveyVo.class))).willReturn(surveyVo);

        SurveyRequestDto request = SurveyRequestDto.builder().name("테스트").build();
        ObjectMapper objectMapper = new ObjectMapper();

        mockMvc.perform(post("/api/v1/surveys")
                .content(objectMapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
        ).andDo(document("서베이 생성"
                , resourceDetails()
                        .description("서베이 생성을 합니다.")
                        .tag("서베이 추가")
                        .summary("서베이 서머리")
                , requestFields(fieldWithPath("name").type(JsonFieldType.STRING).description("서베이 이름"))
                , responseFields(
                        subsectionWithPath("data").description("데이터"),
                        fieldWithPath("data.id").type(JsonFieldType.NUMBER).description("서베이 아이디"),
                        fieldWithPath("data.name").type(JsonFieldType.STRING).description("서베이 이름")
                )
        ));

    }


}