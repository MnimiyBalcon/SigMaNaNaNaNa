package commands;

import base.FuelType;
import base.Vehicle;
import file.Collection;

import java.util.stream.Collectors;

public class PrintUniqueFuelType implements CommandBase {
    /**
     * вывести уникальные значения поля fuelType всех элементов в коллекции
     *
     * @return значения поля fuelType для всех элементов в коллекции
     */
    @Override
    public String execute(){
        CommandHandler.commandHistory[CommandHandler.commandCounter%9] = "print_unique_fuel_type";
        CommandHandler.commandCounter++;
        return Collection.getInstance().getAll().stream().map(Vehicle::getFuelType).map(FuelType::getName).collect(Collectors.joining("\n"));
    }
    @Override
    public String getCommandName(){
        return "print_unique_fuel_type";
    }
}
