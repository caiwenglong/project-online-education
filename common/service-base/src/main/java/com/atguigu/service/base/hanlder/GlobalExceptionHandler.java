package com.atguigu.service.base.hanlder;

import com.atguigu.commonutils.ResultResponse;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultResponse errorAll(Exception e){
        e.printStackTrace();
        return ResultResponse.failed().message("全局异常处理");
    }

    @ExceptionHandler(BadSqlGrammarException.class)
    @ResponseBody
    public ResultResponse errorSQL(BadSqlGrammarException e) {
        e.printStackTrace();
        return ResultResponse.failed().message("sql语法错误");
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public ResultResponse errorJson(BadSqlGrammarException e) {
        e.printStackTrace();
        return ResultResponse.failed().message("json解析异常");
    }
}
