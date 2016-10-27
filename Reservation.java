package Restaurant;
import java.text.*; //Ignore warning, import is necessary
import java.util.*;

public class Reservation {
	int ID;
	int tableID;
	int noOfPeople;
	Calendar date;

	
	Reservation(int id, int tid, int ppl, Calendar d){
		ID = id;
		tableID = tid;
		noOfPeople = ppl;
		date = d;
	}
	
	public boolean checkTime(Calendar res) {
		Calendar now = Calendar.getInstance();
		res.add(Calendar.MINUTE, 30);
		now.add(Calendar.MONTH, 1);
		res.add(Calendar.MONTH, 2);
		if (res.compareTo(now) >= 0) {
			//Current time is before or exactly at the arrival time + 30 minutes.
			return true;
		}
		else {
			// party is more than 30 minutes late, cancel reservation
			return false;
		}
		
	}
	
	public boolean checkTable(Calendar res) {
        Calendar now = Calendar.getInstance();
        now.add(Calendar.MONTH, 1);
        res.add(Calendar.MONTH, 2);
        res.add(Calendar.HOUR, -2);

        if (res.compareTo(now) >= 0) {
            return true;
        }
        res.add(Calendar.MINUTE, 150);
        if (res.compareTo(now) >= 0){
            return true;
        }
        else {
            return false;
        }

    }

}