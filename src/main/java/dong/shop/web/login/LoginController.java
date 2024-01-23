package dong.shop.web.login;

import dong.shop.login.LoginService;
import dong.shop.member.Member;
import dong.shop.member.MemberService;
import dong.shop.member.MemorymemberRepository;
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
    @GetMapping("/signUpForm")
    public String signUpForm() {
        return "login/signUpForm";
    }

    //로그인 화면 호출
    @GetMapping
    public String loginForm(@ModelAttribute("loginForm") MemberSaveDto loginForm) {
        return "login/loginForm";
    }

    @PostMapping
    public String login(@Validated @ModelAttribute MemberSaveDto member, BindingResult bindingResult, HttpServletRequest request, @RequestParam(defaultValue = "/") String redirectURL) {

        Member loginMember = loginService.login(member.getUserId(), member.getPassword());

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
