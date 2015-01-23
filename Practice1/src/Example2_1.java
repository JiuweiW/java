/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alic Jiang
 */
public class Example2_1 {
    
    public static void main(String[] argv) {
        
        System.out.println("This is Example2_1.");
        
        Circle circle1;
        Circle circle2;
        
        circle1 = new Circle();
        circle2 = new Circle();
        
        System.out.println("circle's radius: " + circle1.getRadius() );
        
        circle2.setRadius(9);
        
        System.out.println("PI: " + circle2.PI);
        
        circle1.moveTo(0,0);
        circle2.moveTo(3,4);
        
        circle2.getPosition();
        
        
        
    }
    
    
}