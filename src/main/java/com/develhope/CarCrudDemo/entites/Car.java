package com.develhope.CarCrudDemo.entites;


import lombok.Data;
import org.springframework.data.annotation.Id;


@Data
public class Car {

    @Id
    private String id;

    private String modelName;

    private String type;

    public Car(){

    }

    public Car(String id, String modelName, String type) {
        this.id = id;
        this.modelName = modelName;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                ", modelName='" + modelName + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
