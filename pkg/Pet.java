package pkg;

public interface Pet {
    public void setName(String name);       	// Sets name of the pet
    public void setAge(int age);            	// Sets age of the pet
    public void teach(String teachThis);        // Teaches the pet a trick
    public String getName();                	// Returns name of the pet
    public int getAge();                    	// Returns age of the pet
    public void interact();                 	// This is like bark or meow, say pet name and what they do!
	public void trick();						// The pet performs a trick if the pet is trained. If not, the pet just acts normal.
    public String toString();                   // Returns the type of animal this Pet is
}