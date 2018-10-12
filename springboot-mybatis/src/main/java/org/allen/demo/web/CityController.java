package org.allen.demo.web;

import org.allen.demo.domain.City;
import org.allen.demo.service.AnnotationCityService;
import org.allen.demo.service.XmlCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * web接口方法，使用postman测试
 */
@RestController
@RequestMapping("data/city/mybatis")
public class CityController {

    @Autowired
    private AnnotationCityService annotationCityService;//注解方式

    @Autowired
    private XmlCityService xmlCityService;//xml方式

    @PutMapping
    public String save(@RequestBody City city){
        //annotationCityService.insert(city);
        xmlCityService.insert(city);
        return "success";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        //annotationCityService.delete(id);
        xmlCityService.delete1(id);
        return "success";
    }

    @PostMapping
    public String update(@RequestBody City city){
        //annotationCityService.update(city);
        xmlCityService.update1(city);
        return "success";
    }

    @GetMapping("/{id}")
    public City findById(@PathVariable Integer id){
        //City city = annotationCityService.selectById(id);
        City city = xmlCityService.selectById(id);
        return city;
    }

}
