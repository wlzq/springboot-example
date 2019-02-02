package org.allen.demo.contorller;

import org.allen.demo.entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 * @author wl
 * @version V1.0
 * @Description TODO
 * @date 2019-01-21 16:09
 */
@Controller
public class TestController {

    @GetMapping("/info")
    public String info(Model model){
        Person person = new Person();
        model.addAttribute("person", person);
        return "person_info.html";
    }

    @PostMapping("/save")
    public String save(@Valid Person person, BindingResult result, Model model){
        if (result.hasErrors()) {
            model.addAttribute("person", person);
            return "person_info.html";
        }
        model.addAttribute("success","校验通过，数据已保存");
        return "success.html";
    }

}
