package com.ullim.ssomserver.global.security.jwt.exception;

import com.ullim.ssomserver.global.error.exception.SimblueException;
import com.ullim.ssomserver.global.security.jwt.exception.error.JwtErrorProperty;

public class ExpiredTokenException extends SimblueException {

    public final static ExpiredTokenException EXCEPTION = new ExpiredTokenException();

    private ExpiredTokenException(){
        super(JwtErrorProperty.EXPIRED_TOKEN);
    }

}
