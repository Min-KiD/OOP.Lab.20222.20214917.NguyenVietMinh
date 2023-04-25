import java.util.Scanner;
import java.lang.Math;

class FirstEquation {
	public void Solving() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Solve first-degree equation form: ax + b = 0");
		System.out.print("Enter a: ");
		double a = sc.nextDouble();
		System.out.print("Enter b: ");
		double b = sc.nextDouble();
		if (a == 0){
			if (b == 0) {
				System.out.println("Infinitely solutions");
			}
			else {
				System.out.println("No solution");
			}
		}
		else {
			System.out.println("One solution: x = " + (-b/a));
		}
		sc.close();
	}

}
class SystemFirstEquation {
	public void Solving() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Solve system of first-degree equations form: a1x + b1y = c1");
		System.out.println("					     a2x + b2y = c2");
		System.out.print("Enter a1: ");
		double a1 = sc.nextDouble();
		System.out.print("Enter b1: ");
		double b1 = sc.nextDouble();
		System.out.print("Enter a2: ");
		double a2 = sc.nextDouble();
		System.out.print("Enter b2: ");
		double b2 = sc.nextDouble();
		System.out.print("Enter c1: ");
		double c1 = sc.nextDouble();
		System.out.print("Enter c2: ");
		double c2 = sc.nextDouble();
		double D = a1*b2 - a2*b1;
		System.out.println("The determinant of the coefficients is "+ D);
		if (a2/a1 == b2/b1) {
			if (a2/a1 == c2/c1) {
				System.out.println("Infinitely solutions with form y = ("+c1+" - "+a1+"x) / "+b1);
			}  else {
				System.out.println("No solutions");
			}
		} else {
			System.out.println("One solution: y = "+(a1*c2 - a2*c1) / D+", x = "+(c1*b2 - c2*b1) / D);
		}
		sc.close();
	}

}

class SecondEquation {
	public void Solving() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Solve second-degree equations form: ax^2 + bx + c = 0");
		System.out.print("Enter a: ");
		double a = sc.nextDouble();
		System.out.print("Enter b: ");
		double b = sc.nextDouble();
		System.out.print("Enter c: ");
		double c = sc.nextDouble();
		double delta = Math.pow(b, 2) - 4*a*c;
		System.out.println("The delta of the coefficients is "+ delta);
		if (a != 0) {
			if (delta > 0) {
				System.out.println("The equation has 2 roots: ");
				System.out.println("x1 = "+ ((-b+ Math.sqrt(delta))/(2*a)));
				System.out.println("x2 = "+ ((-b - Math.sqrt(delta))/(2*a)));
			} else if (delta == 0) {
				System.out.println("The equation has 1 root: ");
				System.out.println("x = "+ ((-b/(2*a))));
			} else {
				System.out.println("The equation has no root ");
			}
		} else {
			if (b == 0) {
				if (c == 0) {
					System.out.println("The equation has infitely solutions");
				} else {
					System.out.println("The equation has no root");
				}
			} else {
				System.out.println("The equation has 1 root: x = "+ (-c/b));
			}
	}
		sc.close();
	}

}

public class SolvingEquation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose the equations you want to solve: ");
		System.out.println("1. The first-degree equation (linear equation) with one variable");
		System.out.println("2. The system of first-degree equations (linear system) with two variables");
		System.out.println("3. The second-degree equation with one variable");
		System.out.print("Enter 1 or 2 or 3: ");
		boolean flag;
		do {
			int n = sc.nextInt();
			flag = true;
			if (n == 1) {
				FirstEquation solve = new FirstEquation();
				solve.Solving();
				
			} else if (n == 2) {
				SystemFirstEquation solve = new SystemFirstEquation();
				solve.Solving();
			} else if (n == 3) {
				SecondEquation solve = new SecondEquation();
				solve.Solving();
			} else {
				System.out.print("Wrong input, try again !");
				flag = false;
			}
		} while (flag == false);
		sc.close();
	}
	
}
