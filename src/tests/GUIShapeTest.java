package tests;
import static org.junit.jupiter.api.Assertions.*;

import ex4.GUIShape;
import geometry.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class GUIShapeTest {
    GUIShape gui1 = new GUIShape(new Rect2D(new Point2D(1,1), new Point2D(4,4)), false, Color.white, 1);
    GUIShape gui2 = new GUIShape(new Circle2D(new Point2D(1,1), 4), true, Color.red, 0);
    GUIShape gui3 = new GUIShape(new Segment2D(new Point2D(-1,3), new Point2D(2,6)), false, Color.green, 1);
    GUIShape gui4 = new GUIShape(new Triangle2D(new Point2D(-2,-2),new Point2D(3,2), new Point2D(8,7)), true, Color.BLACK, 0);
    GUIShape gui5 = new GUIShape();

    @Test
    void testCOnstructors(){
        GUIShape gui10 = new GUIShape(new Rect2D(new Point2D(1,1), new Point2D(4,4)), false, Color.white, 1);
        GUIShape gui14 = new GUIShape(gui10);
        GUIShape g1 = new GUIShape();
        GUIShape g2 = new GUIShape(new Point2D(0,0), true, Color.red, 1);
        assertEquals(gui10.toString(), gui14.toString());
        assertEquals(g1.toString(), g2.toString());
    }
    @Test
    void testGetShape(){
        assertTrue(gui1.getShape() instanceof Rect2D);
        assertTrue(gui2.getShape() instanceof Circle2D);
        assertTrue(gui3.getShape() instanceof  Segment2D);
        assertTrue(gui4.getShape() instanceof Triangle2D);
        assertTrue(gui5.getShape() instanceof  Point2D);
        System.out.println("Test succeed");
    }
    @Test
    void testSetShape(){
        gui1.setShape(new Circle2D(new Point2D(1,1),1));
        assertTrue(gui1.getShape() instanceof Circle2D);
        gui2.setShape(new Point2D(1,1));
        assertTrue(gui2.getShape() instanceof  Point2D);
        gui3.setShape(new Point2D(1,1));
        assertTrue(gui3.getShape() instanceof  Point2D);
        gui4.setShape(new Point2D(1,1));
        assertTrue(gui4.getShape() instanceof  Point2D);
        gui5.setShape(new Segment2D(new Point2D(1,2), new Point2D(3,4)));
        assertTrue(gui5.getShape() instanceof  Segment2D);
        System.out.println("Test succeed");
    }
    @Test
    void testIsFilled(){
        assertFalse(gui1.isFilled());
        assertTrue(gui2.isFilled());
        assertFalse(gui3.isFilled());
        assertTrue(gui4.isFilled());
        assertTrue(gui5.isFilled());
        System.out.println("Test succeed");
    }
    @Test
    void testSetFilled(){
        gui1.setFilled(true);
        gui2.setFilled(false);
        gui3.setFilled(true);
        gui4.setFilled(false);
        gui5.setFilled(false);
        assertTrue(gui1.isFilled());
        assertFalse(gui2.isFilled());
        assertTrue(gui3.isFilled());
        assertFalse(gui4.isFilled());
        assertFalse(gui5.isFilled());
        System.out.println("Test succeed");
    }
    @Test
    void testGetColor(){
        assertEquals(gui1.getColor(), Color.white);
        assertEquals(gui2.getColor(), Color.red);
        assertEquals(gui3.getColor(), Color.green);
        assertEquals(gui4.getColor(), Color.black);
        assertEquals(gui5.getColor(), Color.red);
        System.out.println("Test succeed");
    }
    @Test
    void testSetColor(){
        gui1.setColor(Color.red);
        gui2.setColor(Color.yellow);
        gui3.setColor(Color.blue);
        gui4.setColor(Color.pink);
        gui5.setColor(Color.gray);
        assertEquals(gui1.getColor(), Color.red);
        assertEquals(gui2.getColor(), Color.yellow);
        assertEquals(gui3.getColor(), Color.blue);
        assertEquals(gui4.getColor(), Color.pink);
        assertEquals(gui5.getColor(), Color.gray);
        System.out.println("Test succeed");
    }
    @Test
    void testGetTag(){
        assertEquals(gui1.getTag(), 1);
        assertEquals(gui2.getTag(), 0);
        assertEquals(gui3.getTag(), 1);
        assertEquals(gui4.getTag(), 0);
        assertEquals(gui5.getTag(), 1);
        System.out.println("Testing succeed");

    }
    @Test
    void testSetTag(){
        gui1.setTag(0);
        assertEquals(0, gui1.getTag());
        gui2.setTag(1);
        assertEquals(1,gui2.getTag());
        gui3.setTag(0);
        assertEquals(0,gui3.getTag());
        gui4.setTag(1);
        assertEquals(1, gui4.getTag());
        gui5.setTag(0);
        assertEquals(0, gui5.getTag());
        System.out.println("Testing succeed");

    }
    @Test
    void testCopy(){
        GUIShape test1 = (GUIShape) gui1.copy();
        assertTrue(test1.getShape() instanceof Rect2D);
        assertEquals(test1.getColor(), Color.white);
        assertFalse(test1.isFilled());
        assertEquals(test1.getTag(),1);
        System.out.println("Testing succeed");
    }
    @Test
    void testToString(){
        assertEquals(gui1.toString(), (gui1.getColor().getRGB()&0xffffff) + "," + (gui1.isFilled()) + "," + (gui1.getTag()) + "," + (gui1.getShape().getClass().getSimpleName()) + "," + (gui1.getShape().toString()));
        assertEquals(gui2.toString(), (gui2.getColor().getRGB()&0xffffff) + "," + (gui2.isFilled()) + "," + (gui2.getTag()) + "," + (gui2.getShape().getClass().getSimpleName()) + "," + (gui2.getShape().toString()));
        assertEquals(gui3.toString(), (gui3.getColor().getRGB()&0xffffff) + "," + (gui3.isFilled()) + "," + (gui3.getTag()) + "," + (gui3.getShape().getClass().getSimpleName()) + "," + (gui3.getShape().toString()));
        assertEquals(gui4.toString(), (gui4.getColor().getRGB()&0xffffff) + "," + (gui4.isFilled()) + "," + (gui4.getTag()) + "," + (gui4.getShape().getClass().getSimpleName()) + "," + (gui4.getShape().toString()));
        assertEquals(gui5.toString(), (gui5.getColor().getRGB()&0xffffff) + "," + (gui5.isFilled()) + "," + (gui5.getTag()) + "," + (gui5.getShape().getClass().getSimpleName()) + "," + (gui5.getShape().toString()));
        System.out.println("Testing succeed");

    }
}
