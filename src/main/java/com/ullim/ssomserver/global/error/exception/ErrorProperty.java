package com.ullim.ssomserver.global.error.exception;

public interface ErrorProperty {
    int getStatus();
    String getMessage();
    String name();
}
