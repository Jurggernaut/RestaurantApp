package Restaurant;


import java.util.*;

public class MainApplication {
	public static void main(String[] args){
	
	int choice = 0;
	int i;
	
	Scanner sc = new Scanner(System.in);
	
	//menu list
	Items[] ItemMenu = new Items[40];
	for (i=0;i<40;i++){
		ItemMenu[i] = new Items();
	}
	Packages[] PackageMenu = new Packages[20];
	for (i=0;i<20;i++){
		PackageMenu[i] = new Packages();
	}
	Order[] OrderList = new Order[100];
	for (i=0; i<100;i++){
		OrderList[i] = new Order();
	}
	
	Reservation[] ReservationList = new Reservation[500];
	for (i=0; i<500; i++){
		ReservationList[i] = new Reservation();
	}
	
	System.out.println("Application online");
	
	while(choice !=8){
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
			case(2): PackageMethod(PackageMenu);
				break;
			case (3): for (i =0; i<40; i++){
					if(ItemMenu[i].Name != "NIL")
						ItemMenu[i].printItem();
					}
			
					for (i=0; i<20;i++){
						if(PackageMenu[i].Name != "NIL")
							PackageMenu[i].printItem();
					}
					break;
		
			case(4): OrderMethod(OrderList, ItemMenu, PackageMenu);
				break;
			case(5): ReservationMethod();			
				break;
			case(6):
			case(7):
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
		String Name, type, Des;
		double price;
		
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
					sc.nextLine();
					Name = sc.nextLine();
					System.out.println("Write down the item's Description");
					String Describe = sc.nextLine();
					System.out.println("Write down the item's Type");
					String Type = sc.nextLine();
					System.out.println("Enter the item's price");
					price = sc.nextDouble();
					for (i =0; i<40; i++)
					{
						if(ItemsMenu[i]== null || ItemsMenu[i].Name == "NIL"){
							ItemsMenu[i] = new Items(Name,Describe,Type,price);
							System.out.println("Item added");
							ItemsMenu[i].printItem();
							return;
						}
					}
					System.out.println("Menu is full, remove an item first.");
					return;
					
		case(2):	System.out.println("Write down the item's name");
					sc.nextLine();
					Name = sc.nextLine();
					
					for (i =0; i<40; i++){
						if(ItemsMenu[i].Name == Name)
							break;
					}
					if (ItemsMenu[i].Name != Name){
						System.out.println("Item not found, terminating item choice");
						return;
					}
					System.out.println("Enter New Price");
					price = sc.nextDouble();
					ItemsMenu[i].changePrice(price);
					ItemsMenu[i].printItem();
					return;
					
					
		case(3):	System.out.println("Write down the item's name");
					sc.nextLine();
					Name = sc.nextLine();
					for (i =0; i<40; i++){
						if(ItemsMenu[i].Name == Name)
							break;
					}
					if (ItemsMenu[i].Name != Name){
						System.out.println("Item not found, terminating item choice");
						return;
					}
					System.out.println("Enter New Type");
					type = sc.nextLine();
					ItemsMenu[i].changeType(type);
					ItemsMenu[i].printItem();
					return;
					
		case(4):	System.out.println("Write down the item's name");
					sc.nextLine();
					Name = sc.nextLine();
					for (i =0; i<40; i++){
						if(ItemsMenu[i].Name == Name)
							break;
					}	
					if (ItemsMenu[i].Name != Name){
						System.out.println("Item not found, terminating item choice");
						return;
					}
					System.out.println("Enter New Description");
					Des = sc.nextLine();
					ItemsMenu[i].changeDescription(Des);
					ItemsMenu[i].printItem();
					return;
					
		case(5):	System.out.println("Write down the item's name");
					sc.nextLine();
					Name = sc.nextLine();
					for (i =0; i<40; i++){
						if(ItemsMenu[i].Name == Name)
							break;
					}	
					if (ItemsMenu[i].Name != Name){
						System.out.println("Item not found, terminating item choice");
						return;
					}
					
					ItemsMenu[i].clearItem();
					System.out.println("Item " + Name + " has been cleared from the menu.");
					return;
					
					
		case(6):	System.out.println("Write down the item's name");
					sc.nextLine();
					Name = sc.nextLine();
					for (i =0; i<40; i++){
						if(ItemsMenu[i].Name == Name)
							break;
					}	
					if (ItemsMenu[i].Name != Name){
						System.out.println("Item not found, terminating item choice");
						return;
					}
					ItemsMenu[i].printItem();
					return;
					
		case(7):	System.out.println("Returning to main menu");
					return;
		default:	System.out.println("Error, returning to main menu");
					return;
		}
	}
	
