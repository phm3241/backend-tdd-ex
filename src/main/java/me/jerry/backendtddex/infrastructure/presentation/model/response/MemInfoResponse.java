package me.jerry.backendtddex.infrastructure.presentation.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import me.jerry.backendtddex.infrastructure.component.EnvComponent;

import java.time.LocalDateTime;

@Getter
@Setter
public class MemInfoResponse {

    private Long maxMemory;
    private Long freeMemory;
    private Long totalMemory;

    public MemInfoResponse() {
        this.maxMemory =   Runtime.getRuntime().maxMemory();
        this.freeMemory =  Runtime.getRuntime().freeMemory();
        this.totalMemory = Runtime.getRuntime().totalMemory();
    }
}
