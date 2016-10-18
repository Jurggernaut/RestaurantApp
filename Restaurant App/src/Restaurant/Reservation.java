package Restaurant;

public class Reservation {
	int ID;
	int tableID;
	int noOfPeople;
	String period;
	double arrivalTime;

	
	Reservation(int id, int tid, int ppl, String ap, double time){
		ID = id;
		tableID = tid;
		noOfPeople = ppl;
		period = ap;
		arrivalTime = time;
	}
	

}
