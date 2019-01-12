package com.fieryslug.verbum.util.enumer;

public enum  EnumElement {

    AQUA(0), IGNIS(1), TERRA(2), AER(3), NIHIL(4);

    private int ordinal;

    private EnumElement(int ordinal) {

        this.ordinal = ordinal;

    }

    public int getOrdinal() {

        return this.ordinal;

    }

}
