package org.example.umcmission.apiPayload.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.umcmission.apiPayload.code.BaseErrorCode;
import org.example.umcmission.apiPayload.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {

    private BaseErrorCode code;

    public ErrorReasonDTO getErrorReason() {
        return this.code.getReason();
    }

    public ErrorReasonDTO getErrorReasonHttpStatus(){
        return this.code.getReasonHttpStatus();
    }
}
