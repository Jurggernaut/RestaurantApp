package Restaurant;

public class MonthlySale {
	String Item;
	int number;
	double profit;
	
	MonthlySale(){
		Item = "NIL";
		number = 0;
		profit = 0;
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
