package geometry;

public class Point2D implements  GeoShape{
    public static final double EPS1 = 0.001, EPS2 = Math.pow(EPS1,2), EPS=EPS2;
    public static final Point2D ORIGIN = new Point2D(0,0);
    //features
    private double _x,_y;
    //constructors
    public Point2D(double x,double y) {
        _x=x; _y=y;
    }
    public Point2D(Point2D p) {//copy constructor
        this(p.x(), p.y());
    }
    public Point2D(String s) {//construct by String
        try {
            String[] a = s.split(",");
            _x = Double.parseDouble(a[0]);
            _y = Double.parseDouble(a[1]);
        }
        catch(IllegalArgumentException e) {
            System.err.println("ERR: got wrong format string for Point2D init, got:"+s+"  should be of format: x,y");
            throw(e);
        }
    }

    public double x() {return _x;}
    public double y() {return _y;}

    public int ix() {return (int)_x;}//return X as int value
    public int iy() {return (int)_y;}//return Y as int value

    public Point2D add(Point2D p) {//moving a Point according to other Point values
        Point2D a = new Point2D(p.x()+x(),p.y()+y());
        return a;
    }
    @Override
    public String toString() {//return string represent the Point
        return _x+","+_y;
    }

    public double distance() {//returns distance from origin (0,0)
        return this.distance(ORIGIN);
    }
    public double distance(Point2D p2) {//return distance from other Point
        double dx = this.x() - p2.x();
        double dy = this.y() - p2.y();
        double t = (dx*dx+dy*dy);
        return Math.sqrt(t);
    }

    public boolean equals(Object p){//return if two Points have same values
        if(p==null || !(p instanceof Point2D)) {return false;}
        Point2D p2 = (Point2D)p;
        return ( (_x==p2._x) && (_y==p2._y));
    }
    public boolean close2equals(Point2D p2, double eps) {//return if close t other Point in distance lower than EPS
        return ( this.distance(p2) < eps );
    }
    public boolean close2equals(Point2D p2) {
        return close2equals(p2, EPS);
    }
    /**
     * This method returns the vector between this point and the target point. The vector is represented as a Point2D.
     * @param target
     * @return
     */
    public Point2D vector(Point2D target) {
        double dx = target.x() - this.x();
        double dy = target.y() - this.y();
        return new Point2D(dx,dy);
    }
    //return if other Point2D is with in Point
    @Override
    public boolean contains(Point2D ot) {
        // TODO Auto-generated method stub
        return this.equals(ot);
    }
    //return center of mass of a Point2D
    @Override
    public Point2D centerOfMass() {
        // TODO Auto-generated method stub
        return new Point2D(this);
    }
    //return ara of a Point2D
    @Override
    public double area() {
        // TODO Auto-generated method stub
        return 0;
    }
    //return the perimeter of Poin2D
    @Override
    public double perimeter() {
        // TODO Auto-generated method stub
        return 0;
    }
    //move Point to other location according vector
    @Override
    public void move(Point2D vec) {
        this._x += vec.x();
        this._y += vec.y();
    }
    //making copy of the Point
    @Override
    public GeoShape copy() {
        return new Point2D(this);
    }
    //return Point2D array which contains the Point2D
    @Override
    public Point2D[] getPoints() {
        Point2D[] ans = new Point2D[1];
        ans[0] =new Point2D(this);
        return ans;
    }
}
