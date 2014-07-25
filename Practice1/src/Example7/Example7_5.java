/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Example7;

/**
 *
 * @author Alic Jiang
 */
public class Example7_5 {
    
    public Example7_5() {}
    
    public static boolean prime_check( int num) {
        boolean prime = true;
        
        for(int i = 2; i <= num/2; i++){
            System.out.println("Now trying " + i);
            if (num % i == 0) {
                prime = false;
                System.out.println(num + " could be diveded by " + i + ".");
                System.out.println("So it is not a prime number.");
                break;
            }
        }
        
        if (prime) {
            System.out.println(num + " is a prime number.");
        }
        
        return prime;
    }
    
    public static void main ( String[] argv ) {
        
        System.out.println("This is Example 7.5");
        
        boolean prime = false;
        int score[] = new int[] {87, 96, 183, 56, 60, -4, 78, 93, 72, 84};
        
        prime = prime_check(7663);
        prime = prime_check(97);
        
        System.out.println();
        int sum = 0;
        int student = 0;
    
        for (int i = 0; i< score.length; i++){
            if (score[i] > 100 || score [i] < 0) {
                System.out.println("Student with ID of " + i + " has wrong entry of marks, do not take in consideration of average calculation.");
                continue;
            }
            System.out.println("Record mark of student with ID " + i);
            sum += score[i];
            student++;
        }
        
        System.out.println("Total mark: " + sum);
        System.out.println("Total recored students: " + student);
        System.out.println("Average: " + (float)sum/student);
        
        System.out.println("End of program.");
    }
    
    
}
