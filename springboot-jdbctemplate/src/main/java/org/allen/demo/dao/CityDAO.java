package org.allen.demo.dao;

import org.allen.demo.domain.City;

import java.util.List;

public interface CityDAO {

    int add(City city) throws Exception;

    int delete(Long id) throws Exception;

    int update(City city) throws Exception;

    List<City> findAllCity() throws Exception;

    City findById(Long id) throws Exception;

}
