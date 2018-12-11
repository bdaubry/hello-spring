package org.launchcode.hellospring.controllers;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {
    @RequestMapping(value="", method = RequestMethod.GET)
    @ResponseBody
    public String index(){
        String form = "<form method='post'>" +
                "<input type='text' name='name' />" +
                "<select name='lang'>" +
                "<option>English</option>" +
                "<option>French</option>" +
                "<option>Japanese</option>" +
                "<option>German</option>" +
                "<option>Russian</option>" +
                "</select>" +
                "<input type='submit' value='Greet Me!'/>" +
                "</form>";
        return form;
    }

    @RequestMapping(value="", method = RequestMethod.POST)
    @ResponseBody
    public String indexPost(HttpServletRequest request){
        String name = request.getParameter("name");
        String lang = request.getParameter("lang");

        String message = createMessage(lang,name);

        return message;
    }

    public String createMessage(String lang, String name){
        String user = name;
        String hello;

        switch (lang) {
            case "English":
                hello = "Hello";
                break;
            case "French":
                hello = "Bonjour";
                break;
            case "Japanese":
                hello = "Konnichiwa";
                break;
            case "German":
                hello = "Hallo";
                break;
            case "Russian":
                hello = "Cyka Blyat";
                break;
            default:
                hello = "No language imported";
        }
        return hello + " " + user;
    }

}

