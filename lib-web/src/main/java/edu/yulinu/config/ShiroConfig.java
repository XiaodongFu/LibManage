package edu.yulinu.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @program: libmanage
 * @description:
 * @author: Xiaodong
 * @date: 2020-04-18 15:20
 **/
@Configuration
public class ShiroConfig {
//    subject   用户
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManage") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(securityManager);

//        设置过滤器
        HashMap<String, String> filterMap = new LinkedHashMap<>();

//        认证拦截
        filterMap.put("/teacher/*","anon");
        filterMap.put("/student/*","anon");

//        授权拦截
//        filterMap.put("/teacher/course/*","perms[teacher]");

        factoryBean.setUnauthorizedUrl("/common/toAuth");
        factoryBean.setLoginUrl("/common/toLogin");
        factoryBean.setFilterChainDefinitionMap(filterMap);

        return factoryBean;
    }
//    securityManage    用户管理
    @Bean(name = "securityManage")
    public DefaultWebSecurityManager getDefaultSecurityManage(@Qualifier("userRealm")UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }
//    realm   连接资源
    @Bean(name = "userRealm")
    public UserRealm userRealm(){
        return new UserRealm();
    }

}
