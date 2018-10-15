package org.allen.demo.domain;

public class City {

    private Long id;
    private String cityCode;
    private String cityName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString(){
        return "{id:"+this.getId()+",cityName:"+this.getCityName()+",cityCode:"+this.getCityCode()+"}";
    }

}
