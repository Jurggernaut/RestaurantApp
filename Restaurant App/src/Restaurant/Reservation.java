package Restaurant;
import java.util.*;
import java.text.*;

public class Reservation implements java.io.Serializable{
	int ID;
	int tableID;
	Calendar date;
	
	Reservation(){
		ID = 0;
		tableID = 0;
		date = new GregorianCalendar(0,0,0,0,00);
	}

	
	Reservation(int id, int tid, Calendar d){
		ID = id;
		tableID = tid;
		date = d;
}
	public void clearReservation(){
		ID = 0;
		tableID = 0;
		date = new GregorianCalendar(0, 0, 0, 0 ,00);
	}
	
	public void printReservation(){
		System.out.println("ID = " + ID);
		System.out.println("TableID = " + tableID);
		Date printout = date.getTime();
		SimpleDateFormat format1 = new SimpleDateFormat("y-M-d 'at' h:m");
		String date1 = format1.format(printout); 
	    System.out.println("Format 1:   " + date1);
	}
	

	
	public boolean checkTime() {
		Calendar now = Calendar.getInstance();
		date.add(Calendar.MINUTE, 30);
		now.add(Calendar.MONTH, 1);
		date.add(Calendar.MONTH, 2);
		if (date.compareTo(now) >= 0) {
			//Current time is before or exactly at the arrival time + 30 minutes.
			return true;
		}
		else {
			// party is more than 30 minutes late, cancel reservation
			return false;
}
	
		
	}
	
	public int getTableID(){
		return tableID;
	}
	
	public boolean checkTable() {
        Calendar now = Calendar.getInstance();
        now.add(Calendar.MONTH, 1);
        date.add(Calendar.MONTH, 2);
        date.add(Calendar.HOUR, -2);

        if (date.compareTo(now) >= 0) {
            return true;
        }
        date.add(Calendar.MINUTE, 150);
        if (date.compareTo(now) >= 0){
            return true;
        }
        else {
            return false;
        }

    }

	public boolean checkDays(int days, Calendar object) {
		Calendar now = Calendar.getInstance();
		now.add(Calendar.DAY_OF_MONTH, -days);
		if (object.compareTo(now) >= 0) {
			return true;
		}
		else {
			return false;
		}
	}
	

}