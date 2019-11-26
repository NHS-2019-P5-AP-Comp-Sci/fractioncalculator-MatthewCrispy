/**
 * @author Mr. Rasmussen
 */

package fracCalc;

import java.util.Scanner;

public class FracCalc {

	public static void main(String[] args) {
		// TODO: Read the input from the user and call produceAnswer with an equation
		String a;
		Scanner userInput = new Scanner(System.in);
		a = userInput.nextLine();
		while (!a.equals("quit")) {
			System.out.println(produceAnswer(a));
			a = userInput.nextLine();
		}
		userInput.close();
	}

	// ** IMPORTANT ** DO NOT DELETE THIS FUNCTION. This function will be used to
	// test your code
	// This function takes a String 'input' and produces the result
	//
	// input is a fraction string that needs to be evaluated. For your program, this
	// will be the user input.
	// e.g. input ==> "1/2 + 3/4"
	//
	// The function should return the result of the fraction after it has been
	// calculated
	// e.g. return ==> "1_1/4"
	public static String produceAnswer(String input) {
		// TODO: Implement this function to produce the solution to the input
		int x = input.indexOf(' ');
		int y = input.length();
		String prePart = input.substring(x + 1, x + 2);
		String firstPart = input.substring(x + 3, y);
		int z = firstPart.indexOf('_');
		int xy = firstPart.indexOf('/');
		int xz = firstPart.length();
		String a;
		String b;
		String c;
		if (z != -1) {
			a = firstPart.substring(0, z);
			if (xy == -1) {
				b = "0";
				c = "0";
			} else {
				if (xy == z + 1) {
					b = "0";
					if (xz == xy + 1) {
						c = "0";
					} else {
						c = firstPart.substring(xy + 1);
					}
				} else {
					b = firstPart.substring(z + 1, xy);
					if (xz == xy + 1) {
						c = "0";
					} else {
						c = firstPart.substring(xy + 1);
					}
				}
			}
		} else {
			if (xy == -1) {
				a = firstPart;
				b = "0";
				c = "1";
			} else {
				a = "0";
				if (xy == 0) {
					b = "0";
					if (xz == xy + 1) {
						c = "0";
					} else {
						c = firstPart.substring(xy + 1);
					}

				} else {
					b = firstPart.substring(0, xy);
					if (xz == xy + 1) {
						c = "0";
					} else {
						c = firstPart.substring(xy + 1);
					}
				}
			}
		}
		firstPart = "whole:" + a + " numerator:" + b + " denominator:" + c;
		return firstPart;
	}

	public static void peng() {
	}

	// TODO: Fill in the space below with any helper methods that you think you will
	// need

}
