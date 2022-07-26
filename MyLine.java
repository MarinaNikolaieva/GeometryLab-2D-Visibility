/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeomPack;

/**
 *
 * @author Marina Nik
 */
public class MyLine {
    private MyPoint Start;
    private MyPoint End;
    
    public MyLine(MyPoint s, MyPoint e){
        Start = new MyPoint(s);
        End = new MyPoint(e);
    }
    
    public MyLine(MyLine a){
        Start = new MyPoint(a.getStart());
        End = new MyPoint(a.getEnd());
    }
    
    public MyPoint getStart(){
        return Start;
    }
    
    public MyPoint getEnd(){
        return End;
    }
    
    public int pointPos(MyPoint a){  //0 if on the line, -1 if to the left, 1 if to the right
        double t = (a.getX() - Start.getX())*(End.getY() - Start.getY()) -
                (a.getY() - Start.getY())*(End.getX() - Start.getX());
        if (t < 0) return -1;
        if (t > 0) return 1;
        return 0;
    }
    
    public MyPoint pointCross(MySegment a) throws ArithmeticException{  //find crossing point
        double a1 = this.getEnd().getY() - this.getStart().getY();
        double b1 = this.getStart().getX() - this.getEnd().getX();
        double c1 = - (this.getStart().getX() * this.getEnd().getY()) + 
                this.getStart().getY() * this.getEnd().getX();
        
        double a2 = a.getEnd().getY() - a.getStart().getY();
        double b2 = a.getStart().getX() - a.getEnd().getX();
        double c2 = - (a.getStart().getX() * a.getEnd().getY()) + 
                a.getStart().getY() * a.getEnd().getX();
        
        if (a1 * b2 == a2 * b1) throw new ArithmeticException();  //the lines are parallel
        if (a1 * b2 == a2 * b1 && a1 * c2 == a2 * c1 && b1 * c2 == b2 * c1){  //two lines intersect
            if (this.sameDirect(a))
                return a.getEnd();
            else return a.getStart();
        }
        //NEEDED: look for the direction and decide, Start or End to return DONE
        
        double x = (b1 * c2 - b2 * c1) / (a1 * b2 - a2 * b1);
        double y = (a2 * c1 - a1 * c2) / (a1 * b2 - a2 * b1);
        MyPoint cross = new MyPoint(x, y);
        return cross;
    }
    
    public boolean sameDirect(MySegment a){
        double segmCoordX = a.getEnd().getX() - a.getStart().getX();
        double segmCoordY = a.getEnd().getY() - a.getStart().getY();
        double lineCoordX = this.getEnd().getX() - this.getStart().getX();
        double lineCoordY = this.getEnd().getY() - this.getStart().getY();
        double checker = segmCoordX * lineCoordX + segmCoordY * lineCoordY;
        
        return checker > 0;
    }
}
