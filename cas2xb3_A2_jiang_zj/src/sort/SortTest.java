package sort;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

import org.apache.commons.lang.time.StopWatch;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
/**
 *The {@code SortTest} class provides JUnit tests for test sort
 */
public class SortTest {
	// create a 2d array to store all the words
	private Word[][] inputWord = {new Word[16], new Word[256], new Word[4096]};
	// create a array of Strings to store the output
	static String[] output = {"16", "256", "4096"};	
	
	/**
	 * Test the array x written to test is empty or not
	 */
	public boolean isEmpty(Word[] x) {
		for (int i=0; i<x.length; i++) {
			if (x[i] == null) return true;
		}
		return false;
	}
        /**
	 * Read data from a2_in.txt 
	 * Create word array use data from a2_in.txt 
	 * @throws FileNotFoundException
	 */
	@Before
	public void setup() throws FileNotFoundException {
		// read input file and convert everything to array of Word
		Scanner input = new Scanner(new File("data/a2_in.txt"));
		
		for (int i=0; i<3; i++) {
			// read a line
			String line = input.nextLine();
			String[] data = line.split(",");
//			System.out.println("i=" + i);
			for(int j=0; j<data.length; j++) {
				if (j%2 != 0) {
					// odd number element -> ranking
					// get the previous element, the word
					String str = data[j-1].substring(1);
					// get rid of "}" at the end of the ranking
					String rank = data[j];
					rank = rank.substring(0, rank.length()-1);
					// and construct a Word with the previous element
					Word word = new Word(str, Integer.parseInt(rank));
//					System.out.println(word);
//					System.out.println("j=" + j);
					inputWord[i][(int) Math.floor(j/2)] = word;
				}
			}
			// initialize output array
//			System.out.println(Arrays.toString(inputWord[i]));
//			System.out.println(isEmpty(inputWord[i]));
		}
	}
	/**
         * Tests for Insertion class sort function.
         * Array size are 2^4, 2^8, 2^12
         * Use StopWatch class to record times for sort.
         * Add the result to output string
         */
	@Test
	public void testSortInsert() {
		// using the StopWatch class from the apache library
		StopWatch sw = new StopWatch();
		// start stopwatch
		sw.start();
//		System.out.println("Insertion sort");
		for (int i=0; i<3; i++) {
			// get time before the sorting runs
			double startTime = sw.getTime();
			Insertion.sortInsert(inputWord[i]);
			// get time when the sorting finishes
			double endTime = sw.getTime();
			// calculate run time of the sorting
			double runTime = (endTime - startTime) / 1000;
			// add it to output string
			output[i] += ",insertion sort," + runTime;
			// System.out.println(Insertion.isSorted(inputWord[i]));
		}
		sw.stop();
	}
	/**
         * Tests for Insertion class sortComparable function.
         * Array size are 2^4, 2^8, 2^12
         * Use StopWatch class to record times for sort.
         * Add the result to output string
         */
	@Test
	public void testInsertComparable() {
		StopWatch sw = new StopWatch();
		sw.start();
//		System.out.println("Insertion sort comparable");
		for (int i=0; i<3; i++) {
			double startTime = sw.getTime();
			Insertion.sortComparable(inputWord[i]);
			double endTime = sw.getTime();
			double runTime = (endTime - startTime) / 1000;
			output[i] += ",comparable insertion sort," + runTime;
			// System.out.println(Insertion.isSorted(inputWord[i]));
		}
		sw.stop();
	}
	/**
         * Tests for Insertion class sortBinary function.
         * Array size are 2^4, 2^8, 2^12
         * Use StopWatch class to record times for sort.
         * Add the result to output string
         */
	@Test
	public void testInsertBinary() {
		StopWatch sw = new StopWatch();
		sw.start();
//		System.out.println("Insertion sort binary");
		for (int i=0; i<3; i++) {
			double startTime = sw.getTime();
			Insertion.sortBinary(inputWord[i]);
			double endTime = sw.getTime();
			double runTime = (endTime - startTime) / 1000;
			output[i] += ",comparable binary insertion sort," + runTime;
//			System.out.println(endTime - startTime);
		}
		sw.stop();
	}
	/**
         * Tests for Merge class sortMerge function.
         * Array size are 2^4, 2^8, 2^12
         * Use StopWatch class to record times for sort.
         * Add the result to output string
         */		
	@Test
	public void testMerge() {
		StopWatch sw = new StopWatch();
		sw.start();
//		System.out.println("Merge sort");
		for (int i=0; i<3; i++) {
			double startTime = sw.getTime();
			Merge.sortMerge(inputWord[i]);
			double endTime = sw.getTime();
			double runTime = (endTime - startTime) / 1000;
			output[i] += ",merge sort," + runTime;
			// System.out.println(Merge.isSorted(inputWord[i]));
		}
		sw.stop();
	}
	/**
         * Tests for Heap class sortHeap function.
         * Array size are 2^4, 2^8, 2^12
         * Use StopWatch class to record times for sort.
         * Add the result to output string
         */
	@Test
	public void testHeapSort() {
		StopWatch sw = new StopWatch();
		sw.start();
//		System.out.println("Heap sort");
		for (int i=0; i<3; i++) {
			double startTime = sw.getTime();
			Heap.sortHeap(inputWord[i]);
			double endTime = sw.getTime();
			double runTime = (endTime - startTime) / 1000;
			output[i] += ",heap sort," + runTime;
			// System.out.println(Heap.isSorted(inputWord[i]));
		}
		sw.stop();
	}
	/**
	 * Record run times for each sort function.
	 * @throws FileNotFoundException
	 */
	@AfterClass
	public static void output() throws FileNotFoundException {
		// open output file
		PrintStream outputFile = new PrintStream( new File( ("data/a2_out.txt")));
		for (String s : output) {
			outputFile.println(s);			
		}
		outputFile.close();
	}

}
