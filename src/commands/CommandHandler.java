package commands;

import java.io.IOException;
import java.util.List;

public class CommandHandler {
    private static final List<CommandBase> commands = List.of(
      new Help(),
      new Info(),
      new Show(),
      new Add(),
      new UpdateId(),
      new RemoveById(),
      new Clear(),
      new Save(),
      new ExecuteScriptFileName(),
      new Exit(),
      new AddIfMax(),
      new AddIfMin(),
      new History(),
      new CountByEnginePower(),
      new FilterContainsName(),
      new PrintUniqueFuelType()
    );
    public static int commandCounter;
    public static String[] commandHistory = {null, null, null, null, null, null, null, null, null};
    /**
     * выполнить команду по названию
     * @param commandLine
     * @return command.execute()
     */
    public static String execute(String commandLine) throws IOException {
        for (CommandBase command : commands) {
            if (command.getCommandName().equals(commandLine)) {
                return command.execute();
            }
        }
        return "Несуществующее название команды.\n" + new Help().execute();
    }
}
