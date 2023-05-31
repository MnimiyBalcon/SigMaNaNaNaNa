package commands;

public class History implements CommandBase {
    /**
     * вывести последние 9 команд (без их аргументов)
     *
     * @return последние 9 вызванных команд
     */
    @Override
    public String execute() {
        System.out.println("Последние 9 команд: ");
        for (int i=0; i<9; i++){
            System.out.println(CommandHandler.commandHistory[i]);
        }
        CommandHandler.commandHistory[CommandHandler.commandCounter%9] = "history";
        CommandHandler.commandCounter++;
        return "";
    }
    @Override
    public String getCommandName() {
        return "history";
    }
}
