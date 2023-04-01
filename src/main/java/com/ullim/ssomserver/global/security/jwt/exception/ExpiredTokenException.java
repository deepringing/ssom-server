package com.ullim.ssomserver.global.security.jwt.exception;

import com.ullim.ssomserver.global.error.exception.SsomException;
import com.ullim.ssomserver.global.security.jwt.exception.error.JwtErrorProperty;

public class ExpiredTokenException extends SsomException {

    public final static ExpiredTokenException EXCEPTION = new ExpiredTokenException();

    private ExpiredTokenException(){
        super(JwtErrorProperty.EXPIRED_TOKEN);
    }

}
