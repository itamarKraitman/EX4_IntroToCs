package ex4;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.*;

import geometry.*;

/**
 * This class represents a collection of GUI_Shape.
 * Ex4: you should implement this class!
 *
 * @author I2CS
 */
public class Shape_Collection implements GUI_Shape_Collection {
    //in this class I choose to use arrayList
    //features
    private ArrayList<GUIShape> guiCollection;

    //constructors
    public Shape_Collection() {
        this.guiCollection = new ArrayList<>();
    }

    public Shape_Collection(Shape_Collection arr) {//copying constructor
        this.guiCollection = new ArrayList<GUIShape>();
        int i = 0;
        while (i < arr.size()) {
            this.add(arr.get(i));
            i++;
        }
    }

    //returns the element in the i'th position
    //input: int i represent index
    //output: GUI_Shape in i'th index
    @Override
    public GUI_Shape get(int i) {
        return guiCollection.get(i);
    }

    //returns the size of the collection
    //input: none
    //output: size of the collection
    @Override
    public int size() {
        return guiCollection.size();
    }

    //remove the element in the i'th position and returns it
    //input: int i represent index
    //output: GUI_Shape which was removed from the collection
    @Override
    public GUI_Shape removeElementAt(int i) {
        GUI_Shape temp = guiCollection.get(i);
        guiCollection.remove(i);
        return temp;
    }

    //add new element to the i'th index of the collection
    //input: int i represent index
    //output: none
    @Override
    public void addAt(GUI_Shape s, int i) {
        guiCollection.add(i, (GUIShape) s);
    }

    //add new element to the end of the collection
    //input: GUI_Shape to add
    //output: none
    @Override
    public void add(GUI_Shape s) {
        guiCollection.add((GUIShape) s);
    }

    //makes a deep copy of this. collection
    //input: none
    //output: GUI_Shape_collection
    @Override
    public GUI_Shape_Collection copy() {
        return new Shape_Collection(this);
    }

    //sorts the collection according comparator
    //input: comparator comp
    //output: sorted collection
    @Override
    public void sort(Comparator<GUI_Shape> comp) {
        this.guiCollection.sort(comp);
    }

    //removes all the elements in the collection
    //input: none
    //output: none
    @Override
    public void removeAll() {
        this.guiCollection.removeAll(this.guiCollection);
    }

    //saves a file
    //input: file name
    //output: none, saving a file
    @Override
    public void save(String file) {
        try {
            FileWriter newFile = new FileWriter(file);//fileWriter is a class that helps to to save strings to one file
            newFile.write("Collection: \n");//write method writes the string in the file
            newFile.write(this.toString());
            newFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //loads a file
    //input: file name to be loaded
    //output: a String contians the file data
    //GUIShape,255,false,0,Point2D,0.2,0.4
    @Override
    public void load(String file) throws IllegalArgumentException {
        try {
            File myFile = new File(file);
            Scanner sc = new Scanner(myFile);
            sc.nextLine();
            while (sc.hasNextLine()) {
                String[] currentLine = sc.nextLine().split(",");
                long colorV = Long.parseLong(currentLine[1]);
                Color color = new Color((int) colorV);
                boolean fill = Boolean.parseBoolean(currentLine[2]);
                int tag = Integer.parseInt(currentLine[3]);
                GeoShape gs = new Point2D(1, 1);
                if (currentLine[4].compareTo("Point2D") == 0) {
                    gs = new Point2D(Double.parseDouble(currentLine[5]), Double.parseDouble(currentLine[6]));
                    this.add(new GUIShape(gs, fill, color, tag));
                } else if (currentLine[4].compareTo("Circle2D") == 0) {
                    gs = new Circle2D(new Point2D(Double.parseDouble(currentLine[5]), Double.parseDouble(currentLine[6])), Double.parseDouble(currentLine[7]));
                    this.add(new GUIShape(gs, fill, color, tag));
                } else if (currentLine[4].compareTo("Rect2D") == 0) {
                    gs = new Rect2D(new Point2D(Double.parseDouble(currentLine[5]), Double.parseDouble(currentLine[6])), new Point2D(Double.parseDouble(currentLine[7]), Double.parseDouble(currentLine[8])));
                    this.add(new GUIShape(gs, fill, color, tag));
                } else if (currentLine[4].compareTo("Segment2D") == 0) {
                    gs = new Segment2D(new Point2D(Double.parseDouble(currentLine[5]), Double.parseDouble(currentLine[6])), new Point2D(Double.parseDouble(currentLine[7]), Double.parseDouble(currentLine[8])));
                    this.add(new GUIShape(gs, fill, color, tag));
                } else if (currentLine[4].compareTo("Triangle2D") == 0) {
                    gs = new Triangle2D(new Point2D(Double.parseDouble(currentLine[5]), Double.parseDouble(currentLine[6])), new Point2D(Double.parseDouble(currentLine[7]),
                            Double.parseDouble(currentLine[8])), new Point2D(Double.parseDouble(currentLine[9]), Double.parseDouble(currentLine[10])));
                    this.add(new GUIShape(gs, fill, color, tag));
                } else {
                    System.err.println("Illegal argument");
                    throw new IllegalArgumentException();
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("ERR: FileNotFoundException");
            e.getStackTrace();
        }
    }


    //returns the Rect2D that contains all the shapes in the collection
    //input: none
    //output: Rect2D
    @Override
    public Rect2D getBoundingBox() {
        ArrayList<Double> x = new ArrayList<>();
        ArrayList<Double> y = new ArrayList<>();
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getShape() instanceof Circle2D) {
                Point2D[] p1;
                p1 = new Point2D[]{new Point2D(this.get(i).getShape().centerOfMass().x(), this.get(i).getShape().centerOfMass().y() + ((Circle2D) this.get(i).getShape()).getRadius())
                        ,new Point2D(this.get(i).getShape().centerOfMass().x() + ((Circle2D) this.get(i).getShape()).getRadius(), this.get(i).getShape().centerOfMass().y())
                        ,new Point2D(this.get(i).getShape().centerOfMass().x(), this.get(i).getShape().centerOfMass().y() - ((Circle2D) this.get(i).getShape()).getRadius())
                        ,new Point2D(this.get(i).getShape().centerOfMass().x() - ((Circle2D) this.get(i).getShape()).getRadius(), this.get(i).getShape().centerOfMass().y())};
                for (int j = 0; j < p1.length; j++) {
                    x.add(p1[j].x());
                    y.add(p1[j].y());
                }
            } else {
                Point2D[] p1 = (this.get(i).getShape().getPoints());
                for (int j = 0; j < p1.length; j++) {
                    x.add(p1[j].x());
                    y.add(p1[j].y());
                }
            }
        }
        double[] xArr = new double[x.size()];
        double[] yArr = new double[y.size()];
        for (int i = 0; i < x.size(); i++) {
            xArr[i] = x.get(i);
            yArr[i] = y.get(i);
        }
        Arrays.sort(xArr);
        Arrays.sort(yArr);
        Point2D leftDown = new Point2D(xArr[0], yArr[0]);
        Point2D rightUp = new Point2D(xArr[xArr.length - 1], yArr[yArr.length - 1]);
        return new Rect2D(leftDown, rightUp);
    }

    //returns String represent the collection
    //input: none
    //output: String represent the collection
    @Override
    public String toString() {
        //GUIShape,255,false,0,Point2D,0.2,0.4
        String collectionString = "";
        for (int i = 0; i < this.guiCollection.size(); i++) {
            collectionString += "GUIShape," + this.guiCollection.get(i).toString() + "\n";
        }
        return collectionString;
    }


}