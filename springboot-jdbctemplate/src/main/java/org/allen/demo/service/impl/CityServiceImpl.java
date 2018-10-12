package org.allen.demo.service.impl;

import org.allen.demo.dao.CityDAO;
import org.allen.demo.domain.City;
import org.allen.demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("cityService")
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDAO cityDAO;

    @Override
    public int add(City city) throws Exception {
        return cityDAO.add(city);
    }

    @Override
    public int delete(Long id) throws Exception {
        return cityDAO.delete(id);
    }

    @Override
    public int update(City city) throws Exception {
        return cityDAO.update(city);
    }

    @Override
    public List<City> findAllCity() throws Exception {
        return cityDAO.findAllCity();
    }

    @Override
    public City findById(Long id) throws Exception {
        return cityDAO.findById(id);
    }
}
