package ex4;

import java.awt.Color;

import geometry.*;

/**
 * This class is the "main" class which will be constructed and run as in (Test_Ex4).
 * Ex4: you should implement this class!
 *
 * @author boaz.benmoshe
 */
public class Ex4 implements Ex4_GUI {

    private static GUI_Shape_Collection gsc;

    public static void main(String[] args) {

        GUI_Shape_Collection sc = new Shape_Collection();

        // Load args
        String file = args[0];
        sc.load(file);
        int sortNum = Integer.parseInt(args[1]);
        Shape_Comp comp = new Shape_Comp(sortNum);
        sc.sort(comp);

        // Fix scale
        Rect2D bb = sc.getBoundingBox();
        Point2D min = bb.getPoints()[0], max = bb.getPoints()[1];
        System.out.println(bb.toString());
        double m0 = Math.min(min.x(), min.y());
        double m1 = Math.max(max.x(), max.y());
        StdDraw.setScale(m0-0.1,m1+0.1);

        // Show
        Ex4 win = new Ex4();
        win.init(sc);
        win.show();
    }
    //constructor
    public Ex4() {
        gsc = new Shape_Collection();
    }

    //initializing Ex4 object with a GUI_Shape_Collection
    //input: GUI_Shape_Collection
    //output: none
    @Override
    public void init(GUI_Shape_Collection g) {
        gsc = g.copy();
    }

    //returns the shape_collection that stored in Ex4 object
    //input: none
    //output: GUI_Shape_Collection
    @Override
    public GUI_Shape_Collection getShape_Collection() {
        return gsc;
    }

    //drawing the GUIShapes which are stored in the collection
    //input: none
    //output: drawing the GUIshapes
    @Override
    public void show() {
        int i = 0;
        StdDraw.setPenRadius();
        while (i < gsc.size()) {
            GUI_Shape current = this.getShape_Collection().get(i);
            System.out.println(current);
            StdDraw.setPenColor(current.getColor());
            if (current.getShape() instanceof Point2D) {
                double xValue = ((Point2D) current.getShape()).x();
                double yValue = ((Point2D) current.getShape()).y();
                StdDraw.point(xValue, yValue);
            }
            if (current.getShape() instanceof Circle2D) {
                double CxValue = current.getShape().centerOfMass().x();
                double CyValue = current.getShape().centerOfMass().y();
                if (current.isFilled())
                    StdDraw.filledCircle(CxValue, CyValue, ((Circle2D) current.getShape()).getRadius());
                else
                    StdDraw.circle(CxValue, CyValue, ((Circle2D) current.getShape()).getRadius());
            }
            if (current.getShape() instanceof Segment2D) {
                double xValue1 = ((Segment2D) current.getShape()).getEnd1().x();
                double yValue1 = ((Segment2D) current.getShape()).getEnd1().y();
                double xValue2 = ((Segment2D) current.getShape()).getEnd2().x();
                double yValue2 = ((Segment2D) current.getShape()).getEnd2().y();
                StdDraw.line(xValue1, yValue1, xValue2, yValue2);
            }
            if (current.getShape() instanceof Triangle2D) {
                double[] xValues = {((Triangle2D) current.getShape()).getVerticeOne().x(), ((Triangle2D) current.getShape()).getVerticeTwo().x(), ((Triangle2D) current.getShape()).getVerticeThree().x()};
                double[] yValues = {((Triangle2D) current.getShape()).getVerticeOne().y(), ((Triangle2D) current.getShape()).getVerticeTwo().y(), ((Triangle2D) current.getShape()).getVerticeThree().y()};
                if (current.isFilled()) {
                    StdDraw.filledPolygon(xValues, yValues);
                } else {
                    StdDraw.polygon(xValues, yValues);
                }
            }
            if (current.getShape() instanceof Rect2D) {
               double xValue = current.getShape().centerOfMass().x();
               double yValue = current.getShape().centerOfMass().y();
               double halWidth = Math.abs((((Rect2D) current.getShape()).getRightUAngle().x() - ((Rect2D) current.getShape()).getLeftAAngle().x()) / 2);
                double halfLength = Math.abs((((Rect2D) current.getShape()).getRightUAngle().y() - ((Rect2D) current.getShape()).getLeftAAngle().y()) / 2);
                if (current.isFilled()) {
                    StdDraw.filledRectangle(xValue, yValue, halWidth, halfLength);
                } else {
                    StdDraw.rectangle(xValue, yValue, halWidth, halfLength);
                }
            }
            i++;
        }
    }

    //returns a string that represent the Ex4
    //input: none
    //output: string
    @Override
    public String getInfo() {
        return this.toString();
    }

}
