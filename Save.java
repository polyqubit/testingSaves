import pkg.*;
import java.io.*;
/**
 * Custom {@link java.io.File} for easier use when writing and accessing a save
 * How a save is formatted:
 * 0: pet0
 * 1-9: pet0 data
 * 10: pet1
 * 11-19: pet1 data
 * . . . continues until pet9
 * Maybe implement basic checks to prevent data modification
 */
public class Save {
    private File saveFile;
    private BufferedWriter bw = null;
    private BufferedReader br = null;
    public Save(File saveFile) {
        this.saveFile = saveFile;
    }
    public File getFile() {
        return saveFile;
    }
    public void writeSave(Pet pet, int petNumber) {
        String petData = pet.toString();
        try {
            br = new BufferedReader(new FileReader(saveFile));
            bw = new BufferedWriter(new FileWriter(saveFile));
            bw.write(petData, 0, petData.indexOf(' '));
        } catch(IOException ioe) {ioe.printStackTrace();}
        try {
            if(bw!=null)
            bw.close();
        } catch(Exception e){System.out.println("Error closing the BufferedWriter"+e);}
    }
    public void readLine(int line) {
        
    }
}
