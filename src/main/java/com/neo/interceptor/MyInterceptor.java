package com.neo.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyInterceptor extends WebMvcConfigurerAdapter {

    /**
     * 自定义静态资源
     * @param registry
     */
//	@Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/h/**")
//        .addResourceLocations("classpath:/html/");
//    }
    
    /**
     * 拦截器(用户登录验证)
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**")
	    	.excludePathPatterns("/index/index")
	    	.excludePathPatterns("/getArticlesByStatus")
	    	.excludePathPatterns("/getArticle")
	    	.excludePathPatterns("/mine/problem")
	    	.excludePathPatterns("/mine/problemDetails")
    		.excludePathPatterns("/vest/auditing")
    		.excludePathPatterns("/vest/showModel")
    		.excludePathPatterns("/showModelAndStatus") 
	    	.excludePathPatterns("/console/login")
	    	.excludePathPatterns("/console/logout")
        	.excludePathPatterns("/console/checkLogin");
        super.addInterceptors(registry);
    }
}

