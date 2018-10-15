package org.allen.demo.service;

import org.allen.demo.dao.dbOne.CityOneMapper;
import org.allen.demo.domain.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("cityOneService")
public class CityOneService implements CityOneMapper {

    @Autowired
    private CityOneMapper cityOneMapper;

    @Override
    public int insert(City city) {
        return cityOneMapper.insert(city);
    }

    @Override
    public int delete(Integer id) {
        return cityOneMapper.delete(id);
    }

    @Override
    public int update(City city) {
        return cityOneMapper.update(city);
    }

    @Override
    public City selectById(Integer id) {
        return cityOneMapper.selectById(id);
    }
}
