package pl.javastart.demo.examples.service;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    public void save() {
        System.out.println("Zapisałem użytkownika");
    }

    public void delete() {
        System.out.println("Usunalem użytkownika");
    }
}
