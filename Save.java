import pets.*;
import pkg.*;
import java.io.*;
import java.util.*;
/**
 * Custom {@link java.io.File} for easier use when writing and accessing a save
 * How a save is formatted:
 * 0: pet0
 * 1-9: pet0 data
 * 10: pet1
 * 11-19: pet1 data
 * . . .
 * Maybe implement basic checks to prevent data modification
 */
public class Save {
    private File saveFile;
    public Save(String path) {
        saveFile = new File(path);
    }
    public File getFile() {
        return saveFile;
    }
    public void writeSave(ArrayList<String> args, int petNumber) {

    }
}
