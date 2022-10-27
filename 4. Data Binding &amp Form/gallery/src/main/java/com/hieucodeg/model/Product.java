package com.hieucodeg.model;

public class Product {
    private Integer id;
    private String name;
    private Integer price;
    private String describe;
    private String manufacture;

    public Product(Integer id, String name, Integer price, String describe, String manufacture) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.describe = describe;
        this.manufacture = manufacture;
    }

    public Product() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }
}
