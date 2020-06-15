package com.atguigu.eduservice.controller;

import com.atguigu.common.utils.ResultResponse;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class LoginController {

    @PostMapping("login")
    public ResultResponse login() {
        return ResultResponse.succeed().data("token", "tokenString");
    }

    @GetMapping("info")
    public ResultResponse info(){
        return ResultResponse.succeed()
                .data("name", "admin")
                .data("roles", "[admin]")
                .data("avatar", "https://oss.aliyuncs.com/aliyun_id_photo_bucket/default_handsome.jpg");
    }

}
