package Restaurant;

public class Reservation {
	int ID;
	int tableID;
	int noOfPeople;
	String period;
	double arrivalTime;

	
	Reservation(int id, int tid, int ppl, String ampm, double time){
		ID = id;
		tableID = tid;
		noOfPeople = ppl;
		period = ampm;
		arrivalTime = time;
	}
	
	
	
	

}
