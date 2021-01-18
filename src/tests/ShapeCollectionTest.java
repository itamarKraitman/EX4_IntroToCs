package tests;

import static org.junit.jupiter.api.Assertions.*;

import ex4.*;
import geometry.Point2D;
import geometry.Rect2D;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ShapeCollectionTest {

    GUI_Shape_Collection s1 = new Shape_Collection();

        GUIShape g1 = new GUIShape(new Point2D(5, 10), true, Color.blue, 1);
        GUIShape g2 = new GUIShape(new Point2D(-1, 1), false, Color.BLACK, 3);
        GUIShape g3 = new GUIShape(new Point2D(7, 5), true, Color.red, 4);

        @Test
        void testDefaultConstructor() {
            Shape_Collection s1 = new Shape_Collection();
            assertTrue(s1 instanceof Shape_Collection);
            assertEquals(s1.size(), 0);
        }

        @Test
        void testCopyConstructor() {
            Shape_Collection s1 = new Shape_Collection();
            s1.add(new GUIShape(new Point2D(1, 1), true, Color.BLACK, 1));
            Shape_Collection s2 = new Shape_Collection(s1);
            assertEquals(s1.get(0), s2.get(0));
        }

        @Test
        void testGet() {
            s1.add(g1);
            s1.add(g2);
            s1.add(g3);
            assertEquals(g1, s1.get(0));
            assertEquals(g2, s1.get(1));
            assertEquals(g3, s1.get(2));
        }

        @Test
        void testSize() {
            s1.add(g1);
            s1.add(g2);
            s1.add(g3);
            assertEquals(s1.size(), 3);
            s1.removeAll();
            assertEquals(s1.size(), 0);
        }

        @Test
        void testRemoveElementAt() {
            s1.add(g1);
            s1.add(g2);
            s1.add(g3);
            assertEquals(s1.removeElementAt(1), g2);
            assertEquals(s1.removeElementAt(1), g3);
            assertEquals(s1.removeElementAt(0), g1);
        }

        @Test
        void testAddAt() {
            s1.add(g1);
            s1.add(g2);
            s1.add(g3);
            GUIShape g4 = new GUIShape();
            s1.addAt(g4, 1);
            assertEquals(s1.get(1), g4);
        }

        @Test
        void testCopy() {
            s1.add(g1);
            s1.add(g2);
            s1.add(g3);
            Shape_Collection s2 = (Shape_Collection) s1.copy();
            assertEquals(s1.get(0), s2.get(0));
            assertEquals(s1.get(1), s2.get(1));
            assertEquals(s1.get(2), s2.get(2));
        }

        @Test
        void testRemoveAll() {
            s1.add(g1);
            s1.add(g2);
            s1.add(g3);
            s1.removeAll();
            assertEquals(s1.size(), 0);
        }

        @Test
        void testLoadAndSave() {
            s1.add(g1);
            s1.save("collection");
            Shape_Collection collection = new Shape_Collection();
            collection.load("collection");
            assertEquals(s1.size(), collection.size());
            for (int i = 0; i < s1.size(); i++) {
                assertEquals(s1.get(i).toString(), collection.get(i).toString());
            }
            assertEquals(s1.getBoundingBox().toString(), collection.getBoundingBox().toString());
        }

        @Test
        void testGetBoundingBox() {
            s1.add(g1);
            s1.add(g2);
            s1.add(g3);
            Rect2D shouldBe = s1.getBoundingBox();
            Rect2D testing = new Rect2D(new Point2D(-1, 1), new Point2D(7, 10));
            assertEquals(shouldBe.getLeftAAngle(), testing.getLeftAAngle());
            assertEquals(shouldBe.getRightUAngle(), testing.getRightUAngle());
        }

        @Test
        void testToString() {
            s1.add(g1);
            s1.add(g2);
            s1.add(g3);
            GUI_Shape_Collection s2 = s1.copy();
            assertEquals(s1.toString(), s2.toString());
        }

        @Test
        void testSort() {
            s1.add(g1);
            s1.add(g2);
            s1.add(g3);
            Shape_Comp comp = new Shape_Comp(0);
            s1.sort(comp);
            assertEquals(s1.get(0), g1);
            assertEquals(s1.get(1), g2);
            assertEquals(s1.get(2), g3);
            assertTrue(s1.get(0).getTag() <= s1.get(1).getTag() && s1.get(1).getTag() <= s1.get(2).getTag());

        }
    }



