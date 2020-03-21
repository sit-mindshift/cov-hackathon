package com.sit.cov.hackatron.backend.resource.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class StoreImportException extends RuntimeException {
    public StoreImportException(String s) {
        super(s);
    }
}
