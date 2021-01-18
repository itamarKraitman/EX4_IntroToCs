package tests;
import static org.junit.jupiter.api.Assertions.*;
import geometry.Point2D;
import org.junit.jupiter.api.Test;

public class Point2DTest {

    private Point2D p1 = new Point2D(1,2);
    private final double EPS = 0.1;
//8.062258
    @Test
    void testPoint2D() {
        assertEquals(new Point2D(p1).x(), p1.x());
        assertEquals(new Point2D(p1).y(), p1.y());
        assertEquals(new Point2D("1,2"), new Point2D(1, 2));
        assertEquals(p1, new Point2D(1, 2));
        assertEquals(new Point2D("-2,4"), new Point2D(-2, 4));
        try {
            assertEquals("ERR: got wrong format string for Point2D init, got: a,2 should be of format: x,y"
                    , new Point2D("a,2"));
        }
        catch (IllegalArgumentException e){
            System.err.println("Test succeed, illegal argument");
        }
        try {
            assertEquals("ERR: got wrong format string for Point2D init, got: a,2 should be of format: x,y"
                    , new Point2D("2,%"));
        }
        catch (IllegalArgumentException e){
            System.out.println("Test succeed, illegal argument");
        }
    }

    @Test
    void addTest(){
        Point2D testPoint = new Point2D(3,4);
        Point2D po = new Point2D(-2,-5);
        assertEquals(testPoint, p1.add(new Point2D(2,2)));
        assertEquals(new Point2D(2,3), testPoint.add(new Point2D(-1,-1)));
        assertEquals(new Point2D(1,-1), po.add(new Point2D(testPoint)));
    }

    @Test
    void testDistance(){
        Point2D p2 = new Point2D(-7,-4);
        assertEquals(Math.sqrt(65), p2.distance());
        Point2D p4 = new Point2D(10 ,-5);
        assertEquals(Math.sqrt(290), p4.distance(p2));
        assertEquals(2 * Math.sqrt(26) , Point2D.ORIGIN.distance(new Point2D(-2, -10)));
        assertEquals(new Point2D(10,0).distance(), 10);

    }

    @Test
    void testEquals(){
        assertTrue(p1.equals(new Point2D(p1)));
        assertNotEquals(true, p1.equals(25));
        assertFalse(new Point2D(Point2D.ORIGIN).equals(new Point2D(-20, -694)));
        assertEquals(false, new Point2D(34,-54).equals(new Point2D(34,54)));
    }

    @Test
    void testVector(){
        Point2D target = new Point2D(3,4);
        assertNotEquals(new Point2D(20,3), p1.vector(target));
        assertEquals(new Point2D(2,2), p1.vector(target));
        assertNotEquals(Point2D.ORIGIN, p1.vector(target));
        assertNotEquals(target.vector(p1), p1.vector(target));
    }
    @Test
    void TestMove() {
        Point2D ans = new Point2D(2, 3);
        ans.move(new Point2D(5, 5));
        assertEquals(ans, new Point2D(7 ,8));
        ans = new Point2D(-5, 0);
        ans.move(new Point2D(0, 0));
        assertEquals(ans, new Point2D(-5,0));
    }

    @Test
    void testCopy(){
        assertEquals(p1, p1.copy());
        assertNotEquals(p1, new Point2D(3,4));
    }

    @Test
    void testGetPoints(){
        Point2D[] ans = p1.getPoints();
        Point2D[] p1Container = new Point2D[1];
        p1Container[0] = new Point2D(1,2);
        assertArrayEquals(ans, p1Container);
    }

    @Test
    void testToString(){
        assertEquals(p1.toString(),"1.0,2.0");
        Point2D po = new Point2D(4,-1);
        Point2D po1 = new Point2D(-4,1);
        Point2D po2 = new Point2D(-4,-1);
        assertEquals(po.toString(), "4.0,-1.0");
        assertEquals(po1.toString(), "-4.0,1.0");
        assertEquals(po2.toString(), "-4.0,-1.0");
    }

    @Test
    void testClose2equals(){
        Point2D p2 = new Point2D(1.01,2);
        assertTrue(p1.close2equals(p2, EPS));
        Point2D p3 = new Point2D(1.1,2);
        assertFalse(p1.close2equals(p3, EPS));
    }
    @Test
    void testContains(){
        Point2D p1 = new Point2D(1,1);
        Point2D p2 = new Point2D(-4,6);
        Point2D p3 = new Point2D(1,1);
        assertTrue(p1.contains(p3));
        assertFalse(p1.contains(p2));
    }
}
