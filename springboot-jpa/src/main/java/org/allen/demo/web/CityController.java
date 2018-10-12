package org.allen.demo.web;

import org.allen.demo.domain.City;
import org.allen.demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/datas/jpa/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/list")
    public List<City> findAll(){
        List<City> cityList = cityService.findAll();
        return cityList;
    }

    @GetMapping("/code")
    public City findByCode(@RequestParam("cityCode") String cityCode){
        City city = cityService.findByCityCode(cityCode);
        return city;
    }

}
