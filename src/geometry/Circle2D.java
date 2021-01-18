package geometry;

/**
 * This class represents a 2D circle in the plane. Please make sure you update it
 * according to the GeoShape interface.
 * Ex4: you can update this class (additional documentation is needed)!
 *
 * @author boaz.benmoshe
 */
//constructors
public class Circle2D implements GeoShape {
    //features
    private Point2D _center;//center of circel
    private double _radius;//radius

    //constructors
    public Circle2D(){//default
        this._center = new Point2D(0,0);
        this._radius = 1;
    }
    public Circle2D(Point2D cen, double rad) {
        this._center = new Point2D(cen);
        try{
            if(rad < 0){//radius can't be negative
                throw new IllegalArgumentException();
            }
            else{
                this._radius = rad;
            }
        }
        catch (IllegalArgumentException e){//in case of negative input, rad = 1
            System.err.println("Illegal argument was inserted, default radius is initialized");
            this._radius = 1;
        }
    }

    public Circle2D(Circle2D otherCircle) {//copying constructors
        this._center = new Point2D(otherCircle._center);
        this._radius = otherCircle._radius;
    }
    //getters and setters
    //setCenter isn't needed because we have mve method
    //returns the center point of the circle
    public Point2D get_center() {
        return _center;
    }
    //sets the radius by a given argument
    public void set_radius(double _radius) {
        this._radius = _radius;
    }
    //returns the radius
    public double getRadius() {
        return this._radius;
    }
    //interface's method
    //returns a String represent the circle
    //input: none
    //out put: String represent the circle
    @Override
    public String toString() {
        return "" + _center.toString() + ", " + _radius;
    }
    //returns if a given point is in the circle (on the line = in)
    //input: Point2D
    //output: True or False
    @Override
    public boolean contains(Point2D ot) {
        double dist = ot.distance(this._center);
        return dist <= this._radius;
    }
    //returns the center of mass of the circle
    //input: none
    //output: Point2D represent the center of mass
    @Override
    public Point2D centerOfMass() {
        return new Point2D(this._center);
    }
    //returns the area of a circle
    //input: none
    //output: double value represent the area
    @Override
    public double area() {
        if(this._radius == 0)//in case of degenerate circle
            return 0;
        double ans = Math.PI * Math.pow(this._radius, 2);
        return ans;
    }
    //returns the perimeter of the circle
    //input: none
    //output:double value represent the perimeter
    @Override
    public double perimeter() {//in case of degenerate circle
        if(this._radius == 0)
            return  0;
        double ans = Math.PI * 2 * this._radius;
        return ans;
    }
    //moves the circle by a given vector
    //input: Point2D
    //output: none
    @Override
    public void move(Point2D vec) {
        _center.move(vec);
    }
    //returns a copy of the circle
    //input: none
    //output: new copy of the circle
    @Override
    public GeoShape copy() {
        return new Circle2D(_center, _radius);
    }
    //returns an array which includes the Points of the circle
    //input: none
    //output: Point2D array which includes the circle points
    @Override
    public Point2D[] getPoints() {
        Point2D[] ans = new Point2D[2];
        ans[0] = new Point2D(this._center);
        ans[1] = new Point2D(ans[0].x(), ans[0].y() + this._radius);
        return ans;
    }

}
