package com.gooks.blacklabel.common.filter;


import com.gooks.blacklabel.common.utils.mdc.ApiName;
import com.gooks.blacklabel.common.utils.mdc.Hello;
import com.gooks.blacklabel.common.utils.mdc.LogKey;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
@Order(0)
public class LoggingFilter implements Filter {

    public static final String HEADER_ORIGIN = "Origin";
    public static final String HEADER_X_FORWARDED_FOR = "X-Forwarded-For";

    @Override
    public void doFilter(final ServletRequest req, final ServletResponse res, final FilterChain chain) throws IOException, ServletException {
        log.info("[LoggingFilter] doFilter method");
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        //chain.doFilter(req, res);


        //MDC 쓰레드로컬에 추가하고 싶으면 여기에 추가하고 반드시 filter에서 나갈때는
        // remove 필수 나중에 쓰레드 다른 요청이 사용할 경우 데이터 혼합을 방지하기 위함
        addXForwardedFor(request);
        addLogKey(request);
        addHello(request);
        addApiName(request);

        chain.doFilter(req, res);

        removeXForwardedFor();
        removeLogKey();
        removeHello();
        removeApiName();

    }

    private void addXForwardedFor(final HttpServletRequest request) {
        String ip = request.getHeader(HEADER_X_FORWARDED_FOR);
        if (!StringUtils.hasLength(ip)) {
            ip = "";
        }
        MDC.put(HEADER_X_FORWARDED_FOR, ip);
    }

    private void removeXForwardedFor() {
        MDC.remove(HEADER_X_FORWARDED_FOR);
    }

    private void addLogKey(final HttpServletRequest request) {
        LogKey.put(getLogKey(request));
    }

    private void addHello(final HttpServletRequest request) {
        Hello.put("hi nice to meet you");
    }

    private void addApiName(final HttpServletRequest request) {
        ApiName.put(getApiName(request));
    }

    private String getLogKey(final HttpServletRequest request) {
        String logKey = request.getHeader(LogKey.getLogKeyName());
        if (!StringUtils.hasLength(logKey)) {
            logKey = LogKey.createLogKey();
        }
        return logKey;
    }


    private String getApiName(final HttpServletRequest request) {
        String apiName = request.getHeader(ApiName.getApiName());
        if (!StringUtils.hasLength(apiName)) {
            apiName = "";
        }
        return apiName;
    }

    private void removeLogKey() {
        LogKey.remove();
    }
    private void removeHello() {
        Hello.remove();
    }
    private void removeApiName() {
        ApiName.remove();
    }

}
