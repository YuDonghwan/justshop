package dong.shop.web.exception;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class ServletExController {


    @GetMapping("/error/404")
    public void error404(HttpServletResponse response) throws IOException {
        response.sendError(404,"404에러!");
    }
    @GetMapping("/error/400")
    public void error400(HttpServletResponse response) throws IOException {
        response.sendError(400,"400에러!");
    }
    @GetMapping("/error/500")
    public void error500(HttpServletResponse response) throws IOException {
        response.sendError(500,"500에러!");
    }

    @GetMapping("/error/arg-ex")
    public void errorArg(HttpServletResponse response) throws IOException {
        throw new IllegalArgumentException("인자 에러");
    }
}
