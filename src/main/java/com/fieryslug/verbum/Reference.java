package com.fieryslug.verbum;

import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;

import javax.swing.event.ChangeListener;
import javax.swing.text.AttributeSet;
import java.awt.*;
import java.util.Enumeration;

public class Reference {

    public static final String MODID = "verbum";
    public static final String NAME = "Verbum";
    public static final String VERSION = "0.1";

    public static final String CLIENT = "com.fieryslug.verbum.proxy.ClientProxy";
    public static final String COMMON = "com.fieryslug.verbum.proxy.CommonProxy";

    public static final Style STYLE1 = new Style().setColor(TextFormatting.GREEN).setBold(true);

}
