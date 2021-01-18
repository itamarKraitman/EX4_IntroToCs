package geometry;

/**
 * This class represents a 2D Triangle in the plane.
 * Ex4: you should implement this class!
 *
 * @author I2CS
 */
public class Triangle2D implements GeoShape {
    //features
    private Point2D verticeOne;
    private Point2D verticeTwo;
    private Point2D verticeThree;

    /**
     * constructors
     */
    public Triangle2D() {//default constructor
        this.verticeOne = new Point2D(0, 0);
        this.verticeTwo = new Point2D(0, 1);
        this.verticeThree = new Point2D(0.5, 0.5);
    }

    public Triangle2D(Point2D verticeOne, Point2D verticeTwo, Point2D verticeThree) {//constructor by 3 values
        this.verticeOne = new Point2D(verticeOne);
        this.verticeTwo = new Point2D(verticeTwo);
        this.verticeThree = new Point2D(verticeThree);
    }

    public Triangle2D(Triangle2D triangle) {//copping constructor
        this.verticeOne = new Point2D(triangle.verticeOne);
        this.verticeTwo = new Point2D(triangle.verticeTwo);
        this.verticeThree = new Point2D(triangle.verticeThree);
    }
    public Point2D getVerticeOne() {
        return this.verticeOne;
    }

    public Point2D getVerticeTwo() {
        return this.verticeTwo;
    }

    public Point2D getVerticeThree() {
        return this.verticeThree;
    }

    //computes if Point2D is inside triangle
    //input: Point2D ot
    //output: boolean if ot is inside
    @Override
    public boolean contains(Point2D ot) {
        if (ot.equals(this.verticeOne) || ot.equals(this.verticeTwo) || ot.equals(this.verticeThree))//in case ot is on one of vertices
            return true;
        Segment2D s1 = new Segment2D(this.verticeOne, this.verticeTwo);
        Segment2D s2 = new Segment2D(this.verticeOne, this.verticeThree);
        Segment2D s3 = new Segment2D(this.verticeThree, this.verticeTwo);
        if (s1.contains(ot) || s2.contains(ot) || s3.contains(ot)) {
            return true;
        } else {
            double firstArea = new Triangle2D(this.verticeOne,this.verticeTwo,ot).area();
            double secondArea = new Triangle2D(this.verticeOne, this.verticeThree, ot).area();
            double thirdArea = new Triangle2D(this.verticeThree, this.verticeTwo, ot).area();
            return (area() == firstArea + secondArea + thirdArea);
        }
    }
    //computes center of mass
    //input: none
    //output: Point2D which located in the center of mass
    @Override
    public Point2D centerOfMass() {
        if(this.verticeOne.x() == this.verticeTwo.x() && this.verticeTwo.x() == this.verticeThree.x()){
            Segment2D seg = new Segment2D(this.verticeOne, this.verticeThree);
            return seg.centerOfMass();
        }
        if(this.verticeOne.y() == this.verticeTwo.y() && this.verticeTwo.y() == this.verticeThree.y()) {
            Segment2D seg = new Segment2D(this.verticeOne, this.verticeThree);
            return seg.centerOfMass();
        }
        double centerX = (this.verticeOne.x() + this.verticeTwo.x() + this.verticeThree.x()) / 3;
        double centerY = (this.verticeOne.y() + this.verticeTwo.y() + this.verticeThree.y()) / 3;
        return (new Point2D(centerX, centerY));
    }

    /**
     * https://en.wikipedia.org/wiki/Heron%27s_formula
     * d = peremiter/2;
     * area = Math.sqrt((d-a)(d-b)(d-c)),  a,b,c are the edges length
     */
    //computes area of triangle
    //input: none
    //output: returns area of triangle (double type)
    // Area A = [ x1(y2 – y3) + x2(y3 – y1) + x3(y1-y2)]/2
    @Override
    public double area() {
        //double lOne = Math.abs(Math.sqrt(Math.pow(this.verticeOne.x() - this.verticeTwo.x(),2) + Math.pow(this.verticeOne.y() - this.verticeTwo.y(),2)));
        // double lTwo = Math.abs(Math.sqrt(Math.pow(this.verticeOne.x() - this.verticeThree.x(),2) + Math.pow(this.verticeOne.y() - this.verticeThree.y(),2)));
        // double lThree = Math.abs(Math.sqrt(Math.pow(this.verticeThree.x() - this.verticeTwo.x(),2) + Math.pow(this.verticeThree.y() - this.verticeTwo.y(),2)));
        // double d = perimeter() / 2;
        // return Math.sqrt((-lOne)(d-lTwo)(d-lThree))
        Point2D one = this.verticeOne;
        Point2D two = this.verticeTwo;
        Point2D three = this.verticeThree;
        return Math.abs(((one.x() * (two.y() - three.y())) + (two.x() * (three.y() - one.y())) + (three.x() * (one.y() - two.y()))) / 2);

    }
    //computes the perimeter of a triangle
    //input: none
    //output: returns perimeter of a triangle
    @Override
    public double perimeter() {
        double lOne = this.verticeOne.distance(this.verticeTwo);
        double lTwo = this.verticeOne.distance(this.verticeThree);
        double lThree = this.verticeTwo.distance(this.verticeThree);
        return lOne + lTwo + lThree;
    }
    //moves the triangle by a vector
    //input: Point2D vector
    //output: none
    @Override
    public void move(Point2D vec) {
        this.verticeOne = new Point2D(this.verticeOne.x() + vec.x(), this.verticeOne.y() + vec.y());
        this.verticeTwo = new Point2D(this.verticeTwo.x() + vec.x(), this.verticeTwo.y() + vec.y());
        this.verticeThree = new Point2D(this.verticeThree.x() + vec.x(), this.verticeThree.y() + vec.y());
    }
    //constructs a new copy of the current triangle
    //input: none
    //output: returns new copy of the triagnle
    @Override
    public GeoShape copy() {
        return new Triangle2D(this);
    }
    //returns Point2D array which contains the three vertices of the triagnle
    //input: none
    //output: new Point2D array
    @Override
    public Point2D[] getPoints() {
        return new Point2D[]{this.verticeOne, this.verticeTwo, this.verticeThree};
    }
    //returns string represent the triagnle
    @Override
    public String toString() {
        return "" + this.verticeOne.toString() + "," + this.verticeTwo.toString() + "," + this.verticeThree.toString();
    }
}
