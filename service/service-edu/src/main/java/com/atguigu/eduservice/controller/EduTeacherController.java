package com.atguigu.eduservice.controller;


import com.atguigu.eduservice.entity.EduTeacher;
import com.atguigu.eduservice.service.EduTeacherService;
import com.atguigu.servicebase.config.SwaggerConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-06-04
 */
@Api(tags = { SwaggerConfig.TAG_1 })
@RestController
@RequestMapping("/eduservice/edu-teacher")
public class EduTeacherController {

    @Autowired
    private EduTeacherService teacherService;

    @ApiOperation(value = "查找所有的讲师")
    @GetMapping("findAll")
    public List<EduTeacher> list(){
        return teacherService.list(null);
    }

    @ApiOperation(value = "通过讲师ID查找讲师")
    @GetMapping("delete/{id}")
    public boolean removeById(
            @ApiParam(name = "id", value = "传入参数ID", required = true)
            @PathVariable String id) {
        return teacherService.removeById(id);
    }

}

