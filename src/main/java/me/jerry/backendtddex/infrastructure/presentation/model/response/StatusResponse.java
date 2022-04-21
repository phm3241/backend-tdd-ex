package me.jerry.backendtddex.infrastructure.presentation.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
        this.name = EnvComponent.NANE;
        this.version = EnvComponent.VERSION;
        this.timestamp = LocalDateTime.now();
    }
}
