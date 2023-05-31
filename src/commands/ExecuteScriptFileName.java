package commands;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ExecuteScriptFileName implements CommandBase {
    /**
     * Cчитать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.
     *
     * @return Команды выполнены
     */
    @Override
    public String execute() {
        CommandHandler.commandHistory[CommandHandler.commandCounter%9] = "execute_script";
        CommandHandler.commandCounter++;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя файла");
        String filename = scanner.nextLine();
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filename));
            String script = new BufferedReader(inputStreamReader).lines().collect(Collectors.joining("\n"));
            String[] commands = script.split("\n");
            CommandHandler commandHandler = new CommandHandler();
            if (Arrays.asList(commands).contains("execute_script")) {
                return "Нельзя выполнить команду execute_script из файла";
            }
            else {
                for (String command : commands) {
                    System.out.println(commandHandler.execute(command));
                }
            }
        }
        catch (IOException e) {
            return "Недопустимое имя файла";
        }
        return "Команды выполнены";
    }
    @Override
    public String getCommandName(){
        return "execute_script";
    }
}
