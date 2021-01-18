package tests;
import static org.junit.jupiter.api.Assertions.*;

import geometry.Point2D;
import geometry.Triangle2D;
import org.junit.jupiter.api.Test;
public class Triangle2DTest {
    //toString method is checked with on other tests
    private final double EPS = 0.0001;

    @Test
    void testConstructors(){
        Triangle2D t1 = new Triangle2D();
        Triangle2D t2 = new Triangle2D(new Point2D(2,5), new Point2D(5,9), new Point2D(-1,4));
        Triangle2D t3 = new Triangle2D(t1);
        assertEquals(t1.area(), t3.area());
        assertEquals(t1.toString(), t3.toString());
    }

    @Test
    void testContains(){//contains() using area() so while contains is working successfully it means are() is working as well
        Triangle2D t1 = new Triangle2D(new Point2D(1,3), new Point2D(3,3), new Point2D(2,5));
        assertTrue(t1.contains(new Point2D(1,3)));//in case ot is on one of vertices
        assertTrue(t1.contains(new Point2D(2,3)));//in case ot is on one of sides
        assertTrue(t1.contains(new Point2D(2,4)));
        assertFalse(t1.contains(new Point2D(4,3)));
    }
    @Test
    void testCenterOfMass(){
        Triangle2D t1 = new Triangle2D(new Point2D(1,3), new Point2D(3,3), new Point2D(2,5));
        Triangle2D t2 = new Triangle2D(new Point2D(1,3), new Point2D(3,3), new Point2D(5,3));//degenerate parallel to X
        Triangle2D t3 = new Triangle2D(new Point2D(1,3), new Point2D(1,5), new Point2D(1,7));//degenerate parallel to Y
        assertEquals(t1.centerOfMass(), new Point2D(2, (double) 11 / 3));
        assertEquals(t2.centerOfMass(), new Point2D(3,3));//in case of degenerate - parallel to X
        assertEquals(t3.centerOfMass(), new Point2D(1,5));//in case of degenerate- parallel to Y
    }
    @Test
    void testPerimeter(){
        Triangle2D t1 = new Triangle2D(new Point2D(1,3), new Point2D(3,3), new Point2D(2,5));
        Triangle2D t2 = new Triangle2D(new Point2D(1,3), new Point2D(3,3), new Point2D(5,3));//degenerate parallel to X
        Triangle2D t3 = new Triangle2D(new Point2D(1,3), new Point2D(1,5), new Point2D(1,7));//degenerate parallel to Y
        assertEquals(t1.perimeter(), 6.4721, EPS);
        assertEquals(t2.perimeter(), 8);//degenerate triangle
        assertEquals(t3.perimeter(), 8);//degenerate triangle
    }
    @Test
    void testMove() {
        Triangle2D t1 = new Triangle2D(new Point2D(1, 3), new Point2D(3, 3), new Point2D(2, 5));
        Triangle2D t2 = new Triangle2D(new Point2D(1, 3), new Point2D(3, 3), new Point2D(5, 3));//degenerate parallel to X
        Triangle2D t3 = new Triangle2D(new Point2D(1, 3), new Point2D(1, 5), new Point2D(1, 7));//degenerte parallel to Y
        Point2D vec = new Point2D(3,4);
        t1.move(vec);
        assertEquals(t1.getVerticeOne(), new Point2D(4,7));
        assertEquals(t1.getVerticeTwo(), new Point2D(6,7));
        assertEquals(t1.getVerticeThree(), new Point2D(5,9));
        t2.move(vec);
        assertEquals(t2.toString(), new Triangle2D(new Point2D(4,7), new Point2D(6,7), new Point2D(8,7)).toString());
        t3.move(vec);
        assertEquals(t3.toString(), new Triangle2D(new Point2D(4,7), new Point2D(4,9), new Point2D(4,11)).toString());
    }
    @Test
    void testCopy(){
        Triangle2D t1 = new Triangle2D(new Point2D(1, 3), new Point2D(3, 3), new Point2D(2, 5));
        Triangle2D t2 = new Triangle2D(new Point2D(1, 3), new Point2D(3, 3), new Point2D(5, 3));//degenerate parallel to X
        Triangle2D t3 = new Triangle2D(new Point2D(1, 3), new Point2D(1, 5), new Point2D(1, 7));//degenerte parallel to Y
        Triangle2D test1 = (Triangle2D) t1.copy();
        Triangle2D test2 = (Triangle2D) t2.copy();
        Triangle2D test3 = (Triangle2D) t3.copy();
        assertEquals(t1.toString(),test1.toString());
        assertEquals(t2.toString(),test2.toString());
        assertEquals(t3.toString(),test3.toString());
    }
    @Test
    void testGetPoints(){
        Triangle2D t1 = new Triangle2D(new Point2D(1, 3), new Point2D(3, 3), new Point2D(2, 5));
        Triangle2D t2 = new Triangle2D(new Point2D(1, 3), new Point2D(3, 3), new Point2D(5, 3));//degenerate parallel to X
        Triangle2D t3 = new Triangle2D(new Point2D(1, 3), new Point2D(1, 5), new Point2D(1, 7));//degenerte parallel to Y
        Point2D[] arrT1 = {new Point2D(1,3),new Point2D(3,3), new Point2D(2,5)};
        assertArrayEquals(arrT1, t1.getPoints());
        Point2D[] arrT2 = {new Point2D(1,3),new Point2D(3,3), new Point2D(5,3)};
        assertArrayEquals(arrT2, t2.getPoints());
        Point2D[] arrT3 = {new Point2D(1,3),new Point2D(1,5), new Point2D(1,7)};
        assertArrayEquals(arrT3, t3.getPoints());
    }
    @Test
    void testArea(){
        Triangle2D t1 = new Triangle2D(new Point2D(1, 3), new Point2D(3, 3), new Point2D(2, 5));
        Triangle2D t2 = new Triangle2D(new Point2D(1, 3), new Point2D(3, 3), new Point2D(5, 3));//degenerate parallel to X
        Triangle2D t3 = new Triangle2D(new Point2D(1, 3), new Point2D(1, 5), new Point2D(1, 7));//degenerte parallel to Y
        Triangle2D t4 = new Triangle2D(new Point2D(1,1), new Point2D(4,5), new Point2D(6,4));
        assertEquals(t1.area(), 2, EPS);
        assertEquals(t2.area(), 0);
        assertEquals(t3.area(),0);
        assertEquals(t4.area(),5.5);
    }
}
