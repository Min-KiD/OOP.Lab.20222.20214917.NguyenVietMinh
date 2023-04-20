import java.util.Scanner;

public class TriangleStars{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = 1;
		String noti = "";
		while(n != 0) {
			for(int i = 0; i < n-1; i++) {
				noti += " ";
			}
			n--;
			for(int i = 0; i < k; i++) {
				noti += "*";
				
			}
			k+=2;
			if (n != 0) {
				noti += "\n";
			}
		}
		System.out.print(noti);
		sc.close();
   }
}
