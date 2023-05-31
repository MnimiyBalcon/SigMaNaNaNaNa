package DataBase;


import base.Coordinates;
import base.FuelType;
import base.Vehicle;
import file.Collection;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;



/**
 * Класс, связывающий коллекцию и базу данных
 */
public class SetCollection {
    /**
     * Метод, в котором информация из базы данных записывается в коллекцию
     */
    public static void getVehicleFromDB() {

        try {

            ResultSet rs = MainDataBase.requestSQLWith("SELECT * FROM Vehicle");
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
                String pattern = "yyyy-MM-dd";

                SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
                Date creationDate = null;
                try {
                    creationDate = (Date) dateFormat.parse(stDate);

                } catch (ParseException e) {
                    e.printStackTrace();
                }
                double x = rs.getDouble("x");
                int y = rs.getInt("y");
                float enginePower = rs.getFloat("size");
                String creator = rs.getString("creator");
                Collection.getVehicle().add(new Vehicle(id, name, new Coordinates(x, y), creationDate, enginePower, capacity, fuelConsumption, fuelType, creator));
            }
            rs.close();

        } catch (SQLException e) {
            System.out.println("Error while getting dragons from DB: " + e.getMessage());
        }
    }
}