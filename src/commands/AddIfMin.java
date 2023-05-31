package commands;

import base.Vehicle;
import file.Collection;

import java.util.Comparator;
import java.util.Optional;

import static file.CommandLine.readVehicle;

public class AddIfMin implements CommandBase {
    /**
     * добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции
     *
     * @return Транспортное средство добавлено
     */
    @Override
    public String execute() {
        CommandHandler.commandHistory[CommandHandler.commandCounter%9] = "add_if_min";
        CommandHandler.commandCounter++;
        Vehicle vehicle = readVehicle();
        Optional<Vehicle> minElement = Collection.getInstance().getAll().stream().min(Comparator.comparing(Vehicle::getEnginePower));
        if (minElement.isPresent()) {
            if (minElement.get().getEnginePower() > vehicle.getEnginePower()) {
                Collection.getInstance().getAll().add(vehicle);
                return "Транспортное средство добавлено";
            }
            else {
                return "Введенное транспортное средство имеет не минимальную мощность двигателя";
            }
        }
        else {
            return "В коллекции нет транспортного средства с минимальной мощностью двигателя";
        }
    }

    @Override
    public String getCommandName() {
        return "add_if_min";
    }
}
