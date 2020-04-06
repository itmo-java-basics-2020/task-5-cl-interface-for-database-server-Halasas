package ru.andrey.kvstorage;

import ru.andrey.kvstorage.console.CommandParser;
import ru.andrey.kvstorage.console.DatabaseCommandResult;
import ru.andrey.kvstorage.console.ExecutionEnvironment;
import ru.andrey.kvstorage.exception.DatabaseException;
import ru.andrey.kvstorage.logic.Database;

public class DatabaseServer {

    private final ExecutionEnvironment env;

    public DatabaseServer(ExecutionEnvironment env) {
        this.env = env;
    }

    public static void main(String[] args) {
    }

    DatabaseCommandResult executeNextCommand(String commandText) {
        try {
        if(commandText.isEmpty())
            return DatabaseCommandResult.error("command text is empty");
        String[] strings = commandText.split(" ");
        return CommandParser.valueOf(strings[0]).GetCommand(env,strings).execute();
        } catch (Exception e) {
            return DatabaseCommandResult.error(e.getMessage());
        }
    }
}
