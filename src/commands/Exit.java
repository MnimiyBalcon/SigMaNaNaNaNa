package commands;

public class Exit implements CommandBase {
    /**
     * завершить программу (без сохранения в файл)
     *
     * @return Работа закочена
     */
    @Override
    public String execute(){
        CommandHandler.commandHistory[CommandHandler.commandCounter%9] = "exit";
        CommandHandler.commandCounter++;
       System.exit(1);
       return "Работа закочена";
    }
    @Override
    public String getCommandName(){
        return "exit";
    }
}
