package pl.javastart.demo.examples.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Random;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    void deleteEmployee() {
        System.out.println("Deleting employee");
    }

    @RequestMapping("/save")
    @ResponseBody
    String saveEmployee() {
        System.out.println("Saving employee");
        return "<h1>Employee</h1> with id: " + new Random().nextInt() + " created";
    }

    @RequestMapping("/update")
    String updateEmployee() {
        return "/update.html";
    }

    @RequestMapping("/add")
    @ResponseBody
    String add(@RequestParam String firstName, @RequestParam(required = false, defaultValue = "Nieznany", name = "nazwisko") String surname) {
        return "New employee created: " + firstName + " " + surname;
    }

    @RequestMapping("/headers")
    @ResponseBody
    void headers(HttpServletRequest request) {
        Enumeration<String> headerNames = request.getHeaderNames();

        while (headerNames.hasMoreElements()) {
            String header = headerNames.nextElement();
            String value = request.getHeader(header);
            System.out.println(header + ": " + value);
        }
    }
}
