package com.fieryslug.verbum.util.enumer;

import net.minecraft.util.IStringSerializable;

public enum  EnumAxis implements IStringSerializable {


    X(1), Y(2), Z(3), NONE(0);

    private int ordinal;

    private EnumAxis(int ordinal) {

        this.ordinal = ordinal;

    }

    public int getOrdinal() {
        return this.ordinal;
    }


    @Override
    public String getName() {
        switch(this.ordinal) {

            case 0:
                return "none";
            case 1:
                return "x";
            case 2:
                return "y";
            case 3:
                return "z";
        }

        return "default";
    }
}
