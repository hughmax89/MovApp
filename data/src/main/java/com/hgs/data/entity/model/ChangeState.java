package com.hgs.data.entity.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ChangeState {
    UNCHANGED(0),
    CREATED(1),
    UPDATED(2),
    DELETED(3),
    DISABLED(4);

    private final int value;

    ChangeState(final int newValue) {
        value = newValue;
    }

    @JsonValue
    public int getValue() { return value; }

}

