package com.ullim.ssomserver.domain.user.exception.error;

import com.ullim.ssomserver.global.error.exception.ErrorProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserErrorProperty implements ErrorProperty {

    USER_ALREADY_EXISTS(422, "사용자가 이미 존재합니다."),
    USER_NOT_FOUND(404, "사용자가 없습니다."),
    ;

    private final int status;
    private final String message;

}
