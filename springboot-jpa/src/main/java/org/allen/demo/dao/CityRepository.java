package org.allen.demo.dao;

import org.allen.demo.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {

    /**
     * 查询所有
     * @return
     */
    List<City> findAll();

    /**
     * 根据编码查询
     * @param cityCode
     * @return
     */
    @Query("from City where cityCode = :cityCode")
    City findByCityCode(@Param("cityCode") String cityCode);
}
