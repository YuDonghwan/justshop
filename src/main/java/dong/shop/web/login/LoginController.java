package dong.shop.web.login;

import dong.shop.domain.login.LoginService;
import dong.shop.domain.member.Member;
import dong.shop.web.member.MemberSaveDto;
import dong.shop.web.session.SessionConstant;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    //회원가입 화면
    @GetMapping("/signUp")
    public String signUpForm(@Validated @ModelAttribute("member") MemberSaveDto member) {
        return "login/signUp";
    }

    //회원가입 처리
    @PostMapping("/signUp")
    public String addMember(@Validated @ModelAttribute("member") MemberSaveDto member) {


        return "login/signUp";
    }

    //로그인 화면 호출
    @GetMapping
    public String loginForm(@ModelAttribute("loginForm") MemberSaveDto loginForm,HttpServletRequest request) {
        HttpSession session = request.getSession();
        Member sessionMember = (Member) session.getAttribute(SessionConstant.LOGIN_MEMBER.getValue());
        if(null != sessionMember) {
            return "/mypage/info";
        }


        return "login/loginForm";
    }

    @PostMapping
    public String login(@Validated @ModelAttribute("loginForm") MemberSaveDto loginForm, BindingResult bindingResult, HttpServletRequest request, @RequestParam(defaultValue = "/") String redirectURL) {

        Member loginMember = loginService.login(loginForm.getUserId(), loginForm.getPassword());

        if(null == loginMember) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "login/loginForm";
        }
        HttpSession session = request.getSession();

        //세션에 로그인 회원 정보보관
        session.setAttribute(SessionConstant.LOGIN_MEMBER.getValue(),loginMember);
        return "redirect:" + redirectURL;
    }

}
