package com.coral.boot.model;


import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class User implements Serializable {

    @ApiModelProperty(value = "用户ID")
    private Long id;
    @ApiModelProperty(value = "用户名",required = true)
    private String name;
    @ApiModelProperty(value = "年龄",required = true)
    private Integer age;
    @ApiModelProperty(value = "公司", allowEmptyValue = true)
    private String company;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String toString() {
        return "User {id="+ id +", name="+name +", age="+age + ", company=" + company + "}";
    }
}
