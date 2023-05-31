package commands;

import file.Collection;

public class Info implements CommandBase{
    /**
     * вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
     *
     * @return тип коллекции, дата создания, количество элементов
     */
    @Override
    public String execute(){
        CommandHandler.commandHistory[CommandHandler.commandCounter%9] = "info";
        CommandHandler.commandCounter++;
        return "Класс коллекции: " + Collection.getInstance().getAll().getClass() + "\nСоздано: " + Collection.getCreationDate("input.json") + "\nКоличество элементов: " + Collection.getInstance().getAll().size();
    }
    @Override
    public String getCommandName(){
        return "info";
    }
}
