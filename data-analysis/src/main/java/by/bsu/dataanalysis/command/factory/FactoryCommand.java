package by.bsu.dataanalysis.command.factory;


import by.bsu.dataanalysis.command.Command;
import by.bsu.dataanalysis.command.CommandMap;

public class FactoryCommand {
    public Command createCommand(String commandName) {
        return CommandMap.defineCommandType(commandName);
    }
}
