package com.yubuqi.controller;


import com.yubuqi.core.base.ResponseResult;
import com.yubuqi.core.pojo.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wenhd
 * @since 2020-06-04
 */
@Controller
@RequestMapping("/user")
@Api(tags = "登录管理接口")
public class UserController implements ErrorController {

    @GetMapping("/login")
    @ApiOperation(value = "登录界面")
    public String tologin(){
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    @ApiOperation(value = "实现登录")
    public ResponseResult login(String username, String password){
        return Response.makeOKRsp();
    }


    @Override
    public String getErrorPath() {
        return null;
    }
}

