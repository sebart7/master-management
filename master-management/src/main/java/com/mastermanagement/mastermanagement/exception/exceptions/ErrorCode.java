package com.mastermanagement.mastermanagement.exception.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ErrorCode {

    GENERIC_ERROR("GC-0001", "GENERIC_ERROR"),
    ENTITY_EXIST("GC-0002", "ENTITY_ALREADY_EXISTS"),
    ENTITY_NOT_EXIST("GC-0003", "ENTITY_NOT_FOUND"),
    BUSINESS_RULE_VIOLATION("GC-0004", "BUSINESS_RULE_VIOLATION");


    private final String code;
    private final String messageKey;
}

