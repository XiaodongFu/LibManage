package edu.yulinu.config;

import edu.yulinu.common.domain.UserBean;
import edu.yulinu.teacher.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: libmanage
 * @description:
 * @author: Xiaodong
 * @date: 2020-04-18 15:25
 **/
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

//    授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        System.out.println("授权方法");

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        UserBean user = (UserBean) SecurityUtils.getSubject().getPrincipal();
        info.addStringPermission(user.getPermission());

        return info;
    }

//    认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//        System.out.println("认证方法");
        UsernamePasswordToken usertoken = (UsernamePasswordToken) token;
        UserBean byName = userService.findByName(usertoken.getUsername());
        if(null==byName) return null;
        if(!(usertoken.getUsername().equals(byName.getUserName()))) return null;
        return new SimpleAuthenticationInfo(byName,byName.getPassword(),"");
    }
}
