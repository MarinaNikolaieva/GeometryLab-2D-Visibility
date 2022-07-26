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
public class MyPoint {
    private double X;
    private double Y;
    private boolean Visible;
    private char Type;  //Left, Right, Middle
    private int lineIndex;
    
    public MyPoint(double x, double y){
        X = x;
        Y = y;
        Visible = false;
        Type = 'U';  //Unknown
        lineIndex = -1;
    }
    
    public MyPoint(MyPoint s){
        X = s.getX();
        Y = s.getY();
        Visible = s.getVisible();
        Type = s.getType();
        lineIndex = s.getLineInd();
    }
    
    public double getX(){
        return X;
    }
    
    public void setX(double x){
        X = x;
    }
    
    public double getY(){
        return Y;
    }
    
    public void setY(double y){
        Y = y;
    }
    
    public void setVisible(boolean a){
        Visible = a;
    }
    
    public boolean getVisible(){
        return Visible;
    }
    
    public char getType(){
        return Type;
    }
    
    public void setType(char a){
        Type = a;
    }
    
    public int getLineInd(){
        return lineIndex;
    }
    
    public void setLineInd(int a){
        lineIndex = a;
    }
    
//    public boolean clock(MyPoint prev, MyPoint next){  //clockwise or counterClockwise
//        double edge1 = (this.getX() - prev.getX()) * (this.getY() + prev.getY());
//        double edge2 = (next.getX() - this.getX()) * (next.getY() + this.getY());
//        double edge3 = (next.getX() - prev.getX()) * (next.getY() + prev.getY());
//        double sum = edge1 + edge2 + edge3;
//        return sum > 0;
//    }
    public boolean clock(MyPoint prev, MyPoint next){  //true if COUNTERclockwise or COLLINEAR
        double edge1 = (this.getX() - prev.getX()) * (next.getY() - prev.getY());
        double edge2 = (next.getX() - prev.getX()) * (this.getY() - prev.getY());
        if ((edge1 - edge2) >= 0)
            return true;
        return false;
    }
}
