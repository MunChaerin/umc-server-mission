package org.example.umcmission.apiPayload.exception.handler;

import org.example.umcmission.apiPayload.code.BaseErrorCode;
import org.example.umcmission.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {
    public TempHandler(BaseErrorCode errorCode){
        super(errorCode);
    }
}
