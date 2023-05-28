package hust.soict.dsai.lab01;
import java.util.Scanner;

public class DaysOfMonth{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
		int d;
		String m;
		int y;
		do {
			m = sc.next();
			y = sc.nextInt();
			System.out.println(m + " " +  y);
			switch(m) {
				case "January":
				case "Jan.":
				case "Jan":
				case "1":
				case "March":
				case "Mar.":
				case "Mar":
				case "3":
				case "May":
				case "5":
				case "July":
				case "Jul":
				case "7":
				case "August":
				case "October":
				case "Oct.":
				case "Oct":
				case "10":
				case "December":
				case "Dec.":
				case "Dec":
				case "12":
					d = 31;
					break;
				case "April":
				case "Apr.":
				case "Apr":
				case "4":
				case "June":
				case "Jun":
				case "6":
				case "September":
				case "Sept.":
				case "Sep":
				case "9":
				case "November":
				case "Nov.":
				case "Nov":
				case "11":
					d = 30;
					break;
				case "February":
				case "Feb.":
				case "Feb":
				case "2":
					if ((y % 4 == 0) && (y % 400 == 0 || y % 100 != 0)) {
						d = 29;
					} else {
						d = 28;
					}
					break;
			
				default:
					d = 0;
					if (d == 0 || y < 0) {
						System.out.print("Invalid month/year, please try again !");
					}
				}
		} while (d == 0 || y < 0);
		System.out.print("number days of month: ");
		System.out.print(d);
		sc.close();
   }
}
