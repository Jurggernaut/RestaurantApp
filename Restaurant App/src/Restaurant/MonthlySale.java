package Restaurant;

public class MonthlySale implements java.io.Serializable{
	private String Item;
	private int number;
	private double profit;
	
	MonthlySale(){
		Item = "NIL";
		number = 0;
		profit = 0;
	}
	
	MonthlySale(String s, int i, double j){
		Item = s;
		number = i;
		profit = j;
	}
	

	public String getItem(){
		return Item;
	}
	
	public double getProfit(){
		return profit;
	}

	
	public void addOne(double p){
		number += 1;
		profit += p;
	}
	
	public void addOnePack(){
		number += 1;
	}
	

	
	public void printData(){
		System.out.println("Number of " + Item + " : " + number + " with total profit of " + profit);
	}
	

}
