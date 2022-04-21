package me.jerry.backendtddex.infrastructure.presentation.controller;

import me.jerry.backendtddex.infrastructure.component.EnvComponent;
import me.jerry.backendtddex.infrastructure.presentation.model.response.GenericResponse;
import me.jerry.backendtddex.infrastructure.presentation.model.response.StatusResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1.0/status")
public class StatusApiController {

    @GetMapping("/health")
    public GenericResponse<Object> health(){
        return new GenericResponse<Object>("서버 상태", new StatusResponse());
    }


}
