package com.ullim.ssomserver.domain.user.exception;

import com.ullim.ssomserver.domain.user.exception.error.UserErrorProperty;
import com.ullim.ssomserver.global.error.exception.SsomException;

public class UserNotFoundException extends SsomException {
    public static final UserNotFoundException EXCEPTION = new UserNotFoundException();

    private UserNotFoundException(){
        super(UserErrorProperty.USER_NOT_FOUND);
    }
}
