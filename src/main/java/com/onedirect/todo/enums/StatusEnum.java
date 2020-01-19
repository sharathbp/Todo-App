package com.onedirect.todo.enums;

public enum StatusEnum {
    INCOMPLETE((byte) 0),
    COMPLETE((byte) 1),
    DELETED ((byte) 2);

    private byte id;

    StatusEnum(byte id) {
        this.id = id;
    }

    public byte getId() {
        return id;
    }
}
