package by.bsu.dataanalysis.command;

public enum CommandType {
    SEND_FILE("SEND_FILE");

    private final String name;

    CommandType(String name) {
        this.name = name;
    }

    public static CommandType fromString(String text) {
        for (CommandType value : CommandType.values()) {
            if (value.name.equalsIgnoreCase(text)) {
                return value;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return name;
    }
}
