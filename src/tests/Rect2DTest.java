package tests;
import static org.junit.jupiter.api.Assertions.*;

import geometry.Point2D;
import geometry.Rect2D;
import org.junit.jupiter.api.Test;
public class Rect2DTest {
    //testing class of Rect2D class. according Lee-ad Gottlieb there is no need to test trivial methods
    @Test
    void testConstructors(){
        Rect2D r1 = new Rect2D();//default
        Rect2D r2 = new Rect2D(r1);
        assertEquals(r1.getRightUAngle(), r2.getRightUAngle());
        assertEquals(r1.getLeftAAngle(), r2.getLeftAAngle());
        assertEquals(r2.centerOfMass(), r1.centerOfMass());
        assertEquals(r1.toString(), r2.toString());
        Rect2D r3 = new Rect2D(new Point2D(1,1), new Point2D(1,5));
        Rect2D r4 = new Rect2D(new Point2D(1,3), new Point2D(5,3));
        assertEquals(r3.getLeftAAngle().y(), 1);
        assertEquals(r4.getRightUAngle().x(), 5);
    }

    @Test
    void testContains(){
        Rect2D r1 = new Rect2D(new Point2D(3,5), new Point2D(7,9));
        Rect2D r2 = new Rect2D(new Point2D(-2,2), new Point2D(4,4));
        Rect2D r3 = new Rect2D(new Point2D(-8,-4), new Point2D(-2,-2));
        Rect2D r4 = new Rect2D(new Point2D(0,0), new Point2D(4,3));
        assertTrue(r1.contains(new Point2D(4,7)));
        assertFalse(r1.contains(new Point2D(4,10)));
        assertTrue(r2.contains(new Point2D(-2,2)));
        assertFalse(r2.contains(new Point2D(4,5)));
        assertTrue(r3.contains(new Point2D(-8,-2)));
        assertFalse(r3.contains(new Point2D(0,0)));
        assertTrue(r4.contains(new Point2D(1,1)));
        assertFalse(r4.contains(new Point2D(0,-1)));
        assertTrue(r1.contains(new Point2D(3,5)));
    }
    @Test
    void centerOfMass(){
        Rect2D r1 = new Rect2D(new Point2D(3,5), new Point2D(7,9));
        Rect2D r2 = new Rect2D(new Point2D(-2,2), new Point2D(4,4));
        Rect2D r3 = new Rect2D(new Point2D(-8,-4), new Point2D(-2,-2));
        Rect2D r4 = new Rect2D(new Point2D(0,0), new Point2D(4,3));
        Rect2D r5 = new Rect2D(new Point2D(-0.04, 0.06), new Point2D(0.8,0.77));
        assertEquals(r1.centerOfMass(), new Point2D(5, 7));
        assertEquals(r2.centerOfMass(), new Point2D(1, 3));
        assertEquals(r3.centerOfMass(), new Point2D(-5, -3));
        assertEquals(r4.centerOfMass(), new Point2D(2, 1.5));
    }
    @Test
    void testArea(){
        Rect2D r1 = new Rect2D(new Point2D(3,5), new Point2D(7,9));
        Rect2D r2 = new Rect2D(new Point2D(-2,2), new Point2D(4,4));
        Rect2D r3 = new Rect2D(new Point2D(-8,-4), new Point2D(-2,2));
        Rect2D r4 = new Rect2D(new Point2D(0,0), new Point2D(4,3.5));
        Rect2D r5 = new Rect2D(new Point2D(1,1), new Point2D(1,3));
        assertEquals(r1.area(), 16.0);
        assertEquals(r2.area(), 12.0);
        assertEquals(r3.area(), 36.0);
        assertEquals(r4.area(), 14.0);
        assertEquals(r5.area(), 0);
    }
    @Test
    void testPerimeter(){
        Rect2D r1 = new Rect2D(new Point2D(3,5), new Point2D(7,9));
        Rect2D r2 = new Rect2D(new Point2D(-2,2), new Point2D(4,4));
        Rect2D r3 = new Rect2D(new Point2D(-8,-4), new Point2D(-2,2));
        Rect2D r4 = new Rect2D(new Point2D(0,0), new Point2D(4,3.5));
        Rect2D r5 = new Rect2D(new Point2D(1,4), new Point2D(1,7));
        Rect2D r6 = new Rect2D(new Point2D(2,3), new Point2D(6,3));
        assertEquals(r1.perimeter(), 16);
        assertEquals(r2.perimeter(), 16);
        assertEquals(r3.perimeter(), 24);
        assertEquals(r4.perimeter(), 15);
        assertEquals(r5.perimeter(), 6);
        assertEquals(r6.perimeter(), 8);
    }
    @Test
    void testMove(){//this testing methods using toString() so it's actually testing it as well
        Rect2D r1 = new Rect2D(new Point2D(3,5), new Point2D(7,9));
        Rect2D r2 = new Rect2D(new Point2D(-2,2), new Point2D(4,4));
        Rect2D r3 = new Rect2D(new Point2D(-8,-4), new Point2D(-2,2));
        Point2D vec = new Point2D(2,3);
        r1.move(vec);
        assertEquals(r1.toString(), new Rect2D(new Point2D(5,8), new Point2D(9,12)).toString());
        r2.move(vec);
        assertEquals(r2.toString(), new Rect2D(new Point2D(0,5), new Point2D(6,7)).toString());
        r3.move(vec);
        assertEquals(r3.toString(), new Rect2D(new Point2D(-6,-1), new Point2D(0,5)).toString());

    }
    @Test
    void testCopy(){
        Rect2D r1 = new Rect2D(new Point2D(3,5), new Point2D(7,9));
        Rect2D r2 = new Rect2D(new Point2D(-2,2), new Point2D(4,4));
        Rect2D r3 = new Rect2D(new Point2D(-8,-4), new Point2D(-2,2));
        Rect2D testR1 = (Rect2D) r1.copy();
        assertEquals(r1.toString(),testR1.toString());
        Rect2D testR2 = (Rect2D) r2.copy();
        assertEquals(r2.toString(),testR2.toString());
        Rect2D testR3 = (Rect2D) r3.copy();
        assertEquals(r3.toString(),testR3.toString());
    }
    @Test
    void testGetPoints(){
        Rect2D r1 = new Rect2D(new Point2D(3,5), new Point2D(7,9));
        Rect2D r2 = new Rect2D(new Point2D(-2,2), new Point2D(4,4));
        Rect2D r3 = new Rect2D(new Point2D(-8,-4), new Point2D(-2,2));
        Point2D[] testR1 = {new Point2D(3,5),new Point2D(7,9)};
        assertArrayEquals(testR1,r1.getPoints());
        Point2D[] testR2 = {new Point2D(-2,2),new Point2D(4,4)};
        assertArrayEquals(testR2,r2.getPoints());
        Point2D[] testR3 = {new Point2D(-8,-4),new Point2D(-2,2)};
        assertArrayEquals(testR3,r3.getPoints());


    }
}
