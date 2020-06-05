package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.ResultResponse;
import com.atguigu.eduservice.entity.EduTeacher;
import com.atguigu.eduservice.service.EduTeacherService;
import com.atguigu.servicebase.config.SwaggerConfig;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
    public ResultResponse list(){
        List<EduTeacher> list = teacherService.list(null);
        return ResultResponse.succeed().data("items", list);
    }

    @ApiOperation(value = "通过讲师ID查找讲师")
    @GetMapping("delete/{id}")
    public ResultResponse removeById(
            @ApiParam(name = "id", value = "传入参数ID", required = true)
            @PathVariable String id) {
        teacherService.removeById(id);
        return ResultResponse.succeed();
    }

    @ApiOperation(value = "分页讲师列表")
    @GetMapping("{page}/{limit}")
    public ResultResponse pageList(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,

            @ApiParam(name = "limit", value = "每页条数", required = true)
            @PathVariable Long limit
    ){
        Page<EduTeacher> pageParam = new Page<>(page, limit);
        teacherService.page(pageParam, null);
        List<EduTeacher> records = pageParam.getRecords();
        long total = pageParam.getTotal();
        return  ResultResponse.succeed().data("total", total).data("rows", records);
    }

}

