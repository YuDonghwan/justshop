package dong.shop.web.interceptor;

import dong.shop.domain.member.Member;
import dong.shop.web.session.SessionConstant;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
public class PageIntercenptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();

/*
        if(null == session || null == session.getAttribute(SessionConstant.LOGIN_MEMBER.getValue())) {
            return false;
        }
*/

        Member member = (Member) session.getAttribute(SessionConstant.LOGIN_MEMBER.getValue());
        if(null != member) {
            request.setAttribute("loginMemberId", member.getId());
        }

        return true;
    }
}
