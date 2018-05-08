package by.bsu.dataanalysis.command;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static by.bsu.dataanalysis.command.CommandType.*;

public class CommandMap {
    private EnumMap<CommandType, Command> map = new EnumMap<>(CommandType.class);
    private static CommandMap instance = new CommandMap();

    private CommandMap() {
        map.put(SEND_FILE, new SendFileCommand());
    }

    public static CommandMap getInstance() {
        return instance;
    }

    public static Command defineCommandType(String commandParameter) {
        List<Command> list = new ArrayList<>();
        EnumMap<CommandType, Command> commandMap = getInstance().map;

        CommandType commandType = CommandType.valueOf(commandParameter);
        for (Map.Entry<CommandType,Command> currentCommand : commandMap.entrySet()) {
            CommandType currentCommandType = currentCommand.getKey();
            if(currentCommandType.equals(commandType))
            {
                Command command = currentCommand.getValue();
                list.add(command);
                break;
            }
        }
        return list.get(0);
    }

}
