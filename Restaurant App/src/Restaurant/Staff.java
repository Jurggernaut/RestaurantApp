package Restaurant;

public class Staff {
	int ID;
	String Name;
	String Gender;
	String Title;
	
	Staff(){
		ID = 0;
		Name = "NIL";
		Gender = "NIL";
		Title = "NIL";
	}
	
	Staff(int id, String n, String g, String t){
		ID = id;
		Name = n;
		Gender = g;
		Title = t;
	}
	
	public void changeTitle(String t){
		Title = t;
	}
	
	public void printStaff(){
		System.out.println("ID: " + ID);
		System.out.println("Name: " + Name);
		System.out.println("Gender: " + Gender);
		System.out.println("Title: " + Title);
	}
	
}
