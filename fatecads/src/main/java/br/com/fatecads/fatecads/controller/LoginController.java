package br.com.fatecads.fatecads.controller;
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
 
@Controller
public class LoginController {
@GetMapping("/login")
public String login(){
    return "login";
}
 
@GetMapping("/home")
public String home(){
    System.out.println("passou por aqui");
    return "home";
}
   
}