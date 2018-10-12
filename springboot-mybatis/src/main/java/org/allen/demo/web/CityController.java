package org.allen.demo.web;

import org.allen.demo.doamin.City;
import org.allen.demo.service.AnnotationCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * web接口方法，使用postman测试
 */
@RestController
@RequestMapping("data/city/mybatis")
public class CityController {

    @Autowired
    private AnnotationCityService annotationCityService;

    @PutMapping
    public String save(@RequestBody City city){
        annotationCityService.insert(city);
        return "success";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        annotationCityService.delete(id);
        return "success";
    }

    @PostMapping
    public String update(@RequestBody City city){
        annotationCityService.update(city);
        return "success";
    }

    @GetMapping("/{id}")
    public City findById(@PathVariable Integer id){
        City city = annotationCityService.selectById(id);
        return city;
    }

}
