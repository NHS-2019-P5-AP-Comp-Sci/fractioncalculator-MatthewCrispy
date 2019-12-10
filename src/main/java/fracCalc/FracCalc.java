/**
 * @author Mr. Rasmussen
 */

package fracCalc;

import java.util.Scanner;

public class FracCalc {

	public static void main(String[] args) {
		// TODO: Read the input from the user and call produceAnswer with an equation
		System.out.println("Welcom to the Peng Faction Calculator");
		System.out.println("please enter your equation");
		String a;
		Scanner userInput = new Scanner(System.in);
		a = userInput.nextLine();
		while (!a.equals("quit")) {
			System.out.println("Your final answer is : \n" + produceAnswer(a));
			System.out.println("please enter your equation");
			a = userInput.nextLine();

		}
		userInput.close();

	}

	public static String produceAnswer(String input) {
		// TODO: decide which operation is requested and direct them to different
		// methods.
		// Also, it reduces the fraction and provide the final answer with the method
		// "pengcalc".
		// TODO: Implement this function to produce the solution to the input
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
		String prefinal = "0";
		int pa = input.indexOf(" ");
		if (pa != -1) {
			String x = produce2(input);
			String y = produce(input);
			System.out.println("Frist Fraction Parsing:");
			System.out.println(x);
			System.out.println("Second Fraction Parsing:");
			System.out.println(y);
			String ppartsign = input.substring(pa + 1, pa + 2);
			if (ppartsign.equals("+") || ppartsign.contentEquals("-")) {
				if (ppartsign.equals("+")) {
					prefinal = calc1(x, y);
				} else {
					prefinal = calc2(x, y);
				}
			} else {
				if (ppartsign.equals("*") || ppartsign.contentEquals("/")) {
					if (ppartsign.equals("*")) {
						prefinal = calc3(x, y);
					} else {
						prefinal = calc4(x, y);
					}
				} else {
					System.out.print("error");
				}
			}
		} else {
			prefinal = input;
		}
		return pengcalc(prefinal);

	}

