package Model;

import java.util.Date;
import java.util.UUID;

public class Product {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private double price; //Значение поля должно быть больше 0
    private String partNumber; //Значение этого поля должно быть уникальным, Поле может быть null
    private int manufactureCost;
    private UnitOfMeasure unitOfMeasure; //Поле не может быть null
    private Organization manufacturer; //Поле не может быть null
    public Product ( String name, Coordinates coordinates, double price, String partNumber,
                     int  manufactureCost, UnitOfMeasure unitOfMeasure, Organization manufacturer){
        this.name = name;
        this.coordinates = coordinates;
        this.price = price;
        this.partNumber = partNumber;
        this.manufactureCost = manufactureCost;
        this.unitOfMeasure = unitOfMeasure;
        this.manufacturer = manufacturer;
        this.creationDate = new Date();
        this.id = Math.abs(UUID.randomUUID().hashCode());
    }
    public double getPrice (){
        return this.price;
    }

    public int getId() {
        return this.id;
    }

    public String unitOfMeasureAsString() {
        String asString = unitOfMeasure.name();
        asString = asString.toLowerCase();
        if (asString.contains("_")) return asString.split("_")[0] + " " + asString.split("_")[1];
        else return asString;
    }

    public String asString() {
        return "Product named " + name + ".\n" +
                "It`s id is " + id + ".\n" +
                "It`s coordinates: " + coordinates.asString() +
                "The " + name + " was created on " + creationDate + ".\n" +
                "It`s price is " + price + ".\n" +
                "it`s part number is " + partNumber + ".\n" +
                "It`s manufacture cost is " + manufactureCost + ".\n" +
                "The " + name + " is measured in " + unitOfMeasureAsString() + ".\n" +
                manufacturer.asString();
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setManufactureCost(int manufactureCost) {
        this.manufactureCost = manufactureCost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public void setManufacturer(Organization manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Organization getManufacturer() {
        return manufacturer;
    }

    public UnitOfMeasure getUnitOfMeasure() {
        return this.unitOfMeasure;
    }

}
