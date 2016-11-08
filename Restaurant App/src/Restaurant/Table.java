package Restaurant;

public class Table {
	private int ID;
	private boolean occupied;
	private int seatingCapacity;
	
	Table(int id, int c){
		ID = id;
		occupied = false;
		seatingCapacity = c;
	}
	
	public int getID(){
		return ID;
	}
	
	public boolean getOccupied(){
		return occupied;
	}
	
	public void isOccupied(){
		occupied = true;
	}
	
	public void isFree(){
		occupied = false;
	}
	
	public void printDetails(){
		System.out.println(ID + " is free with seating capacity of " + seatingCapacity);
	}
	
	
}
