package dong.shop.web;

import dong.shop.domain.member.Member;
import dong.shop.domain.member.MemorymemberRepository;
import dong.shop.web.exception.MyHandlerExceptionResolver;
import dong.shop.web.exception.UserHandlerExceptionResolver;
import dong.shop.web.interceptor.LogInterceptor;
import dong.shop.web.interceptor.LoginCheckInterceptor;
import dong.shop.web.interceptor.PageIntercenptor;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
/*        registry.addInterceptor(new LogInterceptor())
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns("/css/**","/*.ico","/error");*/

        registry.addInterceptor(new LoginCheckInterceptor())
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns("/","/css/**","/*.ico","/error","/login/**","/logout","/lib/**","/js/**","/shop/shopList","/scss/**","/img/**","/layout/**");

        registry.addInterceptor(new PageIntercenptor())
                .order(2)
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/css/**",
                        "/*.ico",
                        "/error",
                        "/img/**",
                        "/js/**",
                        "/lib/**",
                        "/scss/**",
                        "/vendor/**"
                        );
    }

    @Override
    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
        resolvers.add(new UserHandlerExceptionResolver());
    }
}
