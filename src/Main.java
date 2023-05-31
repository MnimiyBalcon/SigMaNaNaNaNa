import DataBase.SetCollection;
import commands.CommandHandler;
import file.Collection;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        SetCollection.getVehicleFromDB();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            System.out.println(CommandHandler.execute(scanner.nextLine().toLowerCase()));
        }
    }
}