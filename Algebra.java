// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		while (x2 > 0){
			x1++;
			x2--;
		}
		while (x2 < 0) {
			x1--;
			x2++;
		}
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		while (x2 > 0){
			x1--;
			x2--;
		}
		while (x2 < 0) {
			x1--;
			x2++;
		}
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int sum = 0;
		while (x2 > 0) {
			sum = plus(sum,x1);
			x2--;
		}
		while (x2 < 0) {
			sum = minus(sum, x1);
			x2++;
		}
		return sum;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int sum = 1;
		if (n == 0){
			return 1;
		}
		if (x < 0) {
			while (n > 0) {
				sum = times(sum,x);
				n--;
			}
			return sum;
		}
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int count = 0;
		int x11 = 0;
		int x22 = 0;
		if (x1 < 0) {
			x11 = times(x1, -1);
		}
		if (x2 < 0) {
			x22 = times(x2, -1);
		}
		while (x1 >= x2) {
			x1 = minus(x1,x2);
			count++;
		}
		if ((x1 < 0 && x2 > 0) || (x1 > 0 && x2 < 0)) {
        return times(count, -1);
    	}
		else{
			return count;
		}
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		while (x1 >= x2) {
			x1 = minus(x1,x2);
		}
		return x1;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int check = 1;
		while (check > 0) {
			if ((pow(check, 2) <= x) && (x < pow(check +1, 2))) {
				return check;
			}
			else 
				check++;
		}
		return 0;
	}	  	  
}