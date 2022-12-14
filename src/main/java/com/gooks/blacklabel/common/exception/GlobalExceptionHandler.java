package com.gooks.blacklabel.common.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gooks.blacklabel.common.exception.messege.ErrorCode;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import java.util.Arrays;
import java.util.List;

/**
 * 전역 에러처리 핸들러
 */
@Slf4j(topic = "GLOBAL_EXCEPTION_HANDLER")
@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class GlobalExceptionHandler {
    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 어플리케이션 표준 에러 처리
     * @see ApiException
     */
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ErrorResponse> handleException(ApiException e) {
        return buildResponse(e, e.getErrorCode(), e.getDetail(), e.getMessage());
    }



    private ResponseEntity<ErrorResponse> buildResponse(Throwable e, ErrorCode ec, List<String> detail, String clientMessage) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String uri = request.getRequestURI();

        //ExchangeResult.put(ec.getHttpStatus().name());
        //ExchangeMessage.put(ec.getMessage() + "(" + e.getMessage() + ")");

        ResponseEntity<ErrorResponse> responseEntity = ResponseEntity
                .status(ec.getHttpStatus())
                .body(new ErrorResponse(ec, detail, clientMessage));
        try {
            log.error("***** CLIENT RESPONSE[API_ERROR] ***** [URL : {}, REASON({}) : {}({}), RESPONSE : {}]", uri, ec.getHttpStatus(), ec.getMessage(), e.getMessage(), objectMapper.writeValueAsString(responseEntity), e);
        } catch (JsonProcessingException e1) {
            log.error("***** CLIENT RESPONSE[API_ERROR] ***** [URL : {}, REASON({}) : {}({}), RESPONSE : {}]", uri, ec.getHttpStatus(), ec.getMessage(), e.getMessage(), e1.getMessage(), e);
        }

        return responseEntity;
    }


















    /**
     * 에러 응답 표준 객체
     */
    @Getter
    @JsonInclude(JsonInclude.Include.NON_NULL) // Todo Null 값을 포함시킬지 논의 필요
    class ErrorResponse {
        private String code;
        private String message;
        private String clientMessage;
        private List<String> detail;

        public ErrorResponse(ErrorCode errorCode) {
            this(errorCode, null);
        }

        public ErrorResponse(ErrorCode ec, List<String> detail) {
            this.code = "FAILED";
            this.message = ec.getMessage();
            this.detail = detail;
            this.clientMessage = "해당 요청을 처리하는 중에 오류가 발생하였습니다.";
        }

        public ErrorResponse(ErrorCode ec, List<String> detail, String clientMessage) {
            this.code = "FAILED";
            this.message = ec.getMessage();
            this.detail = detail;
            this.clientMessage = clientMessage;
        }
    }

}
