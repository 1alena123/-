import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadingFrom  {

    public static ArrayList<String> read(File file, ArrayList<String> towns)  {
        try {
            final BufferedReader in = new BufferedReader(new FileReader(file));
            for (String city; (city = in.readLine()) != null; ) {
                towns.add(city);
            }
            in.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return towns;
    }
}

