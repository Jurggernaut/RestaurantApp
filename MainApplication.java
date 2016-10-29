package Restaurant;
import java.text.*;
import java.util.*;

public class MainApplication {
	public static void main(String[] args){
	
	int choice = 0;
	String dateFormat = "HH:mm dd/MM/yyyy";
    SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
	Scanner sc = new Scanner(System.in);
	
	//menu list
	Items[] ItemMenu = new Items[40];
	
	System.out.println("Application online");
	
	while(choice !=5){
		System.out.println("Please make a choice by choosing a number");
		System.out.println("1) Item options");
		System.out.println("2) Packages options");
		System.out.println("3) Print Menu");
		System.out.println("4) Order options");
		System.out.println("5) Reservation Options");
		System.out.println("6) Customer Registration options");
		System.out.println("7) Customer leaving Procedure");
		System.out.println("8) Shut down Application");
		
		choice = sc.nextInt();
		switch(choice){
			case(1): ItemMethod(ItemMenu);
				break;
			case(2): PackageMethod();
				break;
			case(4): OrderMethod();
				break;
			case(5): ReservationMethod();
			System.out.println("Please enter the date in the format: " + dateFormat + ", e.g. 19:10 24/03/2016");
	        String dateInString = sc.nextLine();
	        try {
	            Date date = formatter.parse(dateInString);
	            Calendar reservationDate = Calendar.getInstance();
	            reservationDate.setTime(date);
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
				break;
			case(8): System.out.println("Application will shut down");
				break;
			default: System.out.println("Error in choice, restarting choice selection");
			break;
		}
	}
	
	
		
	}
	
	public static void ItemMethod(Items[] ItemsMenu){
		
		Scanner sc = new Scanner(System.in);
		int i;
		
		System.out.println("Please make a choice of what you wish to do to an item");
		System.out.println("1) Add item");
		System.out.println("2) Change Item Price");
		System.out.println("3) Change Item Type");
		System.out.println("4) Change Item Description");
		System.out.println("5) Clear Item");
		System.out.println("6) Print out item description");
		System.out.println("7) Exit");
		int choice = sc.nextInt();
		switch(choice){

		case(1): 	System.out.println("Write down the item's name");
					String Name = sc.nextLine();
					System.out.println("Write down the item's Description");
					String Describe = sc.nextLine();
					System.out.println("Write down the item's Type");
					String Type = sc.nextLine();
					String flush = sc.nextLine();
					System.out.println("Enter the item's price");
					double price = sc.nextDouble();
					for (i =0; i<40; i++)
					{
					ItemsMenu[i] = new Items(Name,Describe,Type,price);
					}
					break;
		case(2):
		case(3):
		case(4):
		case(5):
		case(6):
		case(7):
		default:
		}
	}

}
