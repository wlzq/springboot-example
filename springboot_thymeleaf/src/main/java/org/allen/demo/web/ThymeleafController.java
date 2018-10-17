package org.allen.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ThymeleafController {

    @GetMapping("/hello")
    public String hello(Model model) {
         model.addAttribute("str", "hello thymeleaf!");
         return "hello";
    }

    @GetMapping("/welcome")
    public String welcome(Model model) {
        //传递字符串
        model.addAttribute("str", "world");
        //传递对象
        Book book = new Book("springboot", 12.3);
        model.addAttribute("book", book);
        //传递集合对象
        List<Book> list = new ArrayList<Book>();
        Book book1 = new Book("book1", 11.1);
        list.add(book1);
        Book book2 = new Book("book2", 22.2);
        list.add(book2);
        Book book3 = new Book("book3", 33.3);
        list.add(book3);
        model.addAttribute("list", list);

        model.addAttribute("id", 5);

        String htmlStr = "<h1>文本替换</h1>";
        model.addAttribute("htmlStr", htmlStr);

        Date currentDate = new Date();
        model.addAttribute("currentDate", currentDate);

        return "welcome";
    }

    class Book {
        private String name;
        private double money;

        public Book(String name, double money){
            this.name = name;
            this.money = money;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getMoney() {
            return money;
        }

        public void setMoney(double money) {
            this.money = money;
        }
    }

}
