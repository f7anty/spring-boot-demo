package com.example.demo.controller;

import com.example.demo.base.BaseResponse;
import com.example.demo.model.sys.SysUser;
import com.example.demo.request.LoginRequest;
import com.example.demo.service.user.LoginService;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Map;

@Controller
public class IndexController {

    @Autowired
    private LoginService loginService;

    @RequestMapping({"/","/index"})
    public String index(){
        return"/index";
    }

    @GetMapping("/login")
    public String login(){
        return "/login";
    }

    @ApiOperation(value = "登录", notes = "")
    @PostMapping("/login")
    @ResponseBody
    public BaseResponse login(@Valid @RequestBody LoginRequest request){
        SysUser sysUser=loginService.login(request.getLoginId(),request.getPassword());
        BaseResponse<SysUser> response=new BaseResponse<>();
        response.setMessage(sysUser);
        return response;
    }

    @RequestMapping("/403")
    public String unauthorizedRole(){
        return "403";
    }

}