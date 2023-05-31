import DataBase.MainDataBase;
import DataBase.SetCollection;
import DataBase.Users;
import commands.CommandHandler;
import file.Collection;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Users users = new Users();

        try {
            MainDataBase.username = users.auth();
        } catch (SQLException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        SetCollection.getVehicleFromDB();

        //интерактивный режим
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            System.out.println(CommandHandler.execute(scanner.nextLine().toLowerCase()));
        }
    }
}