package org.allen.demo.domain;

public class City {
    private Long id;
    private String cityName;
    private String cityCode;

    public City(){}

    public City(String cityName, String cityCode){
        this.cityName = cityName;
        this.cityCode = cityCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    @Override
    public String toString() {
        return "{id:"+id+",cityName:"+cityName+",cityCode:"+cityCode+"}";
    }
}
