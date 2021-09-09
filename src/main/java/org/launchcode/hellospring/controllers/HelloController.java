package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
//@ResponseBody
@RequestMapping("hello")
public class HelloController {

//    @GetMapping
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }

    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring!";
    }

//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
//    public String helloWithQueryParam(@RequestParam String name) {
//        return "Hello, " + name + "!";
//    }
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String helloPost(@RequestParam String name, @RequestParam String language) {
        if(name == null){
        name = "world";
        }

        return createMessage(name,language);
    }

    public static String createMessage(String aName,String aLanguage) {
        String greeting = "";
        if (aLanguage.equalsIgnoreCase("english")) {
            greeting = "Hello";
        } else if (aLanguage.equalsIgnoreCase("tamil")) {
            greeting = "Vanakkam";
        } else if (aLanguage.equalsIgnoreCase("hindi")) {
            greeting = "Namaste";
        } else if (aLanguage.equalsIgnoreCase("french")) {
            greeting = "Bonjour";
        } else if (aLanguage.equalsIgnoreCase("spanish")) {
            greeting = "Hola";
        }
        return greeting + " , "+ aName + "!";
    }

    @GetMapping("{name}")
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello , " + name + "!";
    }

    // /hello/form
    @GetMapping("form")
    public String helloForm() {
        return "form";
    }




}
