package file;

import DataBase.MainDataBase;
import base.Vehicle;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

public class Collection {

    private static HashSet<Vehicle> collection = new HashSet<>();
    private static Collection INSTANCE;
    public static HashSet<Vehicle> getVehicle(){
        return collection;
    }

    public static Collection getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Collection();
        }
        return INSTANCE;
    }

    public Collection() {
        this.collection = new HashSet<>();
    }

    public  void print(){
        List<Vehicle> vehicleList = new ArrayList<Vehicle>(Collection.getInstance().getAll());
        Collections.sort(vehicleList);
        vehicleList.forEach(System.out::println);
    }
    public HashSet<Vehicle> getAll(){
        return collection;
    }
    public static FileTime getCreationDate(String fileName) {
        try{
            return (FileTime) Files.getAttribute((new File(fileName)).toPath(), "creationTime");
        }
        catch (IOException e) {
            return null;
        }
    }

    public void updateId (int x) {

        collection.removeIf(e -> String.valueOf(e.getId()).equals(String.valueOf(x)) && e.getCreator().equals(MainDataBase.username));
        Vehicle object = CommandLine.readVehicle();
        object.setId(x);
        collection.add(object);
    }
    public void votIdBad(LinkedList<Vehicle> v) {
        collection.clear();
        for (int i = 0; i < v.size(); i++) {
            v.get(i).setId(i+1);
            collection.add(v.get(i));
        }
    }

    public void clear() {
        // Удаляем объект из коллекции
        collection.removeIf(vehicle -> vehicle.getCreator().equals(MainDataBase.username));
        LinkedList<Vehicle> linkedList = new LinkedList<>(collection);
        linkedList.sort(new SigmaComparator());
        votIdBad(linkedList);
        System.out.println("Успешно");
    }
    public void removeById (int x) {
        TreeSet<Integer> idCounter = new TreeSet<>();
        int id = 1;

        collection.removeIf(e -> String.valueOf(e.getId()).equals(String.valueOf(x)) && e.getCreator().equals(MainDataBase.username));
        for (Vehicle vehicle : collection) {
            while (!idCounter.add(id)) {
                id++;
            }
            vehicle.setId(id);
        }
    }

    static int generateId() {
        int id =  Collection.getInstance().getAll().stream()
                .map(Vehicle::getId)
                .max(Comparator.comparing(Integer::intValue))
                .orElse(0);
        return ++id;
    }

    public void save() {
        MainDataBase.requestSQLWithout("DELETE FROM Vehicle_Catalog;");
        MainDataBase.requestSQLWithout("ALTER SEQUENCE VenicleIdSeq RESTART WITH 1;");
        for (Vehicle vehicle : Collection.getInstance().getAll()) {
            MainDataBase.requestSQLWithout("insert into Vehicle_Catalog (id, creator, creationDate, name, enginePower, capacity, fuelConsumption, fuelType,  x, y) values (nextval('VenicleIdSeq') , '" + vehicle.getCreator() + "', '" + vehicle.getCreationDate().toString() + "', '" + vehicle.getName() + "', '" + vehicle.getEnginePower() + "', '" + vehicle.getCapacity() + "', '" + vehicle.getFuelConsumption() + "', '" + vehicle.getFuelType() + "', '"+vehicle.getCoordinates().getX()+ "', '"+ vehicle.getCoordinates().getY() + "')");
        }
    }

}
