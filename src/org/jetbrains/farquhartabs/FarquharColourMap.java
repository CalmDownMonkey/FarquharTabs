package org.jetbrains.farquhartabs;

import java.awt.*;

/**
 * Created by Will on 07/10/2015.
 */
public enum FarquharColourMap {

    red   (new Color(218, 5, 27), "red", new Color(255, 255, 255)),
    redOrange   (new Color(232, 73, 33), "redOrange", new Color(255, 255, 255)),
    orange   (new Color(239, 125, 29), "orange", new Color(255, 255, 255)),
    yellowOrange   (new Color(248, 179, 16), "yellowOrange",new Color(91, 91, 91)),
    yellow   (new Color(243, 229, 0), "yellow", new Color(91, 91, 91)),
    yellowGreen   (new Color(142, 183, 27), "yellowGreen",new Color(255, 255, 255)),
    green  (new Color(34, 149, 72), "green", new Color(255, 255, 255)),
    blueGreen  (new Color(0, 148, 170), "blueGreen", new Color(255, 255, 255)),
    blue  (new Color(31, 73, 149), "blue", new Color(255, 255, 255)),
    bluePurple  (new Color(23, 44, 133), "bluePurple", new Color(255, 255, 255)),
    purple  (new Color(79, 37, 119), "purple", new Color(255, 255, 255)),
    redPurple  (new Color(160, 7, 124), "redPurple", new Color(255, 255, 255));

    public final Color color;
    public final String name;
    public final Color font;

    FarquharColourMap(Color color, String name, Color font){
        this.color = color;
        this.name = name;
        this.font = font;
    }
}
