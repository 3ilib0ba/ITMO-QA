package org.example.task3;

public enum Status {
    SLEEP("Sleep"),
    NORMAL("Normal"),
    CONFUSED("Confused"),
    DEAD("Dead"),
    SICK("Sick"),
    HARD_SICK("Hard sick");

    private final String text;

    Status(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
