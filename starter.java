import java.io.*;
import java.util.*;

public class starter {
	static void p(Object o) {System.out.print(o);}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		// loading/creating save
		p("Welcome to pet game\nWould you like to load a save or create a new one? (LOAD / NEW)\n");
		String mode = "";
		while(!mode.equals("")) {
			if(sc.nextLine().equals("NEW")) {
				mode = "NEW";
				p("Which slot would you like to create a new file in?\n");
				for(int i=1;i<=5;i++) {
					File f = new File("saves\\save"+i+".txt");
					String nullcheck = f.exists() ? f.getName() : "EMPTY";
					p("SAVE "+i+":  "+nullcheck+"\n");
				}
				int slotNum = -1;
				while(slotNum==-1) {
					try {
						slotNum = sc.nextInt();
						sc.nextLine();
						if((slotNum<1)||(slotNum>5)) {
							p("Invalid input, only numbers 1-5 allowed\n");
							slotNum = -1;
						}
					}
					catch(InputMismatchException ime) {
						p("Invalid input, only numbers 1-5 allowed\n");
						sc.nextLine();
					}
				}
				try {
					File save = new File("saves\\save"+slotNum+".txt");
					if (save.createNewFile()) {
						p("File created: " + save.getName()+"\n");
					} else {
						p("A save already exists. Would you like to overwrite it? (Y/N)\n");
						if(sc.nextLine().equals("Y")) {
							save.delete();
							save.createNewFile();
						}
					}
				} catch (IOException e) {
					System.out.println("An error occurred while accessing the file.");
					e.printStackTrace();
				}
			}
			else if(sc.nextLine().equals("LOAD")) {
				mode = "LOAD";
			}
			else {p("Invalid input, please enter LOAD or NEW\n");}
		}
		// main game loop:
		while(true) {
			if(sc.nextLine().equals("QUIT")) {break;}
		}
		sc.close();
	}
}
