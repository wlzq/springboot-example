package org.allen.demo.dao.dbOne;

import org.allen.demo.domain.City;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CityOneMapper {

    @Insert("insert into t_city(cityCode, cityName) values(#{cityCode},#{cityName})")
    int insert(City city);

    @Delete("delete from t_city where id = #{id}")
    int delete(Integer id);

    @Update("update t_city set cityName = #{cityName} where cityCode = #{cityCode}")
    int update(City city);

    @Select("select * from t_city where id = #{id}")
    City selectById(@Param("id") Integer id);

}
