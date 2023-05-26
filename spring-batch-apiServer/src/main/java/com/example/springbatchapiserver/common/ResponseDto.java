package com.example.springbatchapiserver.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ResponseDto<T> {


    private boolean success;
    private HttpStatus status;
    private T data;
    private List<String> errorMessage;

    public int getStatus() {
        return this.status.value();
    }

    public static class ResponseDtoBuilder<T>{
        private boolean success;
        private HttpStatus status;
        private T data;
        private List<String> errorMessage;

        public boolean isSuccess() {
            return success;
        }

        public HttpStatus getStatus() {
            return status;
        }

        public T getData() {
            return data;
        }

        public List<String> getErrorMessage() {
            return errorMessage;
        }
    }

}
