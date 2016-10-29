package Restaurant;

public class Items implements java.io.Serializable{
	String Name;
	String Description;
	String Type;
	double Price;
	
	Items(){
		Name = "NIL";
		Description = "NIL";
		Type = "NIL";
		Price = 0.0;
	}
	
	Items(String x, double p){
		Name = x;
		Description = "NIL";
		Type = "NIL";
		Price = p;
	}
	
	Items(String x, String d, String t, double p){
		Name = x;
		Description = d;
		Type = t;
		Price = p;
	}
	
	public String getName(){
		return Name;
	}
	
	public void changeDescription(String d){
		Description = d;
	}
	
	public void changeType(String t){
		Type = t;
	}
	
	public void changePrice(double p){
		Price = p;
	}
	
	public void clearItem(){
		Name = "NIL";
		Description = "NIL";
		Type = "NIL";
		Price = 0.0;
	}
	
	public void printItem(){
		System.out.println("Name: " + Name);
		System.out.println("Description: " + Description);
		System.out.println("Type: " + Type);
		System.out.println("Price: " + Price);
	}
}
