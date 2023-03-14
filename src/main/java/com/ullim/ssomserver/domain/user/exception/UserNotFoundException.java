package com.ullim.ssomserver.domain.user.exception;

import com.ullim.ssomserver.domain.user.exception.error.UserErrorProperty;
import com.ullim.ssomserver.global.error.exception.ErrorProperty;
import com.ullim.ssomserver.global.error.exception.SimblueException;

public class UserNotFoundException extends SimblueException {
    public static final UserNotFoundException EXCEPTION = new UserNotFoundException();

    private UserNotFoundException(){
        super(UserErrorProperty.USER_NOT_FOUND);
    }
}
