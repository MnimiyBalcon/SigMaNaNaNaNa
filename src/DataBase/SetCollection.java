package DataBase;


import base.Coordinates;
import base.FuelType;
import base.Vehicle;
import file.Collection;

import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Locale;


/**
 * Класс, связывающий коллекцию и базу данных
 */
public class SetCollection {
    /**
     * Метод, в котором информация из базы данных записывается в коллекцию
     */
    public static void getVehicleFromDB() {

        try {
            ResultSet rs = MainDataBase.requestSQLWith("SELECT * FROM Vehicle_Catalog");
            while (true) {
                assert rs != null;
                if (!rs.next()) break;
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int fuelConsumption = rs.getInt("fuelConsumption");
                float capacity = rs.getLong("capacity");
                String colorString = rs.getString("fuelType");
                FuelType fuelType = FuelType.valueOf(colorString);

                String stDate = rs.getString("creationDate");

                SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH); // формат даты в строке
                Date date = null; // создаем пустой объект типа Date
                try {
                    date = format.parse(stDate); // строку преобразуем в объект Date
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                double x = rs.getDouble("x");
                int y = rs.getInt("y");
                float enginePower = rs.getFloat("enginePower");
                String creator = rs.getString("creator");
                Collection.getInstance().getAll().add(new Vehicle(id, name, new Coordinates(x, y), date, enginePower, capacity, fuelConsumption, fuelType, creator));
            }
            rs.close();

        } catch (SQLException e) {
            System.out.println("Error while getting dragons from DB: " + e.getMessage());
        }
    }
}