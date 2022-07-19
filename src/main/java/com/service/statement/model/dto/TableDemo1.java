package com.service.statement.model.dto;

public class TableDemo1 {
    private String id;
    private String name;
    private String price;
    private String population;

    public TableDemo1(String id, String name, String price, String population) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.population = population;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }
}
