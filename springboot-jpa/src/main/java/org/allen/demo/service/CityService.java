package org.allen.demo.service;

import org.allen.demo.dao.CityRepository;
import org.allen.demo.domain.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public List<City> findAll(){
        return cityRepository.findAll();
    }

    public City findByCityCode(String cityCode){
        return cityRepository.findByCityCode(cityCode);
    }

}
