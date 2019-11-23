import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser() {
        this.hamletData = loadFile();
    }

    private String loadFile() {
//        ClassLoader classLoader = getClass().getClassLoader();
//        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        File file = new File("/Users/kievina/Dev/Wk5 Labs/Maven.Regex-Hamlet-Parser/src/main/resources/hamlet.txt");

        StringBuilder result = new StringBuilder("");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }
            scanner.close();
        } catch (IOException e) {
//        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    // replace every instance of "Hamlet" with "Leon" and every instance of Horatio with "Tariq"

    public String getHamletData() {
        return hamletData;
    }

    public Boolean findHoratio() {
        Pattern pHamlet = Pattern.compile("Horatio");
        Matcher mHoratio = pHamlet.matcher(hamletData);
        return mHoratio.find();
    }

    public Boolean findHamlet() {
        Pattern pHamlet = Pattern.compile("Hamlet");
        Matcher mHamlet = pHamlet.matcher(hamletData);
        return mHamlet.find();
    }

    public String changeHoratioToTariq() {
        Pattern pHamlet = Pattern.compile("Horatio");
        Matcher mHoratio = pHamlet.matcher(hamletData);
        return mHoratio.replaceAll("Tariq");
    }

    public String changeHamletToLeon() {
        Pattern pHamlet = Pattern.compile("Hamlet");
        Matcher mHamlet = pHamlet.matcher(hamletData);
        return mHamlet.replaceAll("Leon");
    }

}
