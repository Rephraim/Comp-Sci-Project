import java.util.*;

public class Main {

	static Scanner console=  new Scanner(System.in);
	static ArrayList<Event> events = new ArrayList<Event>;

	public static void main String(args[]){

		System.out.print("Player Name: ");
		Player player = new Player( console.next() );

	}

	public int rollDice(){
		return (int)Math.random()*6 + 1;
	}

	public void parseEvents(){
			File file = new File("InputFile.txt");
			Scanner input = new Scanner(file);


	}


}