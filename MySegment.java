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
public class MySegment {
    private MyPoint Start;
    private MyPoint End;
    
    public MySegment(MyPoint s, MyPoint e){
        Start = new MyPoint(s);
        End = new MyPoint(e);
    }
    
    public MySegment(MySegment a){
        Start = a.getStart();
        End = a.getEnd();
    }
    
    public MyPoint getStart(){
        return Start;
    }
    
    public MyPoint getEnd(){
        return End;
    }
    
    public boolean containPoint(MyPoint a){
        double t = (a.getX() - Start.getX())*(End.getY() - Start.getY()) -
                (a.getY() - Start.getY())*(End.getX() - Start.getX());
        boolean fs = Start.getX() < a.getX() && a.getX() < End.getX();
        boolean sc = End.getX() < a.getX() && a.getX() < Start.getX();
        if (t == 0.0 && (fs || sc))
            return true;
        return false;
    }
    
    public MyPoint getMiddle(){
        double mx = (Start.getX() + End.getX()) / 2;
        double my = (Start.getY() + End.getY()) / 2;
        MyPoint mid = new MyPoint(mx, my);
        return mid;
    }
}
