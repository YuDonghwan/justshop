package dong.shop.web.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Slf4j
public class LogInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("LogInterceptor.prehandle");

        String uuid = UUID.randomUUID().toString();
        request.setAttribute("uuid",uuid);
        log.info("REQUEST [{}] [{}]",uuid,request.getRequestURI());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        String uuid = (String) request.getAttribute("uuid");
        log.info("LogInterceptor.postHandle");
        log.info("REQUEST [{}] [{}]",uuid,request.getRequestURI());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("LogInterceptor.afterCompletion");

        String uuid = (String) request.getAttribute("uuid");
        log.info("RESPONSE [{}] [{}]",uuid,request.getRequestURI());
    }
}
