package tests;
import static org.junit.jupiter.api.Assertions.*;
import geometry.Circle2D;
import geometry.Point2D;
import org.junit.jupiter.api.Test;

public class Circle2DTest {
    //testing class of Circle2D class
    private Circle2D c1 = new Circle2D(new Point2D(1,3), 5);

    @Test
    void testConstructors(){
        Circle2D c1 = new Circle2D();
        Circle2D c2 = new Circle2D(c1);
        Circle2D c3 = new Circle2D(new Point2D(3,4), 6);
        Circle2D c4 = new Circle2D(new Point2D(3,4), -5);//in case of negative input for radius
        assertEquals(c2.getPoints()[0], c1.getPoints()[0]);
        assertNotEquals(c2.toString(), c3.toString());
        assertNotEquals(c2.toString(), c3.toString());
        assertNotEquals(c1.toString(), c3.toString());
        assertEquals(c4.getRadius(), 1);//should be default value


    }

    @Test
    void testContains(){
        assertFalse(c1.contains(new Point2D(6, -1)));
        assertTrue((c1.contains(new Point2D(1, 4))));
        assertTrue((c1.contains(new Point2D(1,3))));
        assertFalse(c1.contains(new Point2D(7,3)));
    }

    @Test
    void testGetPoints(){
        Circle2D[] testing = new Circle2D[4];
        testing[0] = new Circle2D(new Point2D(2,3), 5);
        testing[1] = new Circle2D(new Point2D(-2,3), 7);
        testing[2] = new Circle2D(new Point2D(2,-3), 9);
        testing[3] = new Circle2D(new Point2D(4,0), 3);
        for (Circle2D circle2D : testing) {
            Point2D[] ans = circle2D.getPoints();
            Point2D center = new Point2D(circle2D.get_center());
            Point2D radius = new Point2D(circle2D.get_center().x(), circle2D.get_center().y() + circle2D.getRadius());
            Point2D[] areEquals = {center, radius};
            assertArrayEquals(ans, areEquals);
        }
    }
    @Test
    void testCopy(){
        Circle2D test1 = new Circle2D(new Point2D(4,7), 1);
        Circle2D test2 = new Circle2D(new Point2D(-4, -7), 3);
        Circle2D test3 = new Circle2D(new Point2D(-4, 7), 5);
        Circle2D test4 = new Circle2D(new Point2D(5, 0), 2);
        assertArrayEquals(test1.copy().getPoints(), test1.getPoints());
        assertArrayEquals(test2.copy().getPoints(), test2.getPoints());
        assertArrayEquals(test3.copy().getPoints(), test3.getPoints());
        assertArrayEquals(test4.copy().getPoints(), test4.getPoints());
    }
    @Test
    void tesToString(){
        Circle2D test1 = new Circle2D(new Point2D(4,7), 1);
        Circle2D test2 = new Circle2D(new Point2D(-4, -7), 3);
        Circle2D test3 = new Circle2D(new Point2D(-4, 7), 5);
        Circle2D test4 = new Circle2D(new Point2D(5, 0), 2);
        assertEquals(test1.toString(),"4.0,7.0, 1.0");
        assertEquals(test2.toString(),"-4.0,-7.0, 3.0");
        assertEquals(test3.toString(),"-4.0,7.0, 5.0");
        assertEquals(test4.toString(),"5.0,0.0, 2.0");
    }
    @Test
    void testMove(){
        Circle2D test1 = new Circle2D(new Point2D(4,7), 1);
        Circle2D test2 = new Circle2D(new Point2D(-4, -7), 3);
        Circle2D test3 = new Circle2D(new Point2D(-4, 7), 5);
        Circle2D test4 = new Circle2D(new Point2D(5, 0), 2);
        test1.move(new Point2D(3, 3));
        assertEquals(test1.toString(), new Circle2D(new Point2D(7,10),1).toString());
        test2.move(new Point2D(3, 4));
        assertEquals(test2.toString(), new Circle2D(new Point2D(-1,-3), 3).toString());
        test3.move(new Point2D(-5,-2));
        assertEquals(test3.toString(), new Circle2D(new Point2D(-9,5), 5).toString());
        test4.move(new Point2D(-2,6));
        assertEquals(test4.toString(), new Circle2D(new Point2D(3,6), 2).toString());
    }
    @Test
    void testAreaAndPerimeter(){//testing both area() and perimeter()
        Circle2D c1 = new Circle2D(new Point2D(1,3), 5);
        Circle2D c2 = new Circle2D(new Point2D(1,3), 0);//degenerate circle
        assertEquals(c1.area(),25 * Math.PI);
        assertEquals(c2.area(), 0);
        assertEquals(c1.perimeter(), 2 * Math.PI * 5);
        assertEquals(c2.perimeter(), 0);
    }
}
