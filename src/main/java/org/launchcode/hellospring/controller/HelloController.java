package org.launchcode.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller

public class HelloController {
    @ResponseBody
    public static String createMessage(String name, String language) {
        String greeting = "<strong> <font size=36>";
        if (language.equals("english")) {
            greeting += "Hello, " + name + "!";
        } else if (language.equals("spanish")) {
            greeting += "Hola, " + name + "!";
        } else if (language.equals("french")) {
            greeting += "Bonjour, " + name + "!";
        } else if (language.equals("german")) {
            greeting += "Hallo, " + name + "!";
        } else { //language == mandarin
            greeting += "Ni hao, " + name + "!";
        }
        return greeting += "</font></strong>";
    }
    @GetMapping("form")
    public String helloFormWithLanguage(Model model) {


        List<String> languages = new ArrayList<>();
        languages.add("English");
        languages.add("Spanish");
        languages.add("French");
        languages.add("German");
        languages.add("Mandarin");

        model.addAttribute("languages", languages);
        return "form";
    }

    @RequestMapping(method={RequestMethod.GET, RequestMethod.POST}, value="hello")
    public String displayMessage(@RequestParam String name, @RequestParam String language, Model model) {
        HashMap<String, String> greetings = new HashMap<>();
        greetings.put("English", "Hello");
        greetings.put("Spanish", "Hola");
        greetings.put("French", "Bonjour");
        greetings.put("German", "Hallo");
        greetings.put("Mandarin", "Ni hao");

        if (name.equals("")) {
            name = "World";
        }
        model.addAttribute("name", name);
        model.addAttribute("greeting", greetings.get(language));
        return "hello-message";

    }

}
