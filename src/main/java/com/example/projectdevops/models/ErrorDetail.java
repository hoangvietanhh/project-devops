package com.example.projectdevops.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetail {

    private Date timestamp;
    private String errorMessage;
    private String errorDetails;
}
