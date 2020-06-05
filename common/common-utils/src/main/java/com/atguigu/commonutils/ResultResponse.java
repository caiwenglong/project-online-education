package com.atguigu.commonutils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/*
*  创建结果类
* */
@Data
public class ResultResponse {
    @ApiModelProperty(value = "是否成功")
    private Boolean isSuccess;

    @ApiModelProperty(value = "返回码")
    private Integer code;

    @ApiModelProperty(value = "返回消息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private Map<String, Object> data = new HashMap<String, Object>();

    private ResultResponse(){}

    public static ResultResponse succeed() {
        ResultResponse resultResponse = new ResultResponse();
        resultResponse.setIsSuccess(true);
        resultResponse.setCode(ResultCode.SUCCESS);
        resultResponse.setMessage("成功");
        return resultResponse;
    }

    public static ResultResponse failed() {
        ResultResponse resultResponse = new ResultResponse();
        resultResponse.setIsSuccess(false);
        resultResponse.setCode(ResultCode.ERROR);
        resultResponse.setMessage("失败");
        return resultResponse;
    }

    public ResultResponse success(Boolean success){
        this.setIsSuccess(success);
        return this;
    }

    public ResultResponse message(String message){
        this.setMessage(message);
        return this;
    }

    public ResultResponse code(Integer code){
        this.setCode(code);
        return this;
    }

    public ResultResponse data(String key, Object value){
        this.data.put(key, value);
        return this;
    }

    public ResultResponse data(Map<String, Object> map){
        this.setData(map);
        return this;
    }

}
