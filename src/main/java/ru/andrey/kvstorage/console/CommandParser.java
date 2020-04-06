package ru.andrey.kvstorage.console;

public enum CommandParser {
    CREATE_DATABASE {
        @Override
        public DatabaseCommand GetCommand(ExecutionEnvironment executionEnvironment, String[] args) {
            String databaseName = args[1];
            return new CreateDatabaseCommand(executionEnvironment, databaseName);
        }
    },
    CREATE_TABLE {
        @Override
        public DatabaseCommand GetCommand(ExecutionEnvironment executionEnvironment, String[] args) {
            String databaseName = args[1];
            String tableName = args[2];
            return new CreateTableCommand(executionEnvironment, databaseName, tableName);
        }
    },
    READ_KEY {
        @Override
        public DatabaseCommand GetCommand(ExecutionEnvironment executionEnvironment, String[] args) {
            String databaseName = args[1];
            String tableName = args[2];
            String objectKey = args[3];
            return new ReadKeyCommand(executionEnvironment, databaseName, tableName, objectKey);
        }
    },
    UPDATE_KEY {
        @Override
        public DatabaseCommand GetCommand(ExecutionEnvironment executionEnvironment, String[] args) {
            String databaseName = args[1];
            String tableName = args[2];
            String objectKey = args[3];
            String objectValue = args[4];
            return new UpdateKeyCommand(executionEnvironment, databaseName, tableName, objectKey, objectValue);
        }
    };

    public abstract DatabaseCommand GetCommand(ExecutionEnvironment executionEnvironment, String[] args);
}
