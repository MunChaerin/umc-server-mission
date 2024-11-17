package org.example.umcmission.apiPayload.exception.handler;

import org.example.umcmission.apiPayload.code.BaseErrorCode;
import org.example.umcmission.apiPayload.exception.GeneralException;

public class MemberHandler extends GeneralException {
    public MemberHandler (BaseErrorCode code){
        super(code);
    }
}
