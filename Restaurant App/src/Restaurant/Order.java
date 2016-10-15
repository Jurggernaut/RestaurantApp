package Restaurant;

public class Order {
	int ID;
	Items[] Itemlist;
	Packages[] Packagelist;
	int i;
	
	Order(int id){
		ID = id;
		Itemlist = new Items[10];
		Packagelist = new Packages[5];
	}
	
	public void AddItem(Items it){
		for (i=0; i<10; i++){
			if(Itemlist[i].Name == "NIL" || Itemlist[i] == null){
				Itemlist[i] = it;
				return;
			}
		}
		System.out.println("Error, too many items");
		return;
	}
	
	public void AddItem(Packages it){
		for (i=0; i<5; i++){
			if(Packagelist[i].Name == "NIL" || Packagelist[i] == null){
				Packagelist[i] = it;
				return;
			}
		}
		System.out.println("Error, too many packages");
		return;
	}
	
	public void RemoveItem(Items it){
		for (i=0; i<10; i++){
			if(Itemlist[i] == it){
				Itemlist[i].clearItem();
				return;
			}
		}
		System.out.println("Item not found");
		return;
	}
	
	public void RemoveItem(Packages it){
		for (i=0; i<5; i++){
			if(Packagelist[i] == it){
				Packagelist[i].clearItem();
				return;
			}
		}
		System.out.println("Item not found");
		return;
	}
	
	public void PrintOrder(){
		for (i=0; i<10; i++){
			if(Itemlist[i].Name != "NIL" && Itemlist[i] != null){
				System.out.println(Itemlist[i].Name + "   " + Itemlist[i].Price);
				return;
			}
		}
		
		for (i=0; i<5; i++){
			if(Packagelist[i].Name != "NIL" && Packagelist[i] != null){
				System.out.println(Packagelist[i].Name + "   " + Packagelist[i].newPrice);
				return;
			}
		}
	}
	
	public double calculatePrice(){
		double total = 0;
		for (i=0; i<10; i++){
			if(Itemlist[i].Name != "NIL" && Itemlist[i] != null){
				total += Itemlist[i].Price;

			}
		}
		
		for (i=0; i<5; i++){
			if(Packagelist[i].Name != "NIL" && Packagelist[i] != null){
				total += Packagelist[i].Price;

			}
		}
		
		return total;
	}
	

	

}
