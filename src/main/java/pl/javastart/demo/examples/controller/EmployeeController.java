package pl.javastart.demo.examples.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.javastart.demo.examples.service.EmployeeService;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Random;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

//    @Autowired(required = false)
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        System.out.println("Wstrzykuję employeeService");
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    void deleteEmployee() {
        employeeService.delete();
        System.out.println("Deleting employee");
    }

    @GetMapping("/save")
//    @PostMapping("/asdf")
//    @DeleteMapping("/asdf")
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

    @RequestMapping("/login")
    String login() {
        return "redirect:/employee/save";
    }
}
