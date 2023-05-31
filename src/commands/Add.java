package commands;

import file.Collection;
import file.CommandLine;

public class Add implements CommandBase{
    /**
     * добавить новый элемент в коллекцию
     *
     * @return Элемент добавлен
     */
    @Override
    public String execute() {
        CommandHandler.commandHistory[CommandHandler.commandCounter%9] = "add";
        CommandHandler.commandCounter++;
        Collection.getInstance().getAll().add(CommandLine.readVehicle());
        return "Элемент добавлен";
    }
    @Override
    public String getCommandName(){
        return "add";
    }
}
