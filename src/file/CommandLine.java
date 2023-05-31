package file;

import base.Coordinates;
import base.FuelType;
import base.Vehicle;

import java.time.Instant;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class CommandLine {
    /**
     * метод для создания? объекта организации чтением консоли
     * @return vehicle
     */
    public static Vehicle readVehicle() {
        Scanner scanner = new Scanner(System.in);
        Vehicle vehicle = new Vehicle();
        vehicle.setId(Collection.generateId());
        System.out.println("Введите имя транспортного средства:");
        vehicle.setName(getName(scanner));
        System.out.println("Введите координаты транспортного средства (2 координаты double, Intenger):");
        vehicle.setCoordinates(new Coordinates(getX(scanner), getY(scanner)));
        vehicle.setCreationDate(Date.from(Instant.now()));
        System.out.println("Введите мощность дивгателя (Float):");
        vehicle.setEnginePower(getEnginePower(scanner));
        System.out.println("Введите вместимость транспортного средства (Float):");
        vehicle.setCapacity(getCapacity(scanner));
        System.out.println("Введите расход топлива (int):");
        vehicle.setFuelConsumption(getFuelConsumption(scanner));
        System.out.println("Введите тип топлива (GASOLINE, ELECTRICITY, ALCOHOL, PLASMA, ANTIMATTER):");
        vehicle.setFuelType(getFuelType(scanner));
        return vehicle;
    }
    /**
     * getters для валидации полей
     * @param scanner
     * @return значения полей
     */
    private static String getName(Scanner scanner) {
        while (true){
            String s = scanner.nextLine();
            if (s != null && !s.isEmpty()) {
                String[] x = s.split(" ");
                if (x.length >= 1) {
                    return s;
                }
            }
        }
    }
    private static double getX(Scanner scanner) {
        while (true) {
            String s = scanner.nextLine();
            try {
                double l = Double.parseDouble(s);
                return l;
            }
            catch (NumberFormatException e) {
                System.out.println("Неверный ввод!");
            }
        }
    }
    private static Integer getY(Scanner scanner) {
        while (true) {
            String s = scanner.nextLine();
            try {
                Integer l = Integer.parseInt(s);
                if (l < 533){
                    return l;
                }
                else {
                    System.out.println("Неверный ввод (координата y должна быть меньше 533)!");
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Неверный ввод!");
            }
        }
    }
    private static Float getEnginePower (Scanner scanner) {
        while (true) {
            String s = scanner.nextLine();
            try {
                Float l = Float.parseFloat(s);
                if (l > 0) {
                    return l;
                }
                else {
                    System.out.println("Неверный ввод (мощность двигателя должна быть больше нуля)!");
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Неверный ввод!");
            }
        }
    }
    private static Float getCapacity (Scanner scanner) {
        while (true) {
            String s = scanner.nextLine();
            try {
                Float l = Float.parseFloat(s);
                if (l > 0) {
                    return l;
                }
                else {
                    System.out.println("Неверный ввод (вместимость ТС должна быть больше нуля)!");
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Неверный ввод!");
            }
        }
    }
    private static int getFuelConsumption (Scanner scanner) {
        while (true) {
            String s = scanner.nextLine();
            try {
                int l = Integer.parseInt(s);
                if (l > 0) {
                    return l;
                }
                else {
                    System.out.println("Неверный ввод (Потребление топлива должно быть больше нуля)!");
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Неверный ввод!");
            }
        }
    }
    private static FuelType getFuelType (Scanner scanner) {
        while (true) {
            String s = scanner.nextLine();
            try {
                if (s != null && s.length() > 0) {
                    return FuelType.valueOf(s.toUpperCase(Locale.ENGLISH).trim());
                }
                else {
                    System.out.println("Неверный ввод (тип используемого топлива должен быть из представленного списка)!");
                }
            }
            catch (IllegalArgumentException e) {
                System.out.println("Неверный ввод (тип используемого топлива должен быть из представленного списка)!");
            }
        }
    }
}
