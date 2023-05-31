package commands;

import base.Vehicle;
import file.Collection;

import java.util.Scanner;
import java.util.stream.Collectors;

public class FilterContainsName implements CommandBase {
    /**
     * вывести элементы, значение поля name которых содержит заданную подстроку
     *
     * @return Collection.getInstance().getAll().stream().filter(e - > e.getName ().toUpperCase().contains(x))
     * .map(Vehicle::toString).collect(Collectors.joining("\n"));
     */
    @Override
    public String execute() {
        CommandHandler.commandHistory[CommandHandler.commandCounter%9] = "filter_contains_name";
        CommandHandler.commandCounter++;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите подстроку");
        String x = getName(scanner).toUpperCase();
        return Collection.getInstance().getAll().stream().filter(e -> e.getName().toUpperCase().contains(x)).map(Vehicle::toString).collect(Collectors.joining("\n"));
    }
    @Override
    public String getCommandName() {
        return "filter_contains_name";
    }
    private static String getName(Scanner scanner) {
        while (true){
            String s = scanner.nextLine();
            if (s != null && !s.isEmpty()) {
                String[] x = s.split(" ");
                if (x.length >= 1) {
                    return s;
                }
            }
        }
    }
}
