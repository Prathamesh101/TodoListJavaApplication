package com.example.TodoApp.LoginController.LoginService;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
        public boolean authenticate(String name, String password){
            return name.equalsIgnoreCase("dummy") && password.equalsIgnoreCase("pass");
        }
}
