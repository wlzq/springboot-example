package org.allen.demo.service;

import org.allen.demo.dao.XmlCityMapper;
import org.allen.demo.domain.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("xmlCityService")
public class XmlCityService implements XmlCityMapper {

    @Autowired
    private XmlCityMapper xmlCityMapper;

    @Override
    public int insert(City city) {
        return xmlCityMapper.insert(city);
    }

    @Override
    public int delete1(Integer id) {
        return xmlCityMapper.delete1(id);
    }

    @Override
    public int update1(City city) {
        return xmlCityMapper.update1(city);
    }

    @Override
    public City selectById(Integer id) {
        return xmlCityMapper.selectById(id);
    }
}
