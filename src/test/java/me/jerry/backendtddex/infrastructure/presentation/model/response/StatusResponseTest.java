package me.jerry.backendtddex.infrastructure.presentation.model.response;

import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class StatusResponseTest {

    // 순수자바기능만 테스트 하므로 @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) 가 없어도 돌아간다.

    @Test
    @DisplayName("상태응답 생성 - timestamp 가 주어졌을 때 - timestamp가 일치하는지 확인")
    public void createdStatusResponse_whenUseGivenTimeStamp_checkTheTimestamp(){
        //Given
        LocalDateTime time = LocalDateTime.of(2022,4,28,10,0);

        //When
        StatusResponse statusResponse = new StatusResponse(time);
        //Then
        assertEquals(statusResponse.getTimestamp(), time);

    }


    @Test
    @DisplayName("상태응답 생성 - timestamp 가 주어졌을 때 - FiveDaysLater 기능 동작 확인")
    public void createdStatusResponse_whenUseGivenTimeStamp_checkFiveDaysLaterFn(){

        // 변수의 타입읆 먼저 고민하지 않고 로직에 집중할 수 있다.
        var of = LocalDateTime.of(2022, 4, 20, 10, 0);
        val time = LocalDateTime.of(2022,4,20,10,0);

        //Given
        LocalDateTime timestamp = LocalDateTime.of(2022,4,20,10,0);

        //When
        StatusResponse statusResponse = new StatusResponse(time);
        //Then
        assertEquals(statusResponse.fiveDaysLater(time), LocalDateTime.of(2022,4,25,10,0));
        // 매개변수로 날짜를 받았기 떄문에 테스트를 할 수 있다.

    }


}