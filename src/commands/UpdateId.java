package commands;

import DataBase.MainDataBase;
import base.Vehicle;
import file.Collection;

import java.util.Scanner;

public class UpdateId implements CommandBase {
    /**
     * обновить значение элемента коллекции, id которого равен заданному
     *
     * @return Элемент добавлен
     */
    @Override
    public String execute() {
        CommandHandler.commandHistory[CommandHandler.commandCounter%9] = "update";
        CommandHandler.commandCounter++;
        Scanner scanner = new Scanner(System.in) ;
        System.out.println("Введите id");
        int x = getId(scanner);
        for (Vehicle vehicle : Collection.getInstance().getAll()) {
            if (x == vehicle.getId()) {
                if (vehicle.getCreator().equals(MainDataBase.username)){
                    Collection.getInstance().updateId(x);
                    return "Элемент изменён";
                }
                else return "Ошибка! Этот элемент принадлежит другому пользователю!";
            }
        }
        return "Нет такого id!";
    }
    private static int getId (Scanner scanner) {
        while (true) {
            String s = scanner.nextLine();
            try {
                int l = Integer.parseInt(s);
                if (l > 0) {
                    return l;
                }
                else {
                    System.out.println("id должен быть больше нуля!");
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Номер id должен быть в формате int!");
            }
        }
    }
    @Override
    public String getCommandName() {
        return "update";
    }
}
