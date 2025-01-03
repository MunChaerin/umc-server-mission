package org.example.umcmission.apiPayload.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.umcmission.apiPayload.code.BaseErrorCode;
import org.example.umcmission.apiPayload.code.ErrorReasonDTO;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {

    // 가장 일반적인 응답
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의 바랍니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST,"COMMON400","잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED,"COMMON401","인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다."),


    // 멤버 관려 에러
    MEMBER_NOT_FOUND(HttpStatus.BAD_REQUEST, "MEMBER4001", "사용자가 없습니다."),
    NICKNAME_NOT_EXIST(HttpStatus.BAD_REQUEST, "MEMBER4002", "닉네임은 필수 입니다."),

    ARTICLE_NOT_FOUND(HttpStatus.NOT_FOUND, "ARTICLE4001", "게시글이 없습니다."),
    TEMP_EXCEPTION(HttpStatus.BAD_REQUEST, "TEMP4001", "테스트"),

    FOOD_CATEGORY_NOT_FOUND(HttpStatus.NOT_FOUND, "FOODCATEGORY404", "해당 카테고리가 존재하지 않습니다."),

    //지역 관련 에러
    REGION_NOT_FOUND(HttpStatus.NOT_FOUND,"REGION400", "해당 지역이 존재하지 않습니다."),

    //가게 관련 에러
    STORE_NOT_FOUND(HttpStatus.NOT_FOUND,"STORE400", "해당 가게가 존재하지 않습니다."),

    //미션 관련 에러
    MISSION_ALREADY_CHALLENGING(HttpStatus.BAD_REQUEST,"MISSION401","이미 진행 중인 미션입니다."),
    MISSION_NOT_FOUND(HttpStatus.NOT_FOUND,"MISSION400","해당 미션이 존재하지 않습니다.")
    ;


    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build();
    }
}
