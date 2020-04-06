package ru.andrey.kvstorage.console;

import ru.andrey.kvstorage.exception.DatabaseException;
import ru.andrey.kvstorage.logic.Database;

public class ReadKeyCommand implements DatabaseCommand {
    String DatabaseName;
    String TableName;
    String ObjectKey;
    ExecutionEnvironment Environment;

    public ReadKeyCommand(ExecutionEnvironment executionEnvironment,
                          String databaseName,
                          String tableName,
                          String objectKey) {
        this.DatabaseName = databaseName;
        this.TableName = tableName;
        this.ObjectKey = objectKey;
        this.Environment = executionEnvironment;
    }

    @Override
    public DatabaseCommandResult execute() {
        try {
            Database database = Environment.getDatabase(DatabaseName).get();
            return DatabaseCommandResult.success(database.read(TableName,ObjectKey));
        } catch (Exception e) {
            return DatabaseCommandResult.error(e.getMessage());
        }
    }
}
