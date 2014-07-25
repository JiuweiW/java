/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Example8_2;

/**
 *
 * @author Alic Jiang
 */

class Primary{
    private String name = null;
    
    public Primary() {
        name = "---";
        System.out.println("Construct a Primary Object without parameter.");
    }
    
    public Primary(String name) {
        this.name = name;
        System.out.println("Construct a Primary Object with a parameter.");
    }
    
    public void showName() {
        if(name.equals("---")){
            System.out.println("This student has no information");
        }else{
            System.out.println("The name of this student is " + name + ".");
        }
    }
    
    public void goToSchool() {
        System.out.println("I will go to school.");
    }
}

class HighSchool extends Primary {
    
    public HighSchool() {
        System.out.println("Construct a HighSchool Object without parameter.");
    }
    
    public HighSchool(String name){
        super(name);
        System.out.println("Construct a HighSchool Object with a paramter.");
    }
    
    public void goToLaboratory(){
        System.out.println("I will go to laboratory.");
    }
}

class Undergraduate extends HighSchool {
    
    public Undergraduate() {
        System.out.println("Construct an Undergraduate Object without parameter.");
    }
    
    public Undergraduate(String name){
        super(name);
        System.out.println("Construct an Undergraduate Object with a parameter.");
    }
    
    public void goToLectureHall() {
        System.out.println("I will go to lecture hall.");
        super.goToLaboratory();
    }
}
public class Example8_2 {
    
    public static void main(String[] argv) {
        System.out.println("This is Example 8.2");
        
        System.out.println("-----------------------------------------");
        Undergraduate stu1 = new Undergraduate();
        System.out.println("-----------------------------------------");
        Undergraduate Mark = new Undergraduate("Mark Zuckerberg");
        
        System.out.println("-----------------------------------------");
        HighSchool stu2 = new HighSchool();
        System.out.println("-----------------------------------------");
        HighSchool Sergey = new HighSchool("Sergey Brin");
        
        System.out.println("-----------------------------------------");
        Primary Larry = new Primary ("Larry Page");
        
        stu1.showName();
        
        Sergey.showName();
        Sergey.goToSchool();
        
        Mark.showName();
        Mark.goToSchool();
        Mark.goToLectureHall();
        
        System.out.println("-----------------------------------------");
    } 
}