	// TODO: Fill in the space below with any helper methods that you think you will
	// need
	public static String pengcalc(String input) {
		// This method is used to simplify the not reduced results and produce final
		// answer!
		// TODO: read the input from the String value "prefinal" and simplify the
		// fraction.
		System.out.println("Original result:");
		System.out.println(input);
		int a = input.indexOf("/");
		String top = input.substring(0, a);
		String bottom = input.substring(a + 1);
		int n = Integer.parseInt(top);
		int d = Integer.parseInt(bottom);
		if (d < 0) {
			if (n < 0) {
				String topminus = input.substring(1, a);
				n = Integer.parseInt(topminus);
				String bottominus = input.substring(a + 2);
				d = Integer.parseInt(bottominus);
				if (n > d) {
					if (n % d == 0) {
						String finalstring = Integer.toString(n / d);
						return finalstring;
					} else {
						for (int i = (n - (n / d) * d); i > 0; i--) {
							if ((n - (n / d) * d) % i == 0 && d % i == 0) {
								String prefinalstring = (n - (n / d) * d) / i + "/" + d / i;
								i = -1;
								String finalstring = n / d + "_" + prefinalstring;
								return finalstring;
							}
						}
					}
				} else if (n == d) {
					String finalstring = "1";
					return finalstring;
				} else {
					if (n == 0) {
						String finalstring = "0";
						return finalstring;
					} else {
						String topminu = input.substring(1, a);
						n = Integer.parseInt(topminu);
						for (int i = n; i > 0; i--) {
							if (n % i == 0 && d % i == 0) {
								String finalstring = n / i + "/" + d / i;
								i = -1;
								return finalstring;
							}
						}
					}
				}
			} else {
				String bottominus = input.substring(a + 2);
				d = Integer.parseInt(bottominus);
				if (n > d) {
					if (n % d == 0) {
						String finalstring = "-" + Integer.toString(n / d);
						return finalstring;
					} else {
						for (int i = (n - (n / d) * d); i > 0; i--) {
							if ((n - (n / d) * d) % i == 0 && d % i == 0) {
								String prefinalstring = (n - (n / d) * d) / i + "/" + d / i;
								i = -1;
								String finalstring = "-" + n / d + "_" + prefinalstring;
								return finalstring;
							}
						}
					}
				} else if (n == d) {
					String finalstring = "-1";
					return finalstring;
				} else {
					if (n == 0) {
						String finalstring = "0";
						return finalstring;
					} else {
						for (int i = n; i > 0; i--) {
							if (n % i == 0 && d % i == 0) {
								String finalstring = "-" + n / i + "/" + d / i;
								i = -1;
								return finalstring;
							}
						}
					}
				}
			}
		} else {
			if (n < 0) {
				String topminus = input.substring(1, a);
				n = Integer.parseInt(topminus);
				if (n > d) {
					if (n % d == 0) {
						String finalstring = "-" + n / d;
						return finalstring;
					} else {
						for (int i = (n - (n / d) * d); i > 0; i--) {
							if ((n - (n / d) * d) % i == 0 && d % i == 0) {
								String prefinalstring = (n - (n / d) * d) / i + "/" + d / i;
								i = -1;
								String finalstring = "-" + n / d + "_" + prefinalstring;
								return finalstring;
							}
						}
					}
				} else if (n == d) {
					String finalstring = "-1";
					return finalstring;
				} else {
					if (n == 0) {
						String finalstring = "0";
						return finalstring;
					} else {
						String topminu = input.substring(1, a);
						n = Integer.parseInt(topminu);
						for (int i = n; i > 0; i--) {
							if (n % i == 0 && d % i == 0) {
								String finalstring = "-" + n / i + "/" + d / i;
								i = -1;
								return finalstring;
							}
						}
					}
				}
			} else {
				if (n > d) {
					if (n % d == 0) {
						String finalstring = Integer.toString(n / d);
						return finalstring;
					} else {
						for (int i = (n - (n / d) * d); i > 0; i--) {
							if ((n - (n / d) * d) % i == 0 && d % i == 0) {
								String prefinalstring = (n - (n / d) * d) / i + "/" + d / i;
								i = -1;
								String finalstring = n / d + "_" + prefinalstring;
								return finalstring;
							}
						}
					}
				} else if (n == d) {
					String finalstring = "1";
					return finalstring;
				} else {
					if (n == 0) {
						String finalstring = "0";
						return finalstring;
					} else {
						for (int i = n; i > 0; i--) {
							if (n % i == 0 && d % i == 0) {
								String finalstring = n / i + "/" + d / i;
								i = -1;
								return finalstring;
							}
						}
					}
				}
			}
		}
		return bottom;
	}

