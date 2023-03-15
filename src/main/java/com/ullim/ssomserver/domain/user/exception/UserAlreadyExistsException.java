package com.ullim.ssomserver.domain.user.exception;

import com.ullim.ssomserver.domain.user.exception.error.UserErrorProperty;
import com.ullim.ssomserver.global.error.exception.SimblueException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAlreadyExistsException extends SimblueException {

    public final static UserAlreadyExistsException EXCEPTION = new UserAlreadyExistsException();

    private UserAlreadyExistsException(){
        super(UserErrorProperty.USER_ALREADY_EXISTS);
    }

}
