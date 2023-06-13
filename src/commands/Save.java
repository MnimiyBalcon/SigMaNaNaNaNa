package commands;

import DataBase.MainDataBase;
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
        CommandHandler.commandHistory[CommandHandler.commandCounter % 9] = "save";
        CommandHandler.commandCounter++;
        Collection.getInstance().save();
        return "Коллекция сохранена в базе данных";
    }
    @Override
    public String getCommandName() {
        return "save";
    }
}
