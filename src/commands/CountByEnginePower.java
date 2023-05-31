package commands;

import base.Vehicle;
import file.Collection;

import java.util.Scanner;
import java.util.stream.Collectors;

public class CountByEnginePower implements CommandBase {
    /**
     * вывести количество элементов, значение поля enginePower которых равно заданному
     *
     * @return Collection.getInstance().getAll().stream().filter(e - > e.getEnginePower ()
     * .equals(x)).map(Vehicle::toString).collect(Collectors.joining("\n"));
     */
    @Override
    public String execute() {
        CommandHandler.commandHistory[CommandHandler.commandCounter%9] = "count_by_engine_power";
        CommandHandler.commandCounter++;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите мощность двигателя");
        Float x = getEnginePower(scanner);
        return Collection.getInstance().getAll().stream().filter(e -> e.getEnginePower().equals(x)).map(Vehicle::toString).collect(Collectors.joining("\n"));
    }
    @Override
    public String getCommandName() {
        return "count_by_engine_power";
    }
    private static Float getEnginePower (Scanner scanner) {
        while (true) {
            String s = scanner.nextLine();
            try {
                Float l = Float.parseFloat(s);
                if (l > 0) {
                    return l;
                }
                else {
                    System.out.println("Неверный ввод!");
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Неверный ввод!");
            }
        }
    }
}
