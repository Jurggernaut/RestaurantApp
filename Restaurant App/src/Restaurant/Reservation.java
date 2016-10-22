package Restaurant;
import java.util.Calendar;

public class Reservation {
	int ID;
	int tableID;
	int noOfPeople;
	String period;
	double arrivalTime; //format 3.21
	double date; //format 18.10
	
	Reservation(){
		ID = 0;
		tableID = 0;
		noOfPeople = 0;
		period = "NIL";
		arrivalTime = 0;
		date = 0;
	}

	
	Reservation(int id, int tid, int ppl, String ampm, double time, double dt){
		ID = id;
		tableID = tid;
		noOfPeople = ppl;
		period = ampm;
		arrivalTime = time;
		date = dt;
	}
	
	public boolean checkTime(double arrivalTime) {
		Calendar cal = Calendar.getInstance();
		//To shift the clock to the next hour (because one hour has 60 minutes and not 100 minutes):
		if (arrivalTime%1 > 0.29) {
			arrivalTime = arrivalTime + 0.7;
		}
		else {
			arrivalTime = arrivalTime + 0.3;
		}
		if (arrivalTime >= (cal.get(Calendar.HOUR) + (double)cal.get(Calendar.MINUTE)/100)) {
			//Current time is before or exactly at the arrival time + 30 minutes.
			return true;
		}
		else {
			// party is more than 30 minutes late, cancel reservation
			return false; 
		}
	
		
	}
	
	public void removeReservation(){
		ID = 0;
		tableID = 0;
		noOfPeople = 0;
		period = "NIL";
		arrivalTime = 0;
		date = 0;
	}
	
	

}
