package org.allen.demo.web;

import com.alibaba.fastjson.JSONObject;
import org.allen.demo.domain.City;
import org.allen.demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/datas/city/jdbc")
public class CityController {

    @Autowired
    private CityService cityService;

    @PutMapping
    public String add(@RequestBody JSONObject jsonObject){
        String cityCode = jsonObject.getString("cityCode");
        String cityName = jsonObject.getString("cityName");
        City city = new City(cityName, cityCode);
        try {
            cityService.add(city);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        try {
            cityService.delete(id);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @PostMapping
    public String update(@RequestBody JSONObject jsonObject){
        Long id = jsonObject.getLong("id");
        try {
            City city = cityService.findById(id);
            if(city != null){
                String cityCode = jsonObject.getString("cityCode");
                city.setCityCode(cityCode);
                String cityName = jsonObject.getString("cityName");
                city.setCityName(cityName);
                cityService.update(city);
                return "success";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "fail";
    }

    @GetMapping("/list")
    public String list(){
        try {
            List<City> cityList =  cityService.findAllCity();
            return cityList.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
