package com.ullim.ssomserver.global.security.jwt.exception;

import com.ullim.ssomserver.global.error.exception.SsomException;
import com.ullim.ssomserver.global.security.jwt.exception.error.JwtErrorProperty;

public class InvalidTokenException extends SsomException {

    public final static InvalidTokenException EXCEPTION = new InvalidTokenException();

    private InvalidTokenException(){
        super(JwtErrorProperty.INVALID_TOKEN);
    }

}
