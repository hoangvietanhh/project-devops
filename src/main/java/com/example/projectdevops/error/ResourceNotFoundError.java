package com.example.projectdevops.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value  = HttpStatus.NOT_FOUND)
public class ResourceNotFoundError extends Exception{
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundError(String errorMsg) {
        super(errorMsg);
    }

}
