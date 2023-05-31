package file;

import base.Vehicle;
import com.google.gson.Gson;
import com.google.gson.stream.MalformedJsonException;

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

    private Collection() {
        this.collection = new HashSet<>();
    }
    /**
     * Метод? который отвечает за загрузку файла в коллекци.
     * @param fileName
     */
    public static void toLoad(String fileName) {
        InputStreamReader inputStreamReader = null;
        try {
            inputStreamReader = new InputStreamReader(new FileInputStream(fileName));
            String json = new BufferedReader(inputStreamReader).lines().collect(Collectors.joining());
            if(!json.isEmpty()) {
                Gson gson = new Gson();
                Vehicle[] vehicles = gson.fromJson(json, Vehicle[].class);
                for (Vehicle vehicle : vehicles) {
                    if (validate(vehicle)) {
                        vehicle.setId(generateId());
                        vehicle.setCreationDate(Date.from(Instant.now()));
                        Collection.getInstance().getAll().add(vehicle);
                    }
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     * Валидация? полей транспортного средства для чтения из файла
     * @param vehicle транспортное средство для проверки
     * @return результат валидации
     */
    private static boolean validate(Vehicle vehicle) {
        if(vehicle.getName().trim().isEmpty()) {
            return false;}
        if(vehicle.getCoordinates().getY() > 533){
            return false;}
        if(vehicle.getCoordinates() == null) {
            return false;}
        if(vehicle.getCreationDate() == null) {
            return false;}
        if(vehicle.getFuelType() == null) {
            return false;}
        if(vehicle.getFuelConsumption() <= 0){
            return false;}
        if(vehicle.getCapacity() <= 0 && vehicle.getCapacity() == null){
            return false;}
        if(vehicle.getEnginePower() <= 0 && vehicle.getEnginePower() == null){
            return false;}
        return true;
    }
    /*public HashSet<Vehicle> getCollection() {
        return collection;
    }*/
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
        collection.removeIf(e -> String.valueOf(e.getId()).equals(String.valueOf(x)));
        Vehicle object = CommandLine.readVehicle();
        object.setId(x);
        collection.add(object);
    }
    public void clear() {
        Iterator<Vehicle> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Vehicle vehicle = iterator.next();
            if (vehicle.getCreator().equals(/*ИМЯ НЫНЕШНЕГО пользователя*/)) {
                iterator.remove(); // Удаляем объект из коллекции
            }
        }
        System.out.println("Успешно");
    }
    public void removeById (int x) {
        TreeSet<Integer> idCounter = new TreeSet<>();
        Integer id = Integer.valueOf(1);
        collection.removeIf(e -> String.valueOf(e.getId()).equals(String.valueOf(x)));
        for (Vehicle vehicle : collection) {
            while (!idCounter.add(id)) {
                id++;
            }
            vehicle.setId(id);
        }
    }
    public void clear() {
        collection.clear();
    }
    static int generateId() {
        int id =  Collection.getInstance().getAll().stream()
                .map(Vehicle::getId)
                .max(Comparator.comparing(Integer::intValue))
                .orElse(0);
        return ++id;
    }

}