	public static String produce(String input) {
		// TODO: read the scanner input of the second value and divide it to whole
		// number, denominator, and numerator.
		int x = input.indexOf(' ');
		int y = input.length();
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

	// TODO: Implement this function to produce the solution to the input

	public static String produce2(String input) {
		// TODO: read the scanner input of the second value and divide it to whole
		// number, denominator, and numerator.
		int x = input.indexOf(' ');
		String firstPart = input.substring(0, x);
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

	public static String calc1(String x, String y) {
		//TODO: Calculation for addition.
		int a = x.indexOf(":");
		int b = x.indexOf(" ");
		String ww = x.substring(a + 1, b);
		String xw = x.substring(b + 1);
		int c = xw.indexOf(":");
		int d = xw.indexOf(" ");
		String xn = xw.substring(d);
		String nn = xw.substring(c + 1, d);
		int e = xn.indexOf(":");
		String dd = xn.substring(e + 1);
		int w1 = Integer.parseInt(ww);
		int n1 = Integer.parseInt(nn);
		int d1 = Integer.parseInt(dd);

		int i = y.indexOf(":");
		int j = y.indexOf(" ");
		String www = y.substring(i + 1, j);
		String yw = y.substring(j + 1);
		int k = yw.indexOf(":");
		int l = yw.indexOf(" ");
		String yn = yw.substring(l);
		String nnn = yw.substring(k + 1, l);
		int m = yn.indexOf(":");
		String ddd = yn.substring(m + 1);
		int w2 = Integer.parseInt(www);
		int n2 = Integer.parseInt(nnn);
		int d2 = Integer.parseInt(ddd);

		if (w1 == 0) {
			if (w2 == 0) {
				int peng1 = (n1 * d2) + (n2 * d1);
				int peng2 = d1 * d2;
				return (peng1 + "/" + peng2);
			} else {
				int peng1 = (n1 * d2) + (w2 / Math.abs(w2)) * (((Math.abs(w2) * d2) + n2) * d1);
				int peng2 = d1 * d2;
				return (peng1 + "/" + peng2);
			}
		} else {
			if (w2 == 0) {
				int peng1 = (w1 / Math.abs(w1)) * (((Math.abs(w1) * d1) + n1) * d2) + (n2 * d1);
				int peng2 = d1 * d2;
				return (peng1 + "/" + peng2);
			} else {
				int peng1 = (w1 / Math.abs(w1)) * (((Math.abs(w1) * d1) + n1) * d2)
						+ (w2 / Math.abs(w2)) * (((Math.abs(w2) * d2) + n2) * d1);
				int peng2 = d1 * d2;
				return (peng1 + "/" + peng2);
			}
		}

	}

	public static String calc2(String x, String y) {
		//TODO: Calculation for subtraction.
		int a = x.indexOf(":");
		int b = x.indexOf(" ");
		String ww = x.substring(a + 1, b);
		String xw = x.substring(b + 1);
		int c = xw.indexOf(":");
		int d = xw.indexOf(" ");
		String xn = xw.substring(d);
		String nn = xw.substring(c + 1, d);
		int e = xn.indexOf(":");
		String dd = xn.substring(e + 1);
		int w1 = Integer.parseInt(ww);
		int n1 = Integer.parseInt(nn);
		int d1 = Integer.parseInt(dd);

		int i = y.indexOf(":");
		int j = y.indexOf(" ");
		String www = y.substring(i + 1, j);
		String yw = y.substring(j + 1);
		int k = yw.indexOf(":");
		int l = yw.indexOf(" ");
		String yn = yw.substring(l);
		String nnn = yw.substring(k + 1, l);
		int m = yn.indexOf(":");
		String ddd = yn.substring(m + 1);
		int w2 = Integer.parseInt(www);
		int n2 = Integer.parseInt(nnn);
		int d2 = Integer.parseInt(ddd);

		if (w1 == 0) {
			if (w2 == 0) {
				int peng1 = (n1 * d2) - (n2 * d1);
				int peng2 = d1 * d2;
				return (peng1 + "/" + peng2);
			} else {
				int peng1 = (n1 * d2) - (w2 / Math.abs(w2)) * (((Math.abs(w2) * d2) + n2) * d1);
				int peng2 = d1 * d2;
				return (peng1 + "/" + peng2);
			}
		} else {
			if (w2 == 0) {
				int peng1 = (w1 / Math.abs(w1)) * (((Math.abs(w1) * d1) + n1) * d2) - (n2 * d1);
				int peng2 = d1 * d2;
				return (peng1 + "/" + peng2);
			} else {
				int peng1 = (w1 / Math.abs(w1)) * (((Math.abs(w1) * d1) + n1) * d2)
						- (w2 / Math.abs(w2)) * (((Math.abs(w2) * d2) + n2) * d1);
				int peng2 = d1 * d2;
				return (peng1 + "/" + peng2);
			}
		}

	}

	public static String calc3(String x, String y) {
		//TODO: Calculation for multiplication.
		int a = x.indexOf(":");
		int b = x.indexOf(" ");
		String ww = x.substring(a + 1, b);
		String xw = x.substring(b + 1);
		int c = xw.indexOf(":");
		int d = xw.indexOf(" ");
		String xn = xw.substring(d);
		String nn = xw.substring(c + 1, d);
		int e = xn.indexOf(":");
		String dd = xn.substring(e + 1);
		int w1 = Integer.parseInt(ww);
		int n1 = Integer.parseInt(nn);
		int d1 = Integer.parseInt(dd);

		int i = y.indexOf(":");
		int j = y.indexOf(" ");
		String www = y.substring(i + 1, j);
		String yw = y.substring(j + 1);
		int k = yw.indexOf(":");
		int l = yw.indexOf(" ");
		String yn = yw.substring(l);
		String nnn = yw.substring(k + 1, l);
		int m = yn.indexOf(":");
		String ddd = yn.substring(m + 1);
		int w2 = Integer.parseInt(www);
		int n2 = Integer.parseInt(nnn);
		int d2 = Integer.parseInt(ddd);

		if (w1 == 0) {
			if (w2 == 0) {
				int peng1 = (n1 * n2);
				int peng2 = (d1 * d2);
				return (peng1 + "/" + peng2);
			} else {
				int peng1 = (n1 * (w2 / Math.abs(w2)) * (((Math.abs(w2) * d2) + n2)));
				int peng2 = (d1 * d2);
				return (peng1 + "/" + peng2);
			}
		} else {
			if (w2 == 0) {
				int peng1 = ((w1 / Math.abs(w1)) * ((Math.abs(w1) * d1) + n1) * n2);
				int peng2 = (d1 * d2);
				return (peng1 + "/" + peng2);
			} else {
				int peng1 = (w1 / Math.abs(w1)) * (((Math.abs(w1) * d1) + n1)) * (w2 / Math.abs(w2))
						* (((Math.abs(w2) * d2) + n2));
				int peng2 = (d1 * d2);
				return (peng1 + "/" + peng2);
			}
		}

	}

	public static String calc4(String x, String y) {
		//TODO: Calculation for division.
		int a = x.indexOf(":");
		int b = x.indexOf(" ");
		String ww = x.substring(a + 1, b);
		String xw = x.substring(b + 1);
		int c = xw.indexOf(":");
		int d = xw.indexOf(" ");
		String xn = xw.substring(d);
		String nn = xw.substring(c + 1, d);
		int e = xn.indexOf(":");
		String dd = xn.substring(e + 1);
		int w1 = Integer.parseInt(ww);
		int n1 = Integer.parseInt(nn);
		int d1 = Integer.parseInt(dd);

		int i = y.indexOf(":");
		int j = y.indexOf(" ");
		String www = y.substring(i + 1, j);
		String yw = y.substring(j + 1);
		int k = yw.indexOf(":");
		int l = yw.indexOf(" ");
		String yn = yw.substring(l);
		String nnn = yw.substring(k + 1, l);
		int m = yn.indexOf(":");
		String ddd = yn.substring(m + 1);
		int w2 = Integer.parseInt(www);
		int n2 = Integer.parseInt(nnn);
		int d2 = Integer.parseInt(ddd);
		if (w1 == 0) {
			if (w2 == 0) {
				int peng1 = (n1 * d2);
				int peng2 = (n2 * d1);
				return (peng1 + "/" + peng2);
			} else {
				int peng1 = (n1 * d2);
				int peng2 = ((w2 / Math.abs(w2)) * (((Math.abs(w2) * d2) + n2)) * d1);
				return (peng1 + "/" + peng2);
			}
		} else {
			if (w2 == 0) {
				int peng1 = ((w1 / Math.abs(w1)) * (((Math.abs(w1) * d1) + n1)) * d2);
				int peng2 = (n2 * d1);
				return (peng1 + "/" + peng2);
			} else {
				int peng1 = ((w1 / Math.abs(w1)) * (((Math.abs(w1) * d1) + n1)) * d2);
				int peng2 = ((w2 / Math.abs(w2)) * (((Math.abs(w2) * d2) + n2)) * d1);
				return (peng1 + "/" + peng2);
			}
		}
	}
}
