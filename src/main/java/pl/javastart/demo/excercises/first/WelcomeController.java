package pl.javastart.demo.excercises.first;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class WelcomeController {

    @RequestMapping("/testy/test1")
    @ResponseBody
    String welcome(HttpServletRequest request) {
        String ip = request.getRemoteAddr();

        System.out.println("IP użytkownika to: " + ip);

        return "Cześć tutaj Marcin. Wszystko działa!";
    }
}
