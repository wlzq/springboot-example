package org.allen.demo.service;

import org.allen.demo.dao.dbOne.CityOneMapper;
import org.allen.demo.dao.dbTwo.CityTwoMapper;
import org.allen.demo.domain.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("cityService")
public class CityTwoService implements CityTwoMapper {

    @Autowired
    private CityTwoMapper cityTwoMapper;

    @Override
    public int insert(City city) {
        return cityTwoMapper.insert(city);
    }

    @Override
    public int delete(Integer id) {
        return cityTwoMapper.delete(id);
    }

    @Override
    public int update(City city) {
        return cityTwoMapper.update(city);
    }

    @Override
    public City selectById(Integer id) {
        return cityTwoMapper.selectById(id);
    }
}
