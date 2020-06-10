package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.ResultResponse;
import com.atguigu.eduservice.entity.EduTeacher;
import com.atguigu.eduservice.entity.vo.TeacherQuery;
import com.atguigu.eduservice.service.EduTeacherService;
import com.atguigu.service.base.config.SwaggerConfig;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation(value = "根据ID查找讲师")
    @GetMapping("get-teacher/{id}")
    public ResultResponse getTeacherById(
            @ApiParam(value = "讲师ID", required = true)
            @PathVariable String id
    ) {
        EduTeacher teacher = teacherService.getById(id);
        return ResultResponse.succeed().data("teacher", teacher);
    }

    @ApiOperation(value = "通过ID删除讲师")
    @DeleteMapping("delete/{id}")
    public ResultResponse removeById(
            @ApiParam(name = "id", value = "传入参数ID", required = true)
            @PathVariable String id) {
        teacherService.removeById(id);
        return ResultResponse.succeed();
    }

    @ApiOperation(value = "通过条件查询数据")
    @GetMapping("{page}/{limit}")
    public ResultResponse pageQuery(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,

            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,

            @ApiParam(name = "teacherQuery", value = "查询对象", required = false)
            TeacherQuery teacherQuery
    ) {
        Page<EduTeacher> pageParam = new Page<>(page, limit);
        teacherService.pageQuery(pageParam, teacherQuery);
        List<EduTeacher> records = pageParam.getRecords();
        long total = pageParam.getTotal();

        return ResultResponse.succeed().data("total", total).data("rows", records);
    }

    @ApiOperation("新增讲师")
    @PostMapping("add-teacher")
    public ResultResponse addTeacher(
            @ApiParam(value = "讲师对象", required = true)
            @RequestBody EduTeacher teacher
    ) {
        boolean result = teacherService.save(teacher);
        if(result) {
            return ResultResponse.succeed().message("保存成功");
        } else {
            return ResultResponse.failed().message("保存失败");
        }
    }

    @ApiOperation("根据ID修改讲师信息")
    @PostMapping("update-teacher")
    public ResultResponse updateById(
            @ApiParam(value = "要修改的讲师对象", required = true)
            @RequestBody EduTeacher teacher
    ){
        boolean result = teacherService.updateById(teacher);
        if(result) {
            return ResultResponse.succeed().message("保存成功");
        } else {
            return ResultResponse.failed().message("保存失败");
        }
    }

    @ApiOperation("全局异常处理测试")
    @GetMapping("exception")
    public ResultResponse exceptionHandleTest(){
        Number a = 1/0;
        return ResultResponse.succeed().message("执行了异常处理测试方法");
    }

}

