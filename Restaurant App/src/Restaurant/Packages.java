package Restaurant;

public class Packages extends Items implements java.io.Serializable{
	double newPrice;
	Items[] Itemlist;
	
	Packages(){
		super();
		newPrice = 0.0;
		Itemlist = new Items[11];
	}
	
	
	Packages(String x, String d, double p,double np ){
		super(x,d, "Package", p);
		newPrice = np;
		Itemlist = new Items[11];
	}
	
	public void setPackages(){
		for (int i = 0; i<10; i++){
			Itemlist[i] = new Items();
		}
	}
	
	public void addItem(Items it){
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
	
	public void changeNewPrice(double np){
		newPrice = np;
	}
	
	public void changePrices(double p, double np){
		super.changePrice(p);
		newPrice = np;
	}
	
	public void clearItem(){
		Name = "NIL";
		Description = "NIL";
		Price = 0.0;
		newPrice = 0.0;
	}
	
	public void printItem(){
		super.printItem();
		System.out.println("New Price: " + newPrice);
	}
}
