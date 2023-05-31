import commands.CommandHandler;
import file.Collection;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Collection collection = Collection.getInstance();
        if (args.length == 0) {
            System.out.println("Входной файл не задан");
        }
        if (args.length == 1) {
            String fileName = args[0];
            Collection.toLoad(fileName);
        }
        collection.print();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            System.out.println(CommandHandler.execute(scanner.nextLine().toLowerCase()));
        }
    }
}