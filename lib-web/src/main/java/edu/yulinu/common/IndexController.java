package edu.yulinu.common;

import edu.yulinu.bean.UserAndPasswordRequest;
import edu.yulinu.common.utils.ResponseWarp;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: libmanage
 * @description:
 * @author: Xiaodong
 * @date: 2020-04-19 07:18
 **/
@RestController
@RequestMapping("/common")
public class IndexController extends BaseController{
    @PostMapping("/login")
    public ResponseWarp login(@RequestBody UserAndPasswordRequest user ){
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getUsername(), user.getPassword());

        try{
            SecurityUtils.getSubject().login(usernamePasswordToken);
            return success("login success");
        }catch (UnknownAccountException e){
            return fail("1002",e.getMessage());
        }catch (IncorrectCredentialsException e){
            return fail("1003",e.getMessage());
        }
    }
}
