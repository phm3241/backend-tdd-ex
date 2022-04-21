package me.jerry.backendtddex.infrastructure.presentation.controller;

import me.jerry.backendtddex.infrastructure.presentation.model.response.GenericResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StatusApiControllerTest {

    public static final String API_V_1_0_STATUS_HEALTH = "/api/v1.0/status/health";

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    @DisplayName("Health API 호출 - 서버상태 정상일 때 - OK 응답확인")
    void getHealth_whenServerIsValid_receiveOk(){
        //Given
        //When
        ResponseEntity<Object> response = testRestTemplate.getForEntity(API_V_1_0_STATUS_HEALTH, Object.class);

        //then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }


    @Test
    @DisplayName("Health API 호충 - 서버상태 정상일 때 - 응답 메시지 확인")
    public void getHealth_whenServerIsValid_receiveMessage(){
        //Given
        //When
        ResponseEntity<GenericResponse> response = testRestTemplate.getForEntity(API_V_1_0_STATUS_HEALTH, GenericResponse.class);

        //Then
        assertThat(response.getBody().getMessage()).isNotBlank();
    }

    @Test
    @DisplayName("Health API 호충 - 서버상태 정상일 때 - 서버이름, 버전, 시간 확인")
    public void getHealth_whenServerIsValid_receiveNameAndVersionAndTimestampExist(){
        //Given
        //When
        ResponseEntity<GenericResponse> response = testRestTemplate.getForEntity(API_V_1_0_STATUS_HEALTH, GenericResponse.class);
        Map<String,String> data = (Map<String,String>) response.getBody().getData();

        //Then
        assertThat(data.get("name")).isNotBlank();
        assertThat(data.get("version")).isNotBlank();
        assertThat(data.get("timestamp")).isNotBlank();
    }





}