package Restaurant;

import java.util.Scanner;

public class OtherMethods {
	
	Scanner sc = new Scanner(System.in);
	
	public String AmOrPm(){
		int choice;
		do{
				System.out.println("Type 1 for AM session and 2 for PM session. 3 to quit.");
				choice = sc.nextInt();
				if (choice == 1)
					return "AM";
				else if (choice == 2)
					return "PM";
				else if (choice ==3)
					return "NIL";
		}while(true);
	}

}