	public static void PackageMethod(Packages[] PackageMenu){
		
		Scanner sc = new Scanner(System.in);
		int i;
		String Name, type, Des;
		double price, newPrice;
	
		System.out.println("Please make a choice of what you wish to do to a package");
		System.out.println("1) Add Package");
		System.out.println("2) Change Package Old and New Price");
		System.out.println("3) Change Package Description");
		System.out.println("4) Clear Package");
		System.out.println("5) Print out Package description");
		System.out.println("6) Exit");
		int choice = sc.nextInt();
		switch(choice){
			case(1): System.out.println("Write down the package's name");
					sc.nextLine();
					Name = sc.nextLine();
					System.out.println("Write down the package's Description");
					String Describe = sc.nextLine();

					System.out.println("Enter the package's old Price");
					price = sc.nextDouble();
					System.out.println("Enter the package's new Price");
					newPrice = sc.nextDouble();
					for (i =0; i<20; i++)
					{
						if(PackageMenu[i]== null || PackageMenu[i].Name == "NIL"){
							PackageMenu[i] = new Packages(Name,Describe,price,newPrice);
							System.out.println("Item added");
							PackageMenu[i].printItem();
							return;
						}
					}
					System.out.println("Menu is full, remove an package first.");
					return;
				
		case(2):	System.out.println("Write down the package's name");
					sc.nextLine();
					Name = sc.nextLine();

					for (i =0; i<20; i++){
						if(PackageMenu[i].Name == Name)
							break;
					}
					if (PackageMenu[i].Name != Name){
						System.out.println("Package not found, terminating item choice");
						return;
					}
					System.out.println("Enter Old Price");
					price = sc.nextDouble();					
					System.out.println("Enter New Price");
					newPrice = sc.nextDouble();
					PackageMenu[i].changePrices(price, newPrice);
					PackageMenu[i].printItem();
					return;
				
				
		case(3):	System.out.println("Write down the Package's name");
					sc.nextLine();
					Name = sc.nextLine();
					for (i =0; i<20; i++){
						if(PackageMenu[i].Name == Name)
							break;
					}	
					if (PackageMenu[i].Name != Name){
						System.out.println("Package not found, terminating item choice");
						return;
					}
					System.out.println("Enter New Description");
					Des = sc.nextLine();
					PackageMenu[i].changeDescription(Des);
					PackageMenu[i].printItem();
					return;
				
		case(4):	System.out.println("Write down the Package's name");
					sc.nextLine();
					Name = sc.nextLine();
					for (i =0; i<20; i++){
						if(PackageMenu[i].Name == Name)
							break;
					}	
					if (PackageMenu[i].Name != Name){
						System.out.println("Package not found, terminating item choice");
						return;
					}
					
					PackageMenu[i].clearItem();
					System.out.println("Package " + Name + " has been cleared from the menu.");
					return;
				
				
		case(5):	System.out.println("Write down the Package's name");
					sc.nextLine();
					Name = sc.nextLine();
					for (i =0; i<40; i++){
						if(PackageMenu[i].Name == Name)
							break;
					}	
					if (PackageMenu[i].Name != Name){
						System.out.println("Item not found, terminating item choice");
						return;
					}
					PackageMenu[i].printItem();
					return;
				
		case(6):	System.out.println("Returning to main menu");
					return;
		default:	System.out.println("Error, returning to main menu");
					return;
		}	
	}
	
	public static void OrderMethod(Order[] OrderList, Items[] ItemMenu, Packages[] PackageMenu){
		Scanner sc = new Scanner(System.in);
		int i, id, table;
		String Name, type, Des, flush, staff;
		double price, newPrice;
	
		System.out.println("Please make a choice of what you wish to do to an Order");
		System.out.println("1) New Order");
		System.out.println("2) Edit Order");
		System.out.println("3) Delete Order (Warning! Deleted orders status are not added to data");
		// orders usually removed via customer leaving procedure, option 4 just in case something happens
		System.out.println("4) Print out order current status");
		System.out.println("5) Exit");
		int choice = sc.nextInt();
		switch(choice){
		case (1): 	System.out.println("Enter ID of the new Order");
					sc.nextLine();
				  	id = sc.nextInt();
				  	for (i=0; i<100; i++){
						if(OrderList[i].ID == id){
							System.out.println("There is already an order with that ID");
							return;
						}
					}
				  	sc.nextLine();
				  	System.out.println("Enter name of the staff in charge");
				  	staff = sc.nextLine();
				  	System.out.println("Enter Table ID");
				  	table = sc.nextInt();
				  	for (i =0; i<100; i++)
					{
						if(OrderList[i].ID == 0){
							OrderList[i] = new Order(id, staff, table);
							System.out.println("Item added");
							MakeOrder(OrderList[i], ItemMenu, PackageMenu);
							OrderList[i].PrintOrder();
							return;
						}
					}
				  	System.out.println("Order list too full, please remove Order");
				  	return;
				  	
		case (2):	System.out.println("Enter Order ID");
					sc.nextLine();
					id = sc.nextInt();
					for(i = 0; i<100; i++){
						if(OrderList[i].ID == id)
							break;
					}
					if (OrderList[i].ID != id){
						System.out.println("There is no such order");
						return;
					}
					else{
						MakeOrder(OrderList[i], ItemMenu, PackageMenu);
						return;
					}
		case (3):	System.out.println("Enter Order ID");
					sc.nextLine();
					id = sc.nextInt();
					for(i = 0; i<100; i++){
						if(OrderList[i].ID == id)
							break;
					}
					if (OrderList[i].ID != id){
						System.out.println("There is no such order");
						return;
					}
					else{
						OrderList[i].removeOrder();
						return;					
					}
		case (4):	System.out.println("Enter Order ID");
					sc.nextLine();
					id = sc.nextInt();
					for(i = 0; i<100; i++){
						if(OrderList[i].ID == id)
							break;
					}
					if (OrderList[i].ID != id){
						System.out.println("There is no such order");
						return;
					}
					else{
						OrderList[i].PrintOrder();
						return;
					}
		case (5):	System.out.println("Exiting Order System");
					return;
		default:	System.out.println("Error in choice, terminating Order System");
					return;
		
		}
		
	}
	
	public static void MakeOrder(Order order, Items[] ItemMenu, Packages[] PackageMenu){
		int choice = 0;
		int i,j;
		String name;
		Items item;
		Packages pack;
		Scanner sc = new Scanner(System.in);
		System.out.println("Processing order " + order.ID);
		while (choice != 6){
			System.out.println("Please make a choice of what you wish to do to the Order");
			System.out.println("1) Add Items in Order");
			System.out.println("2) Add Package in Order");
			System.out.println("3) Delete Item in Order");
			System.out.println("4) Delete Package in Order");
			System.out.println("5) Print out orders current status");
			System.out.println("6) Exit");
			choice = sc.nextInt();
			switch(choice){
			case (1):	System.out.println("Enter Item Name");
						sc.nextLine();
						name = sc.nextLine();
						for (i = 0; i<40; i++){
							if (ItemMenu[i].Name == name)
								break;
						}
						if (ItemMenu[i].Name != name){
							System.out.println("There is no such item in menu");
						}
						else{
							item = ItemMenu[i];
							order.AddItem(item);
							System.out.println("Item added");
						}
						break;
			case (2):	System.out.println("Enter Package Name");
						sc.nextLine();
						name = sc.nextLine();
						for (i = 0; i<40; i++){
							if (PackageMenu[i].Name == name)
								break;
						}
						if (PackageMenu[i].Name != name){
							System.out.println("There is no such Package in menu");
						}
						else{
							pack = PackageMenu[i];
							order.AddItem(pack);
							System.out.println("Package added");
						}
						break;
			case (3):	System.out.println("Enter Item Name");
						sc.nextLine();
						name = sc.nextLine();
						for (i = 0; i<40; i++){
							if (ItemMenu[i].Name == name)
								break;
						}
						if (ItemMenu[i].Name != name){
							System.out.println("There is no such item in menu");
						}
						else{
							item = ItemMenu[i];
							order.RemoveItem(item);
							System.out.println("Item removed");
						}
						break;
			case (4):	System.out.println("Enter Package Name");
						sc.nextLine();
						name = sc.nextLine();
						for (i = 0; i<40; i++){
							if (PackageMenu[i].Name == name)
								break;
						}
						if (PackageMenu[i].Name != name){
							System.out.println("There is no such Package in menu");
						}
						else{
							pack = PackageMenu[i];
							order.RemoveItem(pack);
							System.out.println("Package removed");
						}
						break;
			case (5): 	order.PrintOrder();
						break;
			case (6):	break;
			default:	System.out.println("Error, choose again");
						break;
			
			}
		}
	}
	
	public static void ReservationMethod(){
		int choice = 0;
		int i,j;
		String name;
		Items item;
		Packages pack;
		Scanner sc = new Scanner(System.in);
		Calendar cal = Calendar.getInstance();
		double currentTime = (cal.get(Calendar.HOUR) + (double)cal.get(Calendar.MINUTE)/100);

		while (choice != 6){
			System.out.println("Please make a choice of what you wish to do to reservations");
			System.out.println("1) Add Reservation");
			System.out.println("2) Edit Reservation");
			System.out.println("3) Delete Reservation");
			System.out.println("4) Check Reservation on current statues");
			//Removes all expired reservation while causing all tables reserved at that time to be set to occupied
			System.out.println("5) Print out Reservation");
			System.out.println("6) Exit");
			choice = sc.nextInt();
			switch(choice){
			case (1):
			case (2):
			case (3):
			case (4):
			case (5):
			case (6):
			default:
			
				}
			}
		
	}
	
	}
