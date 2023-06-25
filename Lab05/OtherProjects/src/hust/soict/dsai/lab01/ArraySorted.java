package hust.soict.dsai.lab01;

import java.util.Scanner;
import java.util.Arrays;

public class ArraySorted{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] a = new int [n];
		int sum = 0;
		for(int i=0; i < n; i++) {
			a[i] = sc.nextInt();
			sum += a[i];
		}
		Arrays.sort(a);
		double avg = (double)sum/n;
		System.out.println("The sorted array is: "+ Arrays.toString(a));
		System.out.println("The sum of array is: "+ sum);
		System.out.println("The average of array is: "+ avg);
		sc.close();
   }
}
