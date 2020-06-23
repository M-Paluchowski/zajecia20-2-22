package pl.javastart.demo.examples.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
@RequestMapping("/employee")
public class HelloController {

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
}
