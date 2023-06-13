package commands;

import base.Vehicle;
import file.Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Show implements CommandBase{
    /**
     * @return в стандартный поток вывода все элементы коллекции в строковом представлении
     */
    @Override
    public String execute(){
        CommandHandler.commandHistory[CommandHandler.commandCounter%9] = "show";
        CommandHandler.commandCounter++;
        /*return Collection.getInstance()
                .getAll()
                .stream()
                .map(Vehicle::toString)
                .collect(Collectors.joining("\n"));*/
        List<Vehicle> vehicleList = new ArrayList<Vehicle>(Collection.getInstance().getAll());
        Collections.sort(vehicleList);
        for (Vehicle vehicle : vehicleList){
            System.out.println("Vehicle{id =" + vehicle.getId() + ", name =" + vehicle.getName() + ", coordinates ="
                    + vehicle.getCoordinates() + ", creationDate =" + vehicle.getCreationDate() + ", enginePower ="
                    + vehicle.getEnginePower() + ", capacity =" + vehicle.getCapacity() + ", fuelConsumption ="
                    + vehicle.getFuelConsumption() + ", fuelType =" + vehicle.getFuelType() + ", creator =" + vehicle.getCreator() + "}" + '\n');
        }
        return "";
    }
    @Override
    public String getCommandName(){
        return "show";
    }
}
