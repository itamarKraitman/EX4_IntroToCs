package tests;

import static org.junit.jupiter.api.Assertions.*;

import geometry.Point2D;
import geometry.Segment2D;
import org.junit.jupiter.api.Test;

public class Segment2DTest {
    //testing class of Rect2D class
    //toString() is used to test copy() means when it works toString() works as well
    @Test
    void testConstructors(){
        Segment2D s1 = new Segment2D();//deafult (0,0),(0,1)
        Segment2D s2 = new Segment2D(new Point2D(3,5), new Point2D(5,9));
        Segment2D s3 = new Segment2D(s2);
        assertEquals(s2.toString(), s3.toString());
        assertNotEquals(s1.toString(), s3.toString());
        assertEquals(s2.getEnd1(), s3.getEnd1());
        assertEquals(s2.getEnd2(), s3.getEnd2());
    }

    @Test
    void testContains() {
        Segment2D seg1 = new Segment2D(new Point2D(3, 5), new Point2D(5, 7));
        Segment2D seg2 = new Segment2D(new Point2D(3, 5), new Point2D(3, 7));
        Segment2D seg3 = new Segment2D(new Point2D(3, 7), new Point2D(5, 7));
        assertTrue(seg1.contains(new Point2D(4, 6)));
        assertFalse(seg1.contains(new Point2D(4, 7)));
        assertTrue(seg2.contains(new Point2D(3, 5.5)));
        assertFalse(seg2.contains(new Point2D(4, 5)));
        assertTrue(seg3.contains(new Point2D(4, 7)));
        assertFalse(seg3.contains(new Point2D(6, 7)));
    }

    @Test
    void testCenterOfMass() {
        Segment2D seg1 = new Segment2D(new Point2D(3, 5), new Point2D(5, 7));
        Segment2D seg2 = new Segment2D(new Point2D(3, 5), new Point2D(3, 7));
        Segment2D seg3 = new Segment2D(new Point2D(3, 7), new Point2D(5, 7));
        Segment2D seg4 = new Segment2D(new Point2D(3, 7), new Point2D(3, 7));
        Segment2D seg5 = new Segment2D(new Point2D(-3, -5), new Point2D(-5, -7));
        assertEquals(seg1.centerOfMass(), new Point2D(4, 6));
        assertEquals(seg2.centerOfMass(), new Point2D(3, 6));
        assertEquals(seg3.centerOfMass(), new Point2D(4, 7));
        assertEquals(seg4.centerOfMass(), seg4.getEnd1());
        assertEquals(seg5.centerOfMass(), new Point2D(-4, -6));
    }

    @Test
    void testPerimeter() {
        Segment2D seg1 = new Segment2D(new Point2D(3, 5), new Point2D(5, 7));
        Segment2D seg2 = new Segment2D(new Point2D(3, 5), new Point2D(3, 7));
        Segment2D seg3 = new Segment2D(new Point2D(3, 7), new Point2D(5, 7));
        Segment2D seg4 = new Segment2D(new Point2D(3, 7), new Point2D(3, 7));
        Segment2D seg5 = new Segment2D(new Point2D(-3, -5), new Point2D(-5, -7));
        Segment2D seg6 = new Segment2D(new Point2D(1, 1), new Point2D(1,1));
        assertEquals(seg1.perimeter(), 2 * (2 * Math.sqrt(2)));
        assertEquals(seg2.perimeter(), 4);
        assertEquals(seg3.perimeter(), 4);
        assertEquals(seg4.perimeter(), 0);
        assertEquals(seg5.perimeter(), 2 * (2 * Math.sqrt(2)));
        assertEquals(seg6.perimeter(), 0);
    }

    @Test
    void testMove() {
        Segment2D seg1 = new Segment2D(new Point2D(3, 5), new Point2D(5, 7));
        Segment2D seg2 = new Segment2D(new Point2D(-3, -5), new Point2D(-5, -7));
        Point2D vec = new Point2D(3, 4);
        seg1.move(vec);
        assertEquals(seg1.toString(), new Segment2D(new Point2D(6, 9), new Point2D(8, 11)).toString());
        seg2.move(vec);
        assertEquals(seg2.toString(), new Segment2D(new Point2D(0, -1), new Point2D(-2, -3)).toString());
    }

    @Test
    void testCopy() {
        Segment2D seg1 = new Segment2D(new Point2D(3, 5), new Point2D(5, 7));
        Segment2D seg2 = new Segment2D(new Point2D(-3, -5), new Point2D(-5, -7));
        Segment2D testS1 = (Segment2D) seg1.copy();
        Segment2D testS2 = (Segment2D) seg2.copy();
        assertEquals(seg1.toString(), testS1.toString());
        assertEquals(seg2.toString(), testS2.toString());
    }

    @Test
    void testGetPoints() {
        Segment2D seg1 = new Segment2D(new Point2D(3, 5), new Point2D(5, 7));
        Segment2D seg2 = new Segment2D(new Point2D(-3, -5), new Point2D(-5, -7));
        Point2D[] TestS1 = {new Point2D(3, 5), new Point2D(5, 7)};
        assertArrayEquals(TestS1, seg1.getPoints());
        Point2D[] TestS2 = {new Point2D(-3, -5), new Point2D(-5, -7)};
        assertArrayEquals(TestS2,seg2.getPoints());


    }
}
