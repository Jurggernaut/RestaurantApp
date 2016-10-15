package Restaurant;

public class Packages extends Items {
	double newPrice;
	
	Packages(){
		super();
		newPrice = 0.0;
	}
	
	Packages(String x, double p, double np){
		super(x,p);
		newPrice = np;
	}
	
	Packages(String x, String d, double p,double np ){
		super(x,d, "Package", p);
		newPrice = np;
	}
	
	public void changeNewPrice(double np){
		newPrice = np;
	}
	
	public void clearItem(){
		Name = " NIL ";
		Description = " NIL ";
		Price = 0.0;
		newPrice = 0.0;
	}
	
	public void printItem(){
		super.printItem();
		System.out.println("New Price: " + newPrice);
	}
}
