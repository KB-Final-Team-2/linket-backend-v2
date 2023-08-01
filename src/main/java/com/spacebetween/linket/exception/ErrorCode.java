package com.spacebetween.linket.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {

    // 400 BAD_REQUEST 잘못된 요청
    // 회원 정보 관련
    INVALID_PASSWORD(400, "잘못된 비밀번호 값이 입력되었습니다."),
    INVALID_PARAMETER(400, "파라미터 값을 확인해 주세요."),
    NOT_EQUAL_PASSWORD(400, "비밀번호가 서로 일치하지 않습니다."),

    // 등록
    FILE_UPLOAD_ERROR(400, "파일 업로드 에러"),
    EVENT_UPLOAD_ERROR(400, "행사 등록 에러"),
    TICKET_UPLOAD_ERROR(400, "티켓 등록 에러"),
    HIRE_UPLOAD_ERROR(400, "채용공고 등록 에러"),
    REVIEW_UPLOAD_ERROR(400, "리뷰 등록 에러"),
    NOTICE_UPLOAD_ERROR(400, "공지사항 등록 에러"),

    // 401
    CANNOT_MODIFY_USER(401, "회원 정보를 수정할 권한이 없습니다."),
    CANNOT_MODIFY_EVENT(401, "행사 정보를 수정할 권한이 없습니다."),
    CANNOT_MODIFY_TICKET(401, " 티켓 정보를 수정할 권한이 없습니다."),
    CANNOT_MODIFY_NOTICE(401, " 공지 정보를 수정할 권한이 없습니다."),
    CANNOT_ADD_HIRE(401, " 채용 공고를 추가할 권한이 없습니다."),

    MAIL_CODE_ERROR(401, "메일 인증 실패"),

    // 404 NOT FOUND 잘못된 리소스 접근
    USER_NOT_FOUND(404, "존재하지 않은 회원 Email 입니다."),
    EVENT_NOT_FOUND(404, "존재하지 않는 행사입니다."),
    TICKET_NOT_FOUND(404, "존재하지 않는 티켓입니다."),
    IMAGE_NOT_FOUND(404, "존재하지 않는 이미지입니다."),
    HIRE_NOT_FOUND(404, "존재하지 않는 채용공고입니다."),
    NOTICE_NOT_FOUND(404, "존재하지 않는 공지사항입니다."),
    COMPANY_NOT_FOUND(404, "존재하지 않는 기업입니다."),

    //409 CONFLICT 중복된 리소스
    ALREADY_SAVED_USER(409, "이미 가입되어 있는 회원입니다."), // 이메일 값으로 확인
    ALREADY_SAVED_TICKET(409, "이미 등록된 티켓입니다."),
    ALREADY_SAVED_EVENT(409, "이미 등록된 행사입니다."),
    ALREADY_SAVED_COMPANY(409, "이미 등록된 기업입니다."),
    ALREADY_UPLOAD_NOTICE(409, "이미 등록된 공지사항입니다."),
    ALREADY_UPLOAD_REVIEW(409, "이미 작성된 리뷰가 존재합니다."),

    MAIL_ERROR(421, "메일 오류"),

    //500 INTERNAL SERVER ERROR
    INTERNAL_SERVER_ERROR(500, "서버 에러입니다. 서버팀에 문의주시기 바랍니다.");

    private final int status;
    private final String message;
}