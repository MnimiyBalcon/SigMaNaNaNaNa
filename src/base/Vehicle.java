package base;

import com.google.gson.annotations.Expose;

import java.util.Date;

public class Vehicle implements Comparable<Vehicle>{
    /**
     * Класс транспортного средства
     */
    @Expose(serialize = false)
    private int id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    @Expose(serialize = true)
    private String name; //Поле не может быть null, Строка не может быть пустой
    @Expose(serialize = true)
    private Coordinates coordinates; //Поле не может быть null
    @Expose(serialize = true)
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    @Expose(serialize = true)
    private Float enginePower; //Поле не может быть null, Значение поля должно быть больше 0
    @Expose(serialize = true)
    private Float capacity; //Поле может быть null, Значение поля должно быть больше 0
    @Expose(serialize = true)
    private int fuelConsumption; //Значение поля должно быть больше 0
    @Expose(serialize = true)
    private FuelType fuelType; //Поле не может быть null

    public Vehicle(int id, String name, Coordinates coordinates, java.util.Date creationDate, Float enginePower, Float capacity, int fuelConsumption, FuelType fuelType) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.enginePower = enginePower;
        this.capacity = capacity;
        this.fuelConsumption = fuelConsumption;
        this.fuelType = fuelType;
    }

    public Vehicle() {
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public java.util.Date getCreationDate() {
        return creationDate;
    }

    public Float getEnginePower() {
        return enginePower;
    }

    public Float getCapacity() {
        return capacity;
    }

    public long getFuelConsumption() {
        return fuelConsumption;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setCreationDate(java.util.Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setEnginePower(Float enginePower) {
        this.enginePower = enginePower;
    }

    public void setCapacity(Float capacity) {
        this.capacity = capacity;
    }

    public void setFuelConsumption(int fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public String toString(){
        return "Vehicle{"
                + "id =" + id
                + ", name =" + name
                + ", coordinates =" + coordinates
                + ", creationDate =" + creationDate
                + ", enginePower =" + enginePower
                + ", capacity =" + capacity
                + ", fuelConsumption =" + fuelConsumption
                + ", fuelType =" + fuelType
                + '}';
    }

    @Override
    public int compareTo(Vehicle o) {
        return Integer.compare(id, o.id);
    }
}
