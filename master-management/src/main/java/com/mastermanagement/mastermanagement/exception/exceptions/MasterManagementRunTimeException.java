package com.mastermanagement.mastermanagement.exception.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public abstract class MasterManagementRunTimeException extends RuntimeException{

    protected ErrorCode errorCode;

    public abstract String formatException();
}
