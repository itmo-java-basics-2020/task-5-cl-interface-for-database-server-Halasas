package ru.andrey.kvstorage.console;

import ru.andrey.kvstorage.exception.DatabaseException;
import ru.andrey.kvstorage.logic.Database;

public class UpdateKeyCommand implements DatabaseCommand {
    String DatabaseName;
    String TableName;
    String ObjectKey;
    String ObjectValue;
    ExecutionEnvironment Environment;

    public UpdateKeyCommand(ExecutionEnvironment executionEnvironment,
                            String databaseName,
                            String tableName,
                            String objectKey,
                            String objectValue) {
        this.TableName = tableName;
        this.DatabaseName = databaseName;
        this.ObjectKey = objectKey;
        this.ObjectValue = objectValue;
        this.Environment = executionEnvironment;
    }

    @Override
    public DatabaseCommandResult execute() throws DatabaseException {
        try {
            Database database = Environment.getDatabase(DatabaseName).get();
            database.write(TableName, ObjectKey, ObjectValue);
            return DatabaseCommandResult.success("Value written successfully");
        } catch (Exception e) {
            return DatabaseCommandResult.error(e.getMessage());
        }
    }
}
