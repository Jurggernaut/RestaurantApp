package Restaurant;

public class Order {
	private int ID;
	private int tableID;
	protected Items[] Itemlist;
	protected Packages[] Packagelist;
	private String StaffinCharge;

	
	Order(){
		ID = 0;
		tableID = 0;
		Itemlist = new Items[11];
		Packagelist = new Packages[6];
		StaffinCharge = "NIL";
	}
	

	
	Order(int id, String s, int table){
		ID = id;
		tableID = table;
		Itemlist = new Items[10];
		Packagelist = new Packages[5];
		StaffinCharge = s;
	}
	
	public int getID(){
		return ID;
	}
	
	public String getStaff(){
		return StaffinCharge;
	}
	
	public void setOrder(){
		int i;
		for (i=0;i<10;i++){
			Itemlist[i]= new Items();
		}
		
		for (i=0;i<5;i++){
			Packagelist[i]= new Packages();
		}
	}
	
	public void AddItem(Items it){
		int i;
		for (i=0; i<10; i++){
			if(Itemlist[i].getName().equals("NIL")){
				Itemlist[i] = it;
				return;
			}
		}
		System.out.println("Error, too many items");
		return;
	}
	
	public void AddItem(Packages it){
		int i;
		for (i=0; i<5; i++){
			if(Packagelist[i].getName().equals("NIL")){
				Packagelist[i] = it;
				return;
			}
		}
		System.out.println("Error, too many packages");
		return;
	}
	
	public void RemoveItem(Items it){
		int i;
		String name = it.getName();
		for (i=0; i<10; i++){
			if(Itemlist[i].getName().equals(name)){
				Itemlist[i].clearItem();
				return;
			}
		}
		System.out.println("Item not found");
		return;
	}
	
	public void RemoveItem(Packages it){
		int i;
		String name = it.getName();
		for (i=0; i<5; i++){
			if(Packagelist[i].getName().equals(name)){
				Packagelist[i].clearItem();
				return;
			}
		}
		System.out.println("Item not found");
		return;
	}
	
	public void PrintOrder(){
		int i;
		for (i=0; i<10; i++){
			if(Itemlist[i].getName().equals("NIL") == false){
				System.out.println(Itemlist[i].getName() + "   " + Itemlist[i].getPrice());
				
			}
		}
		
		for (i=0; i<5; i++){
			if(Packagelist[i].getName().equals("NIL") == false){
				System.out.println(Packagelist[i].getName() + "   " + Packagelist[i].getPrice());
				
			}
			
			
		}
		

		
		System.out.println("Staff: " + StaffinCharge);
	}
	
	public double calculatePrice(){
		int i;
		double total = 0;
		for (i=0; i<10; i++){
			if(Itemlist[i].getName().equals("NIL") == false){
				total += Itemlist[i].getPrice();

			}
		}
		
		for (i=0; i<5; i++){
			if(Packagelist[i].getName().equals("NIL") == false){
				total += Packagelist[i].getPrice();

			}
		}
		
		return total;
	}
	
	public void removeOrder(){
		int i;
		ID = 0;
		tableID = 0;
		for (i=0;i<10;i++){
			Itemlist[i] = new Items();
		}
		for (i=0;i<5;i++){
			Packagelist[i] = new Packages();
		}
		StaffinCharge = "NIL";
	}
	
	public Items[] returnItemsList(){
		return Itemlist;
	}
	
	public Packages[] returnPackageList(){
		return Packagelist;
	}

	

}
