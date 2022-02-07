import java.io.*;
import java.util.*;
import pets.*;
import pkg.*;

public class starter {
	static void p(Object o) {System.out.print(o);}
	static Pet getPet(String animal) {
        switch(animal.toLowerCase()) {
            case "fish":
                return new Fish();
            case "snake":
            break;
            case "bird":
            break;
        }
        return null;
    } 
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Save game;
		int slotNum = -1;
		boolean safeToContinue = false;
		// loading/creating save
		p("PET GAME\nWould you like to load a save or create a new one? (LOAD / NEW)\n");
		String mode = "";
		while(mode.equals("")) {
			// NEW game save
			mode = sc.nextLine();
			if(mode.equals("NEW")) {
				mode = "NEW";
				p("Which slot would you like to create a new file in?\n");
				for(int i=1;i<=5;i++) {
					File f = new File("saves\\save"+i+".txt");
					String nullcheck = f.exists() ? f.getName() : "EMPTY";
					p("SAVE "+i+":  "+nullcheck+"\n");
				}
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
				while(!safeToContinue) {
					try {
						File save = new File("saves\\save"+slotNum+".txt");
						if (save.createNewFile()) {
							p("File created: " + save.getName()+"\n");
						} else {
							p("A save already exists. Would you like to overwrite it? (Y/N)\n");
							if(sc.nextLine().equals("Y")) {
								save.delete();
								save.createNewFile();
								game = new Save(save); // yes yes all the saves are not confusing at all
							}
						}
						safeToContinue = true;
					} catch (IOException e) {
						p("An error occurred while generating the file.\n");
						e.printStackTrace();
					}
				}
			}
			// LOAD game save
			else if(mode.equals("LOAD")) {
				mode = "LOAD";
			}
			// wrong input
			else {p("Invalid input, please enter LOAD or NEW\n");}
		}
		// new pet
		if(mode.equals("NEW")) {
			p("Welcome to the pet store. Which animal would you like to adopt?\nAvailable animals:\n");
			for(File f : new File("pets").listFiles()) {
				int period = f.getName().indexOf('.');
				if(!f.getName().substring(period).equals(".class")) {
					p(f.getName().substring(0,period)+" ");
				}
			}
			p("\n");
			Pet firstPet = null;
			while(true) {
				firstPet = getPet(sc.nextLine());
				if(firstPet!=null) {break;}
				p("We don't have that here...\n");
			}
			p(firstPet.toString()+"\n");
			// initialize save:
		}	
		// main game loop:
		while(true) {
			p("say QUIT\n");
			if(sc.nextLine().equals("QUIT")) {break;}
		}
		sc.close();
	}
}
