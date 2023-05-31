package commands;

import base.Vehicle;
import file.Collection;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Save implements CommandBase {
    /**
     * сохранить коллекцию в файл
     *
     * @return Коллекция сохранена
     */
    @Override
    public String execute() throws IOException {
        /*CommandHandler.commandHistory[CommandHandler.commandCounter % 9] = "save";
        CommandHandler.commandCounter++;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название файла");
        String filename = scanner.nextLine();
        File file = new File(filename);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                return "Невозможно создать файл";
            }
        }
        if(Files.isWritable(Path.of(filename))) {
            try {
                PrintWriter printWriter = new PrintWriter(file);
                Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
                List<Vehicle> vehicleList = new ArrayList<Vehicle>(Collection.getInstance().getAll());
                Collections.sort(vehicleList);
                printWriter.write(gson.toJson(vehicleList));
                printWriter.flush();
                printWriter.close();
            } catch (FileNotFoundException e) {
                return "Невозможно записать коллекцию!";
            }
            return "Коллекция сохранена";
        }
        return "Невозможно записать коллекцию! Введите название команды";*/
        return null;
    }
    @Override
    public String getCommandName() {
        return "save";
    }
}
