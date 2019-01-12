package com.fieryslug.verbum.util.enumer;

public enum  EnumCondition {

    NEUTRAL(0), WET(1), DRY(2);

    private int ordinal;

    private EnumCondition(int ordinal) {
        this.ordinal = ordinal;
    }

    public int getOrdinal() {
        return this.ordinal;
    }

}
