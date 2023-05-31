package commands;

import java.io.IOException;

public interface CommandBase {
    /**
     * Интерфейс, реализуемый командами
     *
     * @return
     */
    String execute() throws IOException;
    String getCommandName();
}
