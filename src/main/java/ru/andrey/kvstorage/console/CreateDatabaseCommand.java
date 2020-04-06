package ru.andrey.kvstorage.console;

import ru.andrey.kvstorage.exception.DatabaseException;
import ru.andrey.kvstorage.logic.Database;

public class CreateDatabaseCommand implements DatabaseCommand {
    String DatabaseName;
    ExecutionEnvironment Environment;

    public CreateDatabaseCommand(ExecutionEnvironment executionEnvironment, String databaseName) {
        this.DatabaseName = databaseName;
        this.Environment = executionEnvironment;
    }

    @Override
    public DatabaseCommandResult execute() throws DatabaseException {
        try {
            Database database = Environment.getDatabase(DatabaseName).get();
            Environment.addDatabase(database);
            return DatabaseCommandResult.success("Database " + DatabaseName + " created successfully");
        } catch (Exception e) {
            return DatabaseCommandResult.error(e.getMessage());
        }
    }
}
