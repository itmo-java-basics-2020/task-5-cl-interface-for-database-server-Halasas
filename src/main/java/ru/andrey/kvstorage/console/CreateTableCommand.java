package ru.andrey.kvstorage.console;

import ru.andrey.kvstorage.exception.DatabaseException;
import ru.andrey.kvstorage.logic.Database;

public class CreateTableCommand implements DatabaseCommand {
    String TableName;
    String DatabaseName;
    ExecutionEnvironment Environment;

    public CreateTableCommand(ExecutionEnvironment executionEnvironment, String databaseName, String tableName) {
        this.TableName = tableName;
        this.DatabaseName = databaseName;
        this.Environment = executionEnvironment;
    }

    public CreateTableCommand(ExecutionEnvironment executionEnvironment,
                              String databaseName,
                              String tableName,
                              int segmentSizeInBytes) {
        throw new NullPointerException();
    }

    @Override
    public DatabaseCommandResult execute() throws DatabaseException {
        try {
            Database database = Environment.getDatabase(DatabaseName).get();
            database.createTableIfNotExists(TableName);
            return DatabaseCommandResult.success("Table " + TableName + " created successfully");
        } catch (Exception e) {
            return DatabaseCommandResult.error(e.getMessage());
        }
    }
}
