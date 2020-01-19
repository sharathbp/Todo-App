package com.onedirect.todo.enums;

public enum PriorityEnum {
    HIGH_PRIORITY((byte) 0),
    MEDIUM_PRIORITY((byte) 1),
    LOW_PRIORITY((byte) 2),
    NO_PRIORITY((byte) 3);

    private byte id;

    PriorityEnum(byte id) {
        this.id = id;
    }

    public byte getId() {
        return id;
    }
}
