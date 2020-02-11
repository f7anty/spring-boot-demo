package com.example.demo.service.user.impl;

import com.example.demo.enums.BusinessExceptionEnum;
import com.example.demo.exception.BusinessException;
import com.example.demo.model.sys.SysUser;
import com.example.demo.service.user.LoginService;
import com.example.demo.service.user.SysUserService;
import com.example.demo.util.ShiroUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    SysUserService sysUserService;

    @Override
    public SysUser login(String loginId, String pwd) {
        if(this.userLogin(loginId, pwd)) {
            SysUser sysUser = getCurrentUser();
            if(0 == sysUser.getStatus()){
                throw new BusinessException(BusinessExceptionEnum.USER_IS_DISABLED);
            }
            return sysUser;
        }
        throw new BusinessException(BusinessExceptionEnum.LOGIN_FAILED);
    }

    private boolean userLogin(String loginId, String password) {
        UsernamePasswordToken token = new UsernamePasswordToken(loginId, password);
        token.setRememberMe(false);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return subject.isAuthenticated();
        } catch (LockedAccountException e) {
            throw new BusinessException("1009", token.getPrincipal() + "被锁定");
        } catch (DisabledAccountException e) {
            throw new BusinessException("10010", e.getMessage());
        } catch (ExpiredCredentialsException e) {
            throw new BusinessException("10011", e.getMessage());
        } catch (UnknownAccountException | IncorrectCredentialsException e) {
            throw new BusinessException(BusinessExceptionEnum.USER_NAME_OR_PASSWORD_ERROR);
        } catch (ExcessiveAttemptsException e) {
            throw new BusinessException(BusinessExceptionEnum.USER_RETRY_OVER_LIMIT);
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            System.out.println(e.getMessage());
            throw new BusinessException(BusinessExceptionEnum.LOGIN_FAILED);
        }
    }

    private SysUser getCurrentUser(){
        Integer userId = ShiroUtil.getCurrentUser();
        if(userId == null){
            throw new BusinessException(BusinessExceptionEnum.USER_NOT_LOGIN);
        }
        SysUser sysUser = sysUserService.getById(userId);
        if(sysUser == null){
            throw new BusinessException(BusinessExceptionEnum.USER_NOT_EXIST);
        }
        return sysUser;
    }


}
