package org.example.umcmission.apiPayload.exception.handler;

import org.example.umcmission.apiPayload.code.BaseErrorCode;
import org.example.umcmission.apiPayload.exception.GeneralException;

public class MissionHandler extends GeneralException {
    public MissionHandler(BaseErrorCode code){
        super(code);
    }
}
