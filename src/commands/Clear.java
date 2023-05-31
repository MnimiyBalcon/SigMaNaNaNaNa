package commands;

import file.Collection;

public class Clear implements CommandBase {
    @Override
    public String execute() {
        /**
         * очистить коллекцию
         * @return Коллекция очищена
         */
        CommandHandler.commandHistory[CommandHandler.commandCounter%9] = "clear";
        CommandHandler.commandCounter++;
        Collection.getInstance().clear();
        return "Коллекция очищена";
    }
    @Override
    public String getCommandName() {
        return "clear";
    }
}
