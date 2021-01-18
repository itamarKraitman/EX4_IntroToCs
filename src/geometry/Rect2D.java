package geometry;

/**
 * This class represents a 2D axis parallel rectangle.
 * Ex4: you should implement this class!
 *
 * @author I2CS
 */
public class Rect2D implements GeoShape {
    //features
    private Point2D leftLAngle;
    private Point2D rightUAngle;

    //constructors
    public Rect2D() {
        this.leftLAngle = new Point2D(0, 1);
        this.rightUAngle = new Point2D(1, 0);
    }

    public Rect2D(Point2D first, Point2D second) {
        if (first.y() > second.y()) {
            if (first.x() > second.x()) {
                this.leftLAngle = new Point2D(second);
                this.rightUAngle = new Point2D(first);
            }
            else if (first.x() < second.x()) {
                this.rightUAngle = new Point2D(second.x(), first.y());
                this.leftLAngle = new Point2D(first.x(), second.y());
            }
            else {
                this.leftLAngle = new Point2D(second);
                this.rightUAngle = new Point2D(first);
            }
        }
        else if (second.y() > first.y()) {
            if (second.x() > first.x()) {
                this.rightUAngle = new Point2D(second);
                this.leftLAngle = new Point2D(first);
            }
            else if (second.x() < first.x()) {
                this.leftLAngle = new Point2D(second.x(), first.y());
                this.rightUAngle = new Point2D(first.x(), second.y());
            }
            else {
                this.leftLAngle = new Point2D(first);
                this.rightUAngle = new Point2D(second);
            }
        }
        else {
           if(first.x() > second.x()){
               this.leftLAngle = new Point2D(second);
               this.rightUAngle = new Point2D(first);
           }
           else{
               this.rightUAngle = new Point2D(second);
               this.leftLAngle = new Point2D(first);
           }
        }
    }

    //copping constructor
    public Rect2D(Rect2D rec) {
        this.rightUAngle = new Point2D(rec.rightUAngle);
        this.leftLAngle = new Point2D(rec.leftLAngle);
    }

    //getters and setters
    //needed although move() to cases we want to change only one of the angele
    public Point2D getLeftAAngle() {
        return leftLAngle;
    }

    public void setLeftAAngle(Point2D leftAAngle) {
        this.leftLAngle = leftAAngle;
    }

    public Point2D getRightUAngle() {
        return rightUAngle;
    }

    public void setRightUAngle(Point2D rightUAngle) {
        this.rightUAngle = rightUAngle;
    }

    //computes and returns if a point falls with in the rectangle
    //input: Point2D ot
    //output: true if with in false if not
    @Override
    public boolean contains(Point2D ot) {
        return (this.leftLAngle.x() <= ot.x() && this.rightUAngle.x() >= ot.x()
                && this.leftLAngle.y() <= ot.y() && this.rightUAngle.y() >= ot.y());
    }

    //computes the values of center of mass (x,y)
    //input: none
    //output: return Point2D that represents the center of mass
    @Override
    public Point2D centerOfMass() {
        double centerX = (this.rightUAngle.x() + this.leftLAngle.x()) / 2;
        double centerY = (this.rightUAngle.y() + this.leftLAngle.y()) / 2;
        return new Point2D(centerX, centerY);
    }

    //computes and return the area of a rectangle
    //input: none
    //output: return double value represents area
    @Override
    public double area() {
        double length = this.rightUAngle.x() - this.leftLAngle.x();
        double width = this.rightUAngle.y() - this.leftLAngle.y();
        return length * width;
    }

    //computes and return the perimeter of a rectangle
    //input: none
    //output: return pdouble value represents the perimeter of a rectangle
    @Override
    public double perimeter() {
        if (this.leftLAngle.x() == this.rightUAngle.x()) {//in case of degenerate rectangle
            return Math.abs((this.leftLAngle.y() - this.rightUAngle.y()) * 2);
        }
        if (this.rightUAngle.y() == this.leftLAngle.y()) {
            return Math.abs((this.leftLAngle.x() - this.rightUAngle.x()) * 2);
        }
        double length = Math.abs(this.rightUAngle.x() - this.leftLAngle.x());
        double width = Math.abs(this.rightUAngle.y() - this.leftLAngle.y());
        return (2 * length + 2 * width);
    }

    //moving the rectangle according a vector (x,y)
    ////input: Point2D vector
    //output: rectangle in another position
    @Override
    public void move(Point2D vec) {
        this.leftLAngle = new Point2D(this.leftLAngle.add(vec));
        this.rightUAngle = new Point2D(this.rightUAngle.add(vec));

    }

    //making a copy of the rectangle
    //input: none
    //output: returns copy of the rectangle
    @Override
    public GeoShape copy() {
        return new Rect2D(this.leftLAngle, this.rightUAngle);
    }

    //maikng an Point2D array which contains all te points represent the rectangle
    //input: none
    //output: Point2D arr
    @Override
    public Point2D[] getPoints() {
        Point2D[] ans = new Point2D[2];
        ans[0] = this.leftLAngle;
        ans[1] = this.rightUAngle;
        return ans;
    }

    //computes a String represent the rectangle by two points
    //input: none
    //output: String represent the rectangle
    @Override
    public String toString() {
        return "" + this.leftLAngle.toString() + "," + this.rightUAngle.toString();
    }

    public static void main(String[] args) {
        Rect2D r3 = new Rect2D(new Point2D(2,2), new Point2D(4, 0));
//        System.out.println(r3.toString());
        Point2D vec = new Point2D(1,1);
        Rect2D r4 = new Rect2D(vec,vec);
        System.out.println(r4.toString());
        r4.move(vec);
        System.out.println(r4.toString());

    }


}
