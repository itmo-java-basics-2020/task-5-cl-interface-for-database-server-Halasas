package ru.andrey.kvstorage.console;

import java.util.Optional;

public interface DatabaseCommandResult {
    static DatabaseCommandResult success(String result) {
        return new SimpleDatabaseCommandResult(true, result);
    }
    static DatabaseCommandResult error(String message) {
        return new SimpleDatabaseCommandResult(false, message);
    }
    Optional<String> getResult();

    DatabaseCommandStatus getStatus();

    boolean isSuccess();

    String getErrorMessage();

    enum DatabaseCommandStatus {
        SUCCESS, FAILED
    }

    public class SimpleDatabaseCommandResult implements DatabaseCommandResult {
        private boolean isSuccess;
        private String message;

        private SimpleDatabaseCommandResult(boolean isSuccess, String message) {
            this.isSuccess = isSuccess;
            this.message = message;
        }

        @Override
        public Optional<String> getResult() {
            if(isSuccess)
                return Optional.of(message);
            else
                return Optional.empty();
        }

        @Override
        public DatabaseCommandStatus getStatus() {
            if(isSuccess)
                return  DatabaseCommandStatus.SUCCESS;
            else
                return  DatabaseCommandStatus.FAILED;
        }

        @Override
        public boolean isSuccess() {
            return isSuccess;
        }

        @Override
        public String getErrorMessage() {
            return message;
        }
    }
}