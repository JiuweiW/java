/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alic Jiang
 */
public class Circle {
    
    private double x;
    private double y;
    private double radius;
    
    public final double PI = 3.1415926535898;
    
    private double distanceX(double x0) {
        return x-x0;
    }
    
    private double distanceY(double y0) {
        return y-y0;
    }
    
    public double distanceTo(double x0, double y0) {
        return Math.sqrt(distanceX(x0) * distanceX(x0) + distanceY(y0) * distanceY(y0));
    }
    
    public boolean inCircle(double x0, double y0) {
        return distanceTo(x0, y0) < radius;
    }
    
    public void moveTo(double x0, double y0) {
        x = x0;
        y = y0;
        return;
    }
    
    public void getPosition() {
        System.out.println("x=" + x);
        System.out.println("y=" + y);
        return;
    }
    
    public void setRadius(double r) {
        radius = r;
        return;
    }
    
    public double getRadius() {
        return radius;
    }
    
    public double getDiameter() {
        return 2 * radius;
    }
    
    public double getCircumference() {
        return PI * getDiameter();
    }
    
    public double getArea() {
        return PI * radius * radius;
    }
    
    public double getCurvature() {
        return 1.0/radius;
    }
  
    
}

