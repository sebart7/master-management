package com.mastermanagement.mastermanagement.exception.exceptions;

public class BusinessRuleException extends MasterManagementRunTimeException{

    private static final String FORMAT_EXCEPTION = "%s - Violation business rule: %s";

    private final String businessRule;

    public BusinessRuleException(final String businessRule) {
        super(ErrorCode.BUSINESS_RULE_VIOLATION);
        this.businessRule = businessRule;
    }

    @Override
    public String formatException() {
        return String.format(FORMAT_EXCEPTION, errorCode.getCode(), businessRule);
    }

}