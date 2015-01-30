import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

/**
 * 
 * @author Zichen Jiang
 * @citaiton 
 * 		http://www.intmath.com/complex-numbers/4-polar-form.php
 * 		http://en.wikipedia.org/wiki/Complex_number#Polar_form
 * 		http://www.mathsisfun.com/numbers/complex-number-calculator.html
 * 		http://mathforum.org/library/drmath/view/67068.html
 */
public class Complex {
	
	private double real;
	private double imag;
	
	public Complex() {
		this.real = 0.0;
		this.imag = 0.0;
	}
	
	public Complex(double a, double b) {
		this.real = a;
		this.imag = b;
	}
	
	// return the modulus of this complex number
	public double Modulus(){
		return Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.imag, 2));
	}
	
	// MOST OPERATOINS WILL RETURN A COMPLEX DATA TYPE
	// I.E. NONE OF THEM WILL MODIFY THE DATA TYPE DIRECTLY
	
	// Adds	this complex number with another given one
	public Complex Addition(Complex that) {
		double real = this.real + that.real;
		double imag = this.imag + that.imag;
		return new Complex(real, imag);
	}
	
	// Subtracts a given complex number from this one
	public Complex Subtraction(Complex that) {
		double real = this.real - that.real;
		double imag = this.imag - that.imag;
		return new Complex(real, imag);
	}
	
	// Multiplies this complex number with another one 
	public Complex Multiplication(Complex that) {
		double real = this.real * that.real - this.imag * that.imag;
		double imag = this.real * that.imag + this.imag * that.real;
		return new Complex(real, imag);
	}
	
	// Divides a given complex number by this one
	public Complex Division(Complex that) {
		double real = (this.real * that.real + this.imag * that.imag) / (Math.pow(that.real, 2.0) + Math.pow(that.imag, 2.0));
		double imag = (this.imag * that.real - this.real * that.imag) / (Math.pow(that.real, 2.0) + Math.pow(that.imag, 2.0));
		return new Complex(real, imag);
	}
	
	// Calculates the square root of this complex number
	// only return the positive result
	public Complex SquareRoot() {
		double real = Math.sqrt( (this.real + this.Modulus() ) / 2);
		double imag = Math.sqrt( (-this.real + this.Modulus() ) / 2);
		return new Complex(real, imag);
	}
	
	public String getAngle() {
		double x = this.real;
		double y = this.imag;
		double theta;
		if (x == 0.0) {
			if (y == 0.0) {
				return "indeterminate";
			}else if (y < 0.0) {
				theta = - Math.PI / 2 *180/Math.PI;
			}else {
				theta = Math.PI / 2 *180/Math.PI;
			}
		}else if (x < 0) {
			if (y < 0) {
				theta = (Math.atan(this.imag/this.real)-Math.PI) *180/Math.PI ;
			}else{
				theta = (Math.atan(this.imag/this.real)+ Math.PI) *180/Math.PI ;
			}
		}else{
			theta = Math.atan(this.imag/this.real) *180/Math.PI;			
		}
		return String.valueOf(theta);
	}
	
	// Converts this complex number to a polar form and return it
	public String PolarForm() {
		double r = this.Modulus();
		String theta = this.getAngle();
		if (theta == "indeterminate")
			return theta;
		return String.valueOf(r) + "*cos(" + String.valueOf(theta) + "бу) + i*sin(" + String.valueOf(theta) + "бу))";
	}
	
	// finds the conjugate of this complex number and return
	public Complex Conjugation(){
		double real = this.real;
		double imag = -this.imag;
		return new Complex(real, imag);
	}
	
	// Is this complex number equal to another one?	
	public boolean Equals(Complex that){
		return this.real == that.real && this.imag == that.imag;
	}
	
	// Prints this complex number out
	public String toString(){
		// ouput the plus sign
		String str = "";
		// if both real and imaginary part are 0, show both
		if (this.real == 0.0 && this.imag == 0.0)
			return "0.0+0.0i";
		// if real number part is 0, don't show it
		if (this.real != 0.0)
			str += String.valueOf(this.real);
		// return str if imaginary part is 0
		if (this.imag == 0.0)
			return str;
		// only add plus sign if imaginary part is positive and real number is not 0
		if (this.imag > 0.0 && this.real != 0.0)
			str += "+" + String.valueOf(this.imag) + "i";
		else
			str += String.valueOf(this.imag) + "i";
		return str;
	}
	
	// get quotient of when this/that
	public Complex quotient(Complex that) {
		Complex q = this.Division(that);
		q.real = Math.floor(q.real);
		q.imag = Math.floor(q.imag);
		return q;
	}
	
	// get reminder of when this/that
	public Complex remainder(Complex that) {
		Complex q = this.quotient(that);
		Complex r = this.Subtraction(that.Multiplication(q));
		return r;
	}
	
	public Complex gcd(Complex this, Complex that) {
		Complex zero = new Complex();
		Complex a = this.copy();
		Complex b = that.copy();
		Complex r = null;
		int counter = 0;

		while (b != zero) {
			r = a.remainder(b);
			a = b.copy();
			b = r.copy();
			counter ++;
			if (counter < 5)
				System.out.println(a +", "+ b +", "+ r);
		}
		return r;
	}
	
	private Complex copy() {
		return new Complex(this.real, this.imag);
	}

	public Complex rotate(int angle) {
		double theta = Double.parseDouble(this.getAngle()) + angle;
		theta = theta * Math.PI/180;
		double r = this.Modulus();
		double x = r * Math.cos(theta);
		double y = r * Math.sin(theta);
		return new Complex(x, y);
	}
	
	// assuming "this" is the voltage
	public Complex get_current(Complex v, Complex z) {
		return v.Division(z);
	}
	
	// assuming "this" is the current
	public Complex get_voltage(Complex i, Complex z) {
		return i.Multiplication(z);
	}

	// convert a line from input.txt to array of doubles then return
	public static double[] getData(String str) {
		String[] strArr = str.split(",");
		double[] data = new double[4];
		for(int i=0; i<strArr.length; i++){
			strArr[i] = strArr[i].replace("i", "");
			data[i] = Double.parseDouble(strArr[i]);
		}
		return data;
	}
	
	// generate a random integer between -a and a
	// negEh = True => outputs a random integer between -a and a
	// negEh = False => outputs a random integer between 0 and a
	public static int randInt(int a, boolean negEh) {
		Random rand = new Random();
		int n = rand.nextInt(a+1);
		int s = rand.nextInt(2);
		if (negEh) {
			if (s == 1) {
				return -n;
			}
		}
		return n;
	}
	
	// a function that generates random input data... Yes I am lazy
	public static void dataGen() throws FileNotFoundException {
		PrintStream output = new PrintStream( new File( ("data/input.txt")));
		int range = 200;
		for (int i=1; i<=10; i++) {
			// output case number
			output.println(i);
			// get four random numbers for gcd
			for (int j=0; j<4; j ++){
				output.print(randInt(range, true));
//				if (j != 3) 
					output.print(",");
			}
			output.println();
			// get three random numbers for rotate
			output.println(
					randInt(range, true)
					+ ","
					+ randInt(range, true)
					+ ","
					+ randInt(360, false)
					);
			// get two four values for current and voltage
			for (int k=0; k<2; k++) {
				for (int j=0; j<4; j ++){
					output.print(randInt(range, true));
//					if (j != 3) 
						output.print(",");
				}
				output.println();
			}	
		}
		output.close();
	}
	
	public static void main(String args[]) throws FileNotFoundException {
		Complex a = new Complex(3, 2);
		Complex b = new Complex(1, 7);
		Complex c = new Complex();
	
		// get input.txt data and start testing
		Scanner input = new Scanner(new File("data/input.txt"));
		// open output.txt file
		PrintStream output = new PrintStream( new File( ("data/output.txt")));
		// initialize some Complex variables
		Complex c1;
		Complex c2;
		Complex c3;
		double[] data;

		while (input.hasNext()) {
			// print case number
			String caseN = input.nextLine();
			output.println("Case " + caseN);
			
			// test for gcd
			data = getData(input.nextLine());
			c1 = new Complex(data[0], data[1]);
			c2 = new Complex(data[2], data[3]);
			c3 = c1.gcd(c2);
			// output meaningful lines
			output.println(
					"The greatest common devisor for complex number "
					+ c1
					+ " and complex number "
					+ c2
					+ " is "
					+ c3
					);

			// test for rotate
			data = getData(input.nextLine());
			c1 = new Complex(data[0], data[1]);
			c2 = c1.rotate((int)data[2]);
			output.println("Complex number "
					+ c1
					+ " rotating by "
					+ (int)data[2]
					+ " degrees is complex number "
					+ c2
					);

			// test for current
			data = getData(input.nextLine());
			c1 = new Complex(data[0], data[1]);
			c2 = new Complex(data[2], data[3]);
			c3 = new Complex().get_current(c1, c2);
			output.println(
					"When voltage is "
					+ c1
					+ " and impedance is "
					+ c2
					+", the current is "
					+ c3
					);
			
			// test for voltage
			data = getData(input.nextLine());
			c1 = new Complex(data[0], data[1]);
			c2 = new Complex(data[2], data[3]);
			c3 = new Complex().get_current(c1, c2);
			output.println(
					"When current is "
					+ c1
					+ " and impedance is "
					+ c2
					+", the voltage is "
					+ c3
					);
			output.println();
		}
		input.close();

		// testing for other methods
		output.println();
		output.println();
		output.println("Testing for other methods");
		output.println();
		output.println("Testing Addition");
		output.println(a + " + " + b + " = " + a.Addition(b));
		output.println(a + " + " + c + " = " + a.Addition(c));
		output.println(b + " + " + c + " = " + b.Addition(c));
		output.println();

		output.println("Testing Square Root:");
		output.println("sqrt(a) = " + a.SquareRoot());
		output.println("sqrt(b) = " + b.SquareRoot());
		output.println("sqrt(c) = " + c.SquareRoot());
		output.println();

		output.println("Testing Conjugate:");
		output.println("conj(a) = " +a.Conjugation());
		output.println("conj(b) = " +b.Conjugation());
		output.println("conj(c) = " +c.Conjugation());
		output.println("a * conj(a) = " +a.Multiplication(a.Conjugation()));
		output.println();

		output.println("Testing Polar forms:");
		output.println("Polar form of complex number " + a + " is " + a.PolarForm());
		output.println("Polar form of complex number " + b + " is " + b.PolarForm());
		output.println("Polar form of complex number " + c + " is " + c.PolarForm());

		output.close();

		System.out.println("File executed.");
	}
}
