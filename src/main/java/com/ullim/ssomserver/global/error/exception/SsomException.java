package com.ullim.ssomserver.global.error.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SsomException extends RuntimeException{
    private final ErrorProperty errorProperty;
}
