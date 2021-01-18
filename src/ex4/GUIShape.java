package ex4;
/**
 * This class implements the GUI_shape.
 * Ex4: you should implement this class!
 *
 * @author I2CS
 */

import java.awt.Color;
import java.util.Arrays;


import geometry.*;

public class GUIShape implements GUI_Shape {
    //features
    private GeoShape GeoS;
    private boolean filled;
    private Color color;
    private int tag;

    //constructors
    public GUIShape(GeoShape GeoS, boolean filled, Color color, int tag) {
        this.GeoS = GeoS.copy();
        this.filled = filled;
        this.color = color;
        this.tag = tag;
    }

    public GUIShape(GUIShape otherGUI) {//copying constructor
        this.GeoS = otherGUI.GeoS;
        this.filled = otherGUI.filled;
        this.color = otherGUI.color;
        this.tag = otherGUI.tag;
    }

    public GUIShape() {//default
        this.GeoS = new Point2D(0, 0);
        this.filled = true;
        this.color = Color.red;
        this.tag = 1;
    }
    //returns the GeoShape of a GUIShape
    //input: none
    //output: GeoShape
    @Override
    public GeoShape getShape() {
        return this.GeoS;
    }
    //sets the shape of a GUIShape
    //input: GeoShape
    //output: none
    @Override
    public void setShape(GeoShape g) {
            this.GeoS = g.copy();
    }
    //returns if a GUIShape is filled or not
    //input: none
    //output: boolean value if filled or not
    @Override
    public boolean isFilled() {
        return this.filled;
    }
    //sets if GUIShape is filled or not
    //input: boolean value
    //output: none
    @Override
    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    //returns the color of GUIShape
    //input: none
    //output: the color of GUIShape
    @Override
    public Color getColor() {
        return this.color;
    }
    //sets the color of GUIShape
    //input: new color value
    //output: none
    @Override
    public void setColor(Color cl) {
        this.color = cl;
    }
    //returns the tag of GUIShape
    //input: none
    //output: int value of a GUIShape tag
    @Override
    public int getTag() {
        return this.tag;
    }
    //set the tag of a GUIShape
    //input: int value
    //output: none
    @Override
    public void setTag(int tag) {
        this.tag = tag;
    }
    //returns a copy of the GUIShape
    //input: none
    //output: GUIShpae which is a copy of another
    @Override
    public GUI_Shape copy() {
        return new GUIShape(this);
    }
    //returns a string represent the GUIShape
    //input: none
    //output: String represent the GUIShape
    @Override
    public String toString() {
        //GUIShape,255,false,0,Point2D,0.2,0.4
        int col = this.color.getRGB()&0xffffff;
        return col + "," + this.isFilled() + "," + this.getTag() + "," + this.GeoS.getClass().getSimpleName() + "," + this.GeoS.toString();
    }

}
