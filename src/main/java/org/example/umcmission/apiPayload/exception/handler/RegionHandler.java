package org.example.umcmission.apiPayload.exception.handler;

import org.example.umcmission.apiPayload.code.BaseErrorCode;
import org.example.umcmission.apiPayload.exception.GeneralException;

public class RegionHandler extends GeneralException {
    public RegionHandler (BaseErrorCode code){
        super(code);
    }
}
