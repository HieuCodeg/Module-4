package com.hieucodeg.tudien;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {


        @GetMapping("/")
        public String exchange() {
            return "index";
        }

        @GetMapping("/index")
        public String convert(@RequestParam("english") String english, Model model) {
            Map book = new HashMap<>();
            book.put("english","Tiếng Anh");
            book.put("love","Yêu");
            book.put("happy", "Vui vẻ");
            book.put("hourse", "Nhà");
            String meaning;
            if (book.containsKey(english)) {
                meaning = (String) book.get(english);
            } else {
                meaning = "Chưa cập nhật";
            }
            model.addAttribute("english",english);
            model.addAttribute("meaning",meaning);

            return "index";
        }

}
