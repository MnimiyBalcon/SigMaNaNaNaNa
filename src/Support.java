import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Support {
    public static void main(String[] args) throws SQLException {

        String user = "s368949";
        String password = "W4B3WDUkXkwHmyuu";
        String url = "jdbc:postgresql://db:5432/studs";

        Connection connection = DriverManager.getConnection(url, user, password);
        Statement stat = connection.createStatement();
        stat.executeUpdate("drop table Vehicle_Catalog");
        stat.executeUpdate("CREATE TABLE Vehicle_Catalog(id integer NOT NULL CHECK (id > 0), name text not NULL, x float, y INTEGER CHECK (y <= 533), creationDate text NOT NULL, enginePower float CHECK (enginePower > 0), capacity float CHECK (capacity > 0), fuelConsumption int CHECK (fuelConsumption > 0),fuelType text CHECK(fuelType IN ('PLASMA', 'GASOLINE', 'ALCOHOL', 'ELECTRICITY', 'ANTIMATTER')), creator text not null, PRIMARY KEY(id));");
        stat.executeUpdate("CREATE SEQUENCE VenicleIdSeq START WITH 1 INCREMENT BY 1;");
        stat.executeUpdate("create table users (name text, password text not null, PRIMARY KEY(name));");

        System.out.println("Получилось");

    }
}
