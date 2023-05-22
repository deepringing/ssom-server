package com.ullim.ssomserver.domain.user.exception;

import com.ullim.ssomserver.domain.user.exception.error.UserErrorProperty;
import com.ullim.ssomserver.global.error.exception.SsomException;

public class UserAlreadyExistsException extends SsomException {

    public final static UserAlreadyExistsException EXCEPTION = new UserAlreadyExistsException();

    private UserAlreadyExistsException() {
        super(UserErrorProperty.USER_ALREADY_EXISTS);
    }
}