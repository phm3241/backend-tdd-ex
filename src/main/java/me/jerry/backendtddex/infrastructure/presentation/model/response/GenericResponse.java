package me.jerry.backendtddex.infrastructure.presentation.model.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GenericResponse<T> {

    private String message;
    private T data;

    public GenericResponse(String message) {
        this.message = message;
    }

    public GenericResponse(String message, T data) {
        this.message = message;
        this.data = data;
    }
}
