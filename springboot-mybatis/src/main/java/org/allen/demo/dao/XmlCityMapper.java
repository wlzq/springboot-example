package org.allen.demo.dao;

import org.allen.demo.domain.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface XmlCityMapper {
    int insert(City city);

    int delete1(Integer id);

    int update1(City city);

    City selectById(@Param("id") Integer id);
}
