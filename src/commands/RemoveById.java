package commands;

import base.Vehicle;
import file.Collection;

import java.util.Scanner;

public class RemoveById implements CommandBase {
    /**
     * удалить элемент из коллекции по его id
     *
     * @return Элемент удален
     */
    @Override
    public String execute() {
        CommandHandler.commandHistory[CommandHandler.commandCounter%9] = "remove_by_id";
        CommandHandler.commandCounter++;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id");
        int x = getId(scanner);
        for (Vehicle vehicle : Collection.getInstance().getAll()) {
            if (x == vehicle.getId()) {
                Collection.getInstance().removeById(x);
                return "Элемент удалён";
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
        return "remove_by_id";
    }
}
