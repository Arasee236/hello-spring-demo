package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

//    @GetMapping
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }

    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
//    public String helloWithQueryParam(@RequestParam String name) {
//        return "Hello, " + name + "!";
//    }
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
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
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello , " + name + "!";
    }

    // /hello/form
    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action = '/hello' method = 'post'>" + // submit a request to /hello
                "<input type = 'text' name = 'name' >" +
                "<select name='language' id ='language'>" +
                "<option value = 'English'> English </option>"+
                "<option value = 'Tamil'> Tamil </option>"+
                "<option value = 'Spanish'> Spanish </option>"+
                "<option value = 'Hindi'> Hindi </option>"+
                "<option value = 'French'> French </option>"+
                "</select>" +
                "<input type = 'submit' value = 'Greet Me!' >" +
                "</form>" +
                "</body>" +
                "</html>";
    }




}
