package com.wengxs.cloud.web.handler;

import com.wengxs.cloud.core.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by Zorg
 * 2021/3/15 下午6:59
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public R<?> exception(Exception e) {
        log.error(e.getMessage(), e);
        return R.fail(e);
    }
}
