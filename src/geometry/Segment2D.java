package geometry;

/**
 * This class represents a 2D segment on the plane, 
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class Segment2D implements GeoShape{
	//features
	private Point2D end1;
	private Point2D end2;
	public Segment2D(){
		this.end1 = new Point2D(0,0);
		this.end2 = new Point2D(0, 1);
	}
	public Segment2D(Point2D end1, Point2D end2){
		this.end1 = end1;
		this.end2 = end2;
	}
	public Segment2D(Segment2D seg){
		this.end1 = seg.end1;
		this.end2 = seg.end2;
	}
	public Point2D getEnd1() {
		return end1;
	}

	public Point2D getEnd2() {
		return end2;
	}

	//computes if a segment contains a other point
	//input: other Point2D
	//output: True for contains False for not contains
	@Override
	public boolean contains(Point2D ot) {
		double disAB = this.end1.distance(this.end2);
		double disAN = this.end1.distance(ot);
		double disBN = this.end2.distance(ot);
		return (disAN + disBN == disAB);

	}
	///computes the center of mass of a segment
	//input: none
	//output: Point2D represent the center of mass
	@Override
	public Point2D centerOfMass() {
		if(this.end1 == this.end2)//in case of degenerate segment
			return this.end1;
		double centerX = (this.end2.x() + this.end1.x()) / 2;
		double centerY = (this.end2.y() + this.end1.y()) / 2;
		Point2D ans = new Point2D(centerX, centerY);
		return ans;
	}

	//computes the area of the segment, because segment has no area it returns 0
	//input: none
	//output: 0
	@Override
	public double area() {
		return 0;
	}
	//computes the perimeter of a segment- twice it's length
	//input: none
	//output: double value represent the perimeter
	@Override
	public double perimeter() {
		double lenSegment = this.end1.distance(this.end2);
		return lenSegment * 2;
	}
	//moving the segment according vec's features.
	//input: Point2D vec
	//output: void
	@Override
	public void move(Point2D vec) {
		this.end1 = new Point2D(this.end1.x() + vec.x(),this.end1.y() + vec.y());
		this.end2 = new Point2D(this.end2.x() + vec.x(), this.end2.y() + vec.y());
	}
	//making a copy of the segment
	//input: none
	//output: returns a new copy of the segment
	@Override
	public GeoShape copy() {
		return (new Segment2D(this));
	}
	//making an array which contains both ends of segment
	//input: none
	//output: Point2D array
	@Override
	public Point2D[] getPoints() {
		Point2D[] ans = new Point2D[2];
		ans[0] = this.end1;
		ans[1] = this.end2;
		return ans;
	}
	//computes a string represent the segment
	//input: none
	//output: string that represent the segment
	@Override
	public String toString() {
		return "" + this.end1.toString() + "," + this.end2.toString();
	}

}