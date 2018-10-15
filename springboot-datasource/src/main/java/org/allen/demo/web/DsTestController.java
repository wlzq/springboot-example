package org.allen.demo.web;

import org.allen.demo.domain.City;
import org.allen.demo.service.CityOneService;
import org.allen.demo.service.CityTwoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DsTestController {

    @Autowired
    private CityOneService cityOneService;

    @Autowired
    private CityTwoService cityTwoService;

    @GetMapping("/{id}")
    public List<City> getCityById(@PathVariable("id") int id){
        System.out.println("查询数据，id="+id);
        List<City> cityList = new ArrayList<City>();
        //查询数据库1的数据
        City city1 = cityOneService.selectById(id);
        cityList.add(city1);
        //查询数据库2的数据
        City city2 = cityTwoService.selectById(id);
        cityList.add(city2);
        return cityList;
    }

}
