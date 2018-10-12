package org.allen.demo.service;

import org.allen.demo.dao.AnnotationCityMapper;
import org.allen.demo.domain.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("annotationCityService")
public class AnnotationCityService implements AnnotationCityMapper {

    @Autowired
    private AnnotationCityMapper annotationCityMapper;

    @Override
    public int insert(City city) {
        return annotationCityMapper.insert(city);
    }

    @Override
    public int delete(Integer id) {
        return annotationCityMapper.delete(id);
    }

    @Override
    public int update(City city) {
        return annotationCityMapper.update(city);
    }

    @Override
    public City selectById(Integer id) {
        return annotationCityMapper.selectById(id);
    }
}
