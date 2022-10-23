package com.example.pojo;

public class gaode_city {
    private String city_name;
    private Integer city_code;

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public void setCity_code(Integer city_code) {
        this.city_code = city_code;
    }

    public String getCity_name() {
        return city_name;
    }

    public Integer getCity_code() {
        return city_code;
    }

    @Override
    public String toString() {
        return "City{" +
                "city_name='" + city_name + '\''+
                ", city_code=" + city_code +
                "}";
    }
}
