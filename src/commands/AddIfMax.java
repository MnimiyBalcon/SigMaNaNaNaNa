package commands;

import base.Vehicle;
import file.Collection;

import java.util.Comparator;
import java.util.Optional;

import static file.CommandLine.readVehicle;

public class AddIfMax implements CommandBase {
    /**
     * добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции
     *
     * @return Транспортное средство добавлено
     */
    @Override
    public String execute(){
        CommandHandler.commandHistory[CommandHandler.commandCounter%9] = "add_if_max";
        CommandHandler.commandCounter++;
        Vehicle vehicle = readVehicle();
        Optional<Vehicle> maxElement = Collection.getInstance().getAll().stream().max(Comparator.comparing(Vehicle::getEnginePower));
        if (maxElement.isPresent()) {
            if (maxElement.get().getEnginePower() < vehicle.getEnginePower()) {
                Collection.getInstance().getAll().add(vehicle);
                return "Транспортное средство добавлено";
            }
            else {
                return "Введенное транспортное средство имеет не максимальную мощность двигателя";
            }
        }
        else {
            return "В коллекции нет транспортного средства с максимальной мощностью двигателя";
        }
    }
    @Override
    public String getCommandName(){
        return "add_if_max";
    }
}
