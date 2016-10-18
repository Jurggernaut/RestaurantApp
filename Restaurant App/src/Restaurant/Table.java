package Restaurant;

public class Table {
	int ID;
	boolean occupied;
	int seatingCapacity;
	
	Table(int id, int c){
		ID = id;
		occupied = false;
		seatingCapacity = c;
	}
	
	public void isOccupied(){
		occupied = true;
	}
	
	public void isFree(){
		occupied = false;
	}
	
	
}
