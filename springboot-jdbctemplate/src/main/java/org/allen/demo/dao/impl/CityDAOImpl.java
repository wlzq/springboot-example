package org.allen.demo.dao.impl;

import org.allen.demo.dao.CityDAO;
import org.allen.demo.domain.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("cityDAO")
public class CityDAOImpl implements CityDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(City city) {
        String sql = "insert into t_city (cityCode, cityName) values (?, ?)";
        return jdbcTemplate.update(sql, city.getCityCode(), city.getCityName());
    }

    @Override
    public int delete(Long id) {
        String sql = "delete from t_city where id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public int update(City city) {
        String sql = "update t_city set cityCode = ?, cityName = ? where id = ?";
        return jdbcTemplate.update(sql, city.getCityCode(), city.getCityName(), city.getId());
    }

    @Override
    public List<City> findAllCity() {
        String sql = "select * from t_city";
        return jdbcTemplate.query(sql, new Object[]{}, new BeanPropertyRowMapper(City.class));
    }

    @Override
    public City findById(Long id) {
        String sql = "select * from t_city where id = ?";
        List<City> cityList = jdbcTemplate.query(sql, new Object[]{id}, new BeanPropertyRowMapper(City.class));
        if(cityList != null && cityList.size()>0){
            return cityList.get(0);
        }
        return null;
    }
}
