package pl.javastart.demo.examples.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.javastart.demo.examples.service.EmployeeService;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Random;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    public PersonController() {
    }
}
