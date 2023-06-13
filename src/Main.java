import DataBase.MainDataBase;
import DataBase.SetCollection;
import DataBase.Users;
import commands.CommandHandler;
import commands.RemoveById;
import file.Collection;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void runApp(){
        Users users = new Users();
        try {
            MainDataBase.username = users.auth();
        } catch (SQLException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        SetCollection.getVehicleFromDB();
    }

    public static void main(String[] args) throws IOException {
        runApp();

        //интерактивный режим
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().toLowerCase();
            if (line.toLowerCase(Locale.ROOT).equals("logout")){
                Collection.getInstance().getAll().clear();
                MainDataBase.username = "";
                runApp();
            }
            else System.out.println(CommandHandler.execute(line));
        }
    }
}