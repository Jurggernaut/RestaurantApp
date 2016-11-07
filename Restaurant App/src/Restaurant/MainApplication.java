package Restaurant;


import java.util.*;
import java.io.*;

public class MainApplication {
	public static void main(String[] args){
		
	int id;

	int choice = 0;
	int i;
	
	Scanner sc = new Scanner(System.in);
	
	//menu list
	Items[] ItemMenu = new Items[41];
	for (i=0;i<40;i++){
		ItemMenu[i] = new Items();
	}
	Packages[] PackageMenu = new Packages[21];
	for (i=0;i<20;i++){
		PackageMenu[i] = new Packages();
	}
	Order[] OrderList = new Order[101];
	for (i=0; i<100;i++){
		OrderList[i] = new Order();
	}
	
	Reservation[] ReservationList = new Reservation[501];
	for (i=0; i<500; i++){
		ReservationList[i] = new Reservation();
	}
	
	Table[] Tables = new Table[30];
	for(i=0;i<5;i++){
		Tables[i] = new Table(i, 10);
	}
	
	for(i=5;i<10;i++){
		Tables[i] = new Table(i, 8);
	}
	
	for(i=10;i<20;i++){
		Tables[i] = new Table(i, 4);
	}
	
	for(i=20;i<30;i++){
		Tables[i] = new Table(i, 2);
	}
	
	loadItems(ItemMenu);
	loadReservations(ReservationList);
	loadPackages(PackageMenu);
	
	System.out.println("Application online");
	
	while(choice !=11){
		try{
		System.out.println(" ");
		System.out.println("Please make a choice by choosing a number");
		System.out.println("1) Item options");
		System.out.println("2) Packages options");
		System.out.println("3) Print Menu");
		System.out.println("4) Order options");
		System.out.println("5) Reservation Options");
		System.out.println("6) Print Free Tables");
		System.out.println("7) Table Options"); 
		System.out.println("8) Customer Registration options");
		System.out.println("9) Customer leaving Procedure");
		System.out.println("10) Monthly report");
		System.out.println("11) Shut down Application");
		
		choice = sc.nextInt();
		sc.nextLine();
		switch(choice){
			case(1): ItemMethod(ItemMenu);
				break;
			case(2): PackageMethod(PackageMenu, ItemMenu);
				break;
			case (3): for (i =0; i<40; i++){
					if(ItemMenu[i].getName().equals("NIL")== false){
						ItemMenu[i].printItem();
						System.out.println(" ");
					}
					}
			
					for (i=0; i<20;i++){
						if(PackageMenu[i].getName().equals("NIL") == false){
							PackageMenu[i].printItem();
							System.out.println(" ");
						}
					}
					break;
		
			case(4): OrderMethod(OrderList, ItemMenu, PackageMenu);
				break;
			case(5): ReservationMethod(ReservationList);			
				break;
			case(6): 
				OccupiedCheck(Tables, ReservationList);
				for(i=0;i<30;i++){
					if(Tables[i].getOccupied() == false){
						
						Tables[i].printDetails();
						System.out.println(" ");
					}
				}
				break;
				
			case(7):
				TableMethod(Tables);
				break;
			
			case(8): 
				OccupiedCheck(Tables, ReservationList);
				Registration(Tables);
				break;
			case(9):
				System.out.println("Enter Order ID");
				id = sc.nextInt();
				for(i=0;i<100;i++){
					if(OrderList[i].ID == id)
						break;
				}
				if(OrderList[i]== null){
					System.out.println("There is no such order");
					break;
				}
				else
				{	
				System.out.println("You were served by " + OrderList[i].StaffinCharge);
				OrderList[i].PrintOrder();
				System.out.println("Your Total is : " + OrderList[i].calculatePrice());
				Order Inserted = OrderList[i];
				saveOrderHistory(Inserted);
				OrderList[i].removeOrder();
				sc.nextLine();
				}
				break;
			case(10): ReadMonthlyEarnings();
				break;
			case(11): System.out.println("Application will shut down");
				break;
			default: System.out.println("Error in choice, restarting choice selection");
			break;
		}
		}catch(InputMismatchException e){
			System.out.println("Error in input");
			sc.nextLine();
		}
		
		
		

	}
	
	saveItems(ItemMenu);
	saveReservations(ReservationList);
	savePackages(PackageMenu);
		
	}
	
	//Methods split up for each and every manipulation of the items, package, order, table and reservation
	//For ease of editing for that specific component
	
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
						if(ItemsMenu[i].getName().equals("NIL")==true){
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
						System.out.println(i);
						if(ItemsMenu[i].getName().equals(Name)){
							break;
						}
					}
					if (ItemsMenu[i] == null){
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
						if(ItemsMenu[i].getName().equals(Name))
							break;
					}
					if (ItemsMenu[i]== null){
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
						if(ItemsMenu[i].getName().equals(Name))
							break;
					}
					if (ItemsMenu[i] == null){
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
						if(ItemsMenu[i].getName().equals(Name))
							break;
					}
					if (ItemsMenu[i] == null){
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
						if(ItemsMenu[i].getName().equals(Name))
							break;
					}	
					if (ItemsMenu[i] == null){
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
	
	public static void PackageMethod(Packages[] PackageMenu, Items[] ItemMenu){
		
		Scanner sc = new Scanner(System.in);
		int i,j,k;
		String Name, ItemName, Des;
		Items item;
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
					j = 1;
					for (i =0; i<20; i++)
					{
						if(PackageMenu[i].getName().equals("NIL")==true){
							PackageMenu[i] = new Packages(Name,Describe,price,newPrice);
							PackageMenu[i].setPackages();
							while(j == 1){
								System.out.println("Enter Item Name");
								sc.nextLine();
								ItemName = sc.nextLine();
								for (k = 0; k<40; k++){
									if (ItemMenu[k].getName().equals(ItemName))
										break;
								}
								if (ItemMenu[k] == null){
									System.out.println("There is no such item in menu");
								}
								else{
									item = ItemMenu[k];
									PackageMenu[i].addItem(item);
									System.out.println("Item added");
								}
								System.out.println("Enter 1 to continue, any other number to stop adding items");
								j = sc.nextInt();
							}
							System.out.println("Package added");
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
						if(PackageMenu[i].getName().equals(Name))
							break;
					}
					if (PackageMenu[i] == null){
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
						if(PackageMenu[i].getName().equals(Name))
							break;
					}	
					if (PackageMenu[i] == null){
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
						if(PackageMenu[i].getName().equals(Name))
							break;
					}	
					if (PackageMenu[i] == null){
						System.out.println("Package not found, terminating item choice");
						return;
					}
					
					PackageMenu[i].clearItem();
					System.out.println("Package " + Name + " has been cleared from the menu.");
					return;
				
				
		case(5):	System.out.println("Write down the Package's name");
					sc.nextLine();
					Name = sc.nextLine();
					for (i =0; i<20; i++){
						if(PackageMenu[i].getName().equals(Name))
							break;
					}	
					if (PackageMenu[i]== null){
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
	
	public static void TableMethod(Table[] Tables){
		int table;
		int choice;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Table ID");
		table = sc.nextInt();
		if(Tables[table].occupied == true){
			System.out.println("Table is Occupied, type 1 to free up table");
			choice = sc.nextInt();
			if(choice == 1){
				Tables[table].isFree();
			}
		}
		else{
			System.out.println("Table is Free, type 1 to occupy table");
			choice = sc.nextInt();
			if(choice == 1){
				Tables[table].isOccupied();
			}
		}
	}
	
	public static void OrderMethod(Order[] OrderList, Items[] ItemMenu, Packages[] PackageMenu){
		Scanner sc = new Scanner(System.in);
		int i, id, table;
		String staff;

	
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
							OrderList[i].setOrder();
							System.out.println("Order added");
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
					if (OrderList[i] == null){
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
					if (OrderList[i] == null){
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
					if (OrderList[i] == null){
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
		int i;
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
							if (ItemMenu[i].getName().equals(name))
								break;
						}
						if (ItemMenu[i] == null){
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
						for (i = 0; i<20; i++){
							if (PackageMenu[i].getName().equals(name))
								break;
						}
						if (PackageMenu[i]== null){
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
						for (i = 0; i<20; i++){
							if (order.Itemlist[i].getName().equals(name))
								break;
						}
						if (order.Itemlist[i] == null){
							System.out.println("There is no such item in the order");
						}
						else{
							order.Itemlist[i].clearItem();
							System.out.println("Item removed");
						}
						break;
			case (4):	System.out.println("Enter Package Name");
						sc.nextLine();
						name = sc.nextLine();
						for (i = 0; i<5; i++){
							if (order.Packagelist[i].getName().equals(name))
								break;
						}
						if (order.Packagelist[i] == null){
							System.out.println("There is no such Package in order");
						}
						else{
							order.Packagelist[i].clearItem();
							System.out.println("Package removed");
						}
						break;
			case (5): 	order.PrintOrder();
						break;
						
			case (6):	System.out.println("Returning to main menu");
						break;
			default:	System.out.println("Error, choose again");
						break;
			
			}
		}
	}
	
	public static void ReservationMethod(Reservation[] ReservationList){
		int choice = 0;
		int i, id;
		int tid, y, mm, d, h, m;
		GregorianCalendar Res;
		Scanner sc = new Scanner(System.in);


		while (choice != 5){
			System.out.println("Please make a choice of what you wish to do to reservations");
			System.out.println("1) Add Reservation");
			System.out.println("2) Edit Reservation");
			System.out.println("3) Delete Reservation");
			System.out.println("4) Print out Reservation");
			System.out.println("5) Exit");
			choice = sc.nextInt();
			switch(choice){
			case (1):
				System.out.println("Enter ID of the new Order");
				sc.nextLine();
				id = sc.nextInt();
				for (i=0; i<500; i++){
					if(ReservationList[i].ID == id){
						System.out.println("There is already an order with that ID");
						return;
					}
				}
				System.out.println("Enter tableID: ");
				tid =sc.nextInt();
				System.out.println("Enter Year: ");
				y =sc.nextInt();
			    System.out.println("Enter Month: ");
			    m =sc.nextInt();
			    System.out.println("Enter Day: ");
			    d = sc.nextInt();
			    System.out.println("Enter Hour: ");
			    h = sc.nextInt();
			    System.out.println("Enter Minute: ");
			    mm = sc.nextInt();
			    Res = new GregorianCalendar(y,m,d,h,mm);
			    for (i =0; i<500; i++)
				{
					if(ReservationList[i].ID == 0){
						ReservationList[i] = new Reservation(id, tid, Res);
						System.out.println("Reservation added");

						return;
					}
				}
			  	System.out.println("Reservation list too full, please remove Reservation");
			  	return;
			    
			    

			case (2): 
				System.out.println("Enter Reservation ID");
				sc.nextLine();
				id = sc.nextInt();
				for(i = 0; i<500; i++){
					if(ReservationList[i].ID == id)
						break;
				}
				if (ReservationList[i] == null){
					System.out.println("There is no such reservation");
					return;
				}
				else{
					System.out.println("Enter new tableID: ");
					tid =sc.nextInt();
					System.out.println("Enter new Year: ");
					y =sc.nextInt();
				    System.out.println("Enter new Month: ");
				    m =sc.nextInt();
				    System.out.println("Enter new Day: ");
				    d = sc.nextInt();
				    System.out.println("Enter new Hour: ");
				    h = sc.nextInt();
				    System.out.println("Enter new Minute: ");
				    mm = sc.nextInt();
				    Res = new GregorianCalendar(y,m,d,h,mm);
				    ReservationList[i] = new Reservation(id, tid, Res);
				    System.out.println("Reservatoin changed");
				    return;
			}
			case (3):
				System.out.println("Enter Reservation ID");
				sc.nextLine();
				id = sc.nextInt();
				for(i = 0; i<500; i++){
					if(ReservationList[i].ID == id)
						break;
				}
				if (ReservationList[i] == null){
					System.out.println("There is no such reservation");
					return;
				}
				else{
					ReservationList[i].clearReservation();
					return;
		}
			case (4):
				System.out.println("Enter Reservation ID");
				sc.nextLine();
				id = sc.nextInt();
				for(i = 0; i<500; i++){
					if(ReservationList[i].ID == id)
						break;
				}
				if (ReservationList[i] == null){
					System.out.println("There is no such reservation");
					return;
				}
				ReservationList[i].printReservation();
				return;
				
			case (5): 
				System.out.println("Exiting Reservation Menu");
				return;
			default:
				System.out.println("Error, choose again");
				break;
			
				}
			}
		
	}
	
//Method for registration and leaving Procedures
	
	public static void Registration(Table[] Tables){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter table ID to be taken");
		int id = sc.nextInt();
		if(Tables[id].getOccupied() == true)
			System.out.println("Table is already taken, returning to main menu");
		else{
			Tables[id].isOccupied();
			System.out.println("Table " + id + "is now occupied");
		}
		
	}
	
	public static void Leaving(Table[] Tables, Order Order){
		
	}
	
	//Method OccupiedCheck to re-check the state of the tables and change the occupation accordingly,
	//Used in functions when the state of the table and reservations need to be checked
	
	public static void OccupiedCheck(Table[] Tables, Reservation[] Reservations){
		int i,j;
		for (i=0;i<500;i++){
			if(Reservations[i].checkTime() == false){
				Reservations[i].clearReservation();
			}
			
		}
		for (i=0;i<30;i++){
			for(j=0;j<500;j++){
				if (Tables[i].ID == Reservations[j].tableID && Tables[i].getOccupied() == false
						&& Reservations[j].checkTable() == true){
					Tables[i].isOccupied();
				}
			}
		}		

	}
	
	// Methods to load and save
	
	
	public static void saveItems(Items [] ItemsList) {
        try {
        	File file = new File("Items.list");
        	
        	if(!file.exists()){
        		file.createNewFile();
        	}
        	
            FileOutputStream fos = new FileOutputStream("Items.list");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            System.out.print("saving data to ItemsList ...\n");
            for(int i=0; i<ItemsList.length; i++) {
            	oos.writeObject(ItemsList[i]);
            }
            oos.close();
        } catch (IOException e) {
            System.out.println("File input error");
            System.out.println(e.getMessage());
        }
	}
	
	public static void loadItems(Items [] ItemsList) {
		try {
            FileInputStream fis = new FileInputStream("Items.list");
            ObjectInputStream ois = new ObjectInputStream(fis);

            System.out.print("reading data from ItemsList ...\n");        
            for(int i=0; i<ItemsList.length; i++) {
            	ItemsList[i] = (Items) ois.readObject();
            }
            ois.close();
        } catch (IOException e) {
            System.out.println("File input error");
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e);
            System.out.println(e.getMessage());
        }
	}
	
	public static void saveReservations(Reservation [] ReservationList) {
		try {
			File file = new File("Reservation.list");
        	
        	if(!file.exists()){
        		file.createNewFile();
        	}
			
			
            FileOutputStream fos = new FileOutputStream("Reservation.list");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            System.out.print("saving data to ReservationList ...\n");
            for(int i=0; i<ReservationList.length; i++) {
            	oos.writeObject(ReservationList[i]);
            }
            oos.close();
        } catch (IOException e) {
            System.out.println("File input error");
            System.out.println(e.getMessage());
        }
	}
	
	public static void loadReservations(Reservation [] ReservationList) {
		try {
            FileInputStream fis = new FileInputStream("Reservation.list");
            ObjectInputStream ois = new ObjectInputStream(fis);

            System.out.print("reading data from ReservationList ...\n");        
            for(int i=0; i<ReservationList.length; i++) {
            	ReservationList[i] = (Reservation) ois.readObject();
            }
            ois.close();
        } catch (IOException e) {
            System.out.println("File input error");
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e);
            System.out.println(e.getMessage());
        }
	}
	
	public static void savePackages(Packages[] Packagelist) {
		try {
			File file = new File("Package.list");
        	
        	if(!file.exists()){
        		file.createNewFile();
        	}
			
            FileOutputStream fos = new FileOutputStream("Package.list");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            System.out.print("saving data to PackageList ...\n");
            for(int i=0; i<Packagelist.length; i++) {
            	oos.writeObject(Packagelist[i]);
            }
            oos.close();
        } catch (IOException e) {
            System.out.println("File input error");
            System.out.println(e.getMessage());
        }
	}
	
	public static void loadPackages(Packages[] Packagelist) {
		try {
            FileInputStream fis = new FileInputStream("Package.list");
            ObjectInputStream ois = new ObjectInputStream(fis);

            System.out.print("reading data from PackageList ...\n");        
            for(int i=0; i<Packagelist.length; i++) {
            	Packagelist[i] = (Packages) ois.readObject();
            }
            ois.close();
        } catch (IOException e) {
            System.out.println("File input error");
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e);
            System.out.println(e.getMessage());
        }
	}
	
	//methods regarding order history
	
	//saveOrderHistory reloads the previous state of the monthly report, updates it, then replaces it
	
	public static void saveOrderHistory(Order Order) {
		Calendar now = Calendar.getInstance();
		int month, year, day;
		int i,j,k;
		Items item;
		Packages pack;
		
		
		MonthlySale[] List = new MonthlySale[201];
		for (i=0;i<200;i++){
			List[i] = new MonthlySale();
		}

		day = now.get(Calendar.DAY_OF_MONTH);
		month = now.get(Calendar.MONTH) + 1;
		year = now.get(Calendar.YEAR);
		try {
	      File folder = new File("" +year);
	     
	      
	      File folder2 = new File("" + year + "/" + month);
	      
	      File file = new File(""+ year + "/" + month + "/" + day);
	    
	      
          FileInputStream fis = new FileInputStream(file);
          ObjectInputStream ois = new ObjectInputStream(fis);
          
          for(i=0; i<List.length; i++) {
          	List[i] = (MonthlySale) ois.readObject();
          }
          ois.close();

      	 }catch (IOException e) {
             System.out.println("File not created yet, will be done soon");
             System.out.println(e.getMessage());
         } catch (ClassNotFoundException e) {
             System.out.println(e);
             System.out.println(e.getMessage());
         }
         
         //updating
		// first each item in the order
		
		for(i=0;i<10;i++){
			item = Order.Itemlist[i];
			if(item.getName().equals("NIL"))
				continue;
			for(j =0; j<200; j++){
				if(List[j].getItem().equals(item.getName())){
					List[j].addOne(item.Price);
					break;
				}
				else if(List[j].Item.equals("NIL")){
					break;
				}
			}
			if(List[j] !=null && List[j].getItem().equals("NIL")){
				List[j] = new MonthlySale(item.getName(),1,item.Price);
			}
		}
		
		//next each package in the order
		
		for (i=0;i<5;i++){
			pack = Order.Packagelist[i];
			if(pack.getName().equals("NIL"))
				continue;
			
			//first add each item without adding profit
			if(!pack.Name.equals("NIL")){
				for(j=0;j<10;j++){
					item = pack.Itemlist[j];
					if(item.getName().equals("NIL"))
						continue;
					for(k =0; k<200; k++){
						if(List[k].getItem().equals(item.getName())){
							List[k].addOnePack();
							break;
						}
						else if(List[k].Item.equals("NIL")){
							break;
						}
					}
					
					if(List[k] !=null && List[k].getItem().equals("NIL")){
						List[k] = new MonthlySale(item.getName(),1, 0);
					}

					}
				}
			
			//next add package with profit
				
				for(j=0;j<200;j++){
					if(List[j].getItem().equals(pack.getName())){
						List[j].addOne(pack.Price);
						break;
					}
					else if(List[j].Item.equals("NIL")){
						break;
					}
					
				}
				if(List[j] != null && List[j].getItem().equals("NIL")){
					List[j] = new MonthlySale(pack.getName(),1,pack.Price);
				}
			}
		
		
         // put back in the new file, recreating it as the updated file
	     try{
	    	 
		  File folder = new File("" +year);
		      
		  if(!folder.exists()){
	      		folder.mkdir();
		      }
		  
		  File folder2 = new File("" + year + "/" + month);
		  
		  if(!folder2.exists()){
	      		folder2.mkdir();
		      }
				  
		      
		  File file = new File("" + year + "/" + month + "/" + day);
		      
		  if(!file.exists()){
		    	  file.createNewFile();
		      }

		  FileOutputStream fos = new FileOutputStream(file);
	      ObjectOutputStream oos = new ObjectOutputStream(fos);
	      

	      
	      System.out.print("saving data to order history ...\n");
          for(i=0; i<List.length; i++) {
          	oos.writeObject(List[i]);
          }
	      
	      oos.close();
		} catch (IOException e) {
	      System.out.println("File input error");
	      System.out.println(e.getMessage());
	  }
	}
	
	public static void ReadMonthlyEarnings(){
		Scanner sc = new Scanner(System.in);
		int month, year, firstDay, secondDay;
		int i;
		MonthlySale[] List = new MonthlySale[201];
		for(i=0;i<200;i++){
			List[i] = new MonthlySale();
		}
		
		int totalProfit = 0;
		
		System.out.println("Enter year");
		year = sc.nextInt();
		System.out.println("Enter Month");
		month = sc.nextInt();
		try{
			IOException rangeProblem = new IOException();
			System.out.println("Enter beginning day of the month");
			firstDay = sc.nextInt();
			System.out.println("Enter end day of the month");
			secondDay = sc.nextInt();
			if(firstDay > secondDay)
				
				throw rangeProblem;
		}catch (IOException rangeProblem){
			System.out.println("Invalid range of date");
			return;
		}
		
		
		
		for (int j = firstDay; j <= secondDay; j++){
		try {
		      File folder = new File("" +year);
		     
		      File folder2 = new File("" + year + "/" + month);
		      
		      File file = new File("" + year + "/" + month + "/" + j);
		    
		      
	          FileInputStream fis = new FileInputStream(file);
	          ObjectInputStream ois = new ObjectInputStream(fis);
	          
	          for(i=0; i<List.length; i++) {
	          	List[i] = (MonthlySale) ois.readObject();
	          }
	          ois.close();

	      	 }catch (IOException e) {
	             System.out.println("Nothing was recorded on " + year + " " + month + " " + j);
	         } catch (ClassNotFoundException e) {
	             System.out.println(e);
	             System.out.println(e.getMessage());
	             return;
	         }
		
		}
		
		for (i=0;i<200;i++){
			if(!List[i].getItem().equals("NIL"))
			{
				List[i].printData();
			}
			totalProfit += List[i].profit;
		
		
		}
		System.out.println("Total profit for Year " + year + " and Month " + month + " = " + totalProfit);
		
		}
	


	
	}
