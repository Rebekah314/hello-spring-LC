package org.launchcode.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
public class HelloController {

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
    public String helloFormWithLanguage() {
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" +
                "<input type='text' name='name'>" +
                "<select name='language'>" +
                "<option value='english'>English</option>" +
                "<option value='spanish'>Spanish</option>" +
                "<option value='french'>French</option>" +
                "<option value='german'>German</option>" +
                "<option value='mandarin'>Mandarin</option>" +
                "</select>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    @RequestMapping(method={RequestMethod.GET, RequestMethod.POST}, value="hello")
    public String displayMessage(@RequestParam String name, @RequestParam String language) {
        if (name.equals("")) {
            name = "World";
        }
        return createMessage(name, language);

    }

}
