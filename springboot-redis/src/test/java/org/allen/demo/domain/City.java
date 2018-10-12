package org.allen.demo.domain;

import java.io.Serializable;

public class City implements Serializable {

    private static final long serialVersionUID = 9074661694860096561L;

    private Integer id;
    private String citeCode;
    private String cityName;

    public City() {}

    public City(Integer id, String citeCode, String cityName) {
        this.id = id;
        this.citeCode = citeCode;
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", citeCode='" + citeCode + '\'' +
                ", cityName='" + cityName + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCiteCode() {
        return citeCode;
    }

    public void setCiteCode(String citeCode) {
        this.citeCode = citeCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

}
