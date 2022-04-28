package me.jerry.backendtddex.infrastructure.presentation.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import me.jerry.backendtddex.infrastructure.component.EnvComponent;

import java.time.LocalDateTime;

@Getter
@Setter
public class StatusResponse {

    private String name;
    private String version;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss z", timezone = "Asia/Seoul")
    private LocalDateTime timestamp;


    public StatusResponse() {
        this.name = EnvComponent.NAME;
        this.version = EnvComponent.VERSION;
        this.timestamp = LocalDateTime.now();
    }

    public StatusResponse(LocalDateTime timestamp) {
        this.name = EnvComponent.NAME;
        this.version = EnvComponent.VERSION;
        this.timestamp = timestamp;
    }

    public LocalDateTime fiveDaysLater(LocalDateTime timestamp){  // 이렇게 해야 테스트를 하는 가능하다.
        return timestamp.plusDays(5);
    }



}
