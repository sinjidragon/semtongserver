package com.example.shemtong.domain.user.exception;

import com.example.shemtong.global.exception.IErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public enum UserErrorCode implements IErrorCode {
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "유저를 찾을 수 없습니다."),
    USER_IS_DELETED(HttpStatus.UNAUTHORIZED, "삭제된 유저입니다."),
    USER_UNAUTHORIZED(HttpStatus.BAD_REQUEST, "권한이 없습니다.")
    ;

    public final HttpStatus status;
    public final String description;

    @Override
    public HttpStatus getHttpStatus() {
        return status;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getName() {
        return name();
    }
}
