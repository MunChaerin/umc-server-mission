package org.example.umcmission.apiPayload.exception.handler;

import org.example.umcmission.apiPayload.code.BaseErrorCode;
import org.example.umcmission.apiPayload.exception.GeneralException;

public class StoreHandler extends GeneralException {
    public StoreHandler (BaseErrorCode code){
        super(code);
    }
}
