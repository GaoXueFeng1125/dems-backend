package edu.sugon.demsbackend.common;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@ResponseBody
public class RestExceptionHandler {
    /**
     * 异常处理
     */
    @ExceptionHandler(Exception.class)
    public Result<String> exception(Exception e){
        return Result.error(e.getLocalizedMessage());
    }
}
