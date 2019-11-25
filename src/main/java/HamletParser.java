import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

//    public Boolean findHoratio() {
//        Pattern pHamlet = Pattern.compile("Horatio");
//        Matcher mHoratio = pHamlet.matcher(hamletData);
//        return mHoratio.find();
//    }

    public Boolean findHoratio() {
        Pattern pHamlet = Pattern.compile("horatio", Pattern.CASE_INSENSITIVE);
        Matcher mHoratio = pHamlet.matcher(hamletData);
        return mHoratio.find();
        // 128: HORATIO
        //  31: Horatio
        // 159: Total occurrences
    }

    public Boolean findHamlet() {
        Pattern pHamlet = Pattern.compile("Hamlet", Pattern.CASE_INSENSITIVE);
        Matcher mHamlet = pHamlet.matcher(hamletData);
        return mHamlet.find();
    }

    public String changeHoratioToTariq() {
        String text = hamletData;
        Pattern pHoratio1 = Pattern.compile("horatio", Pattern.CASE_INSENSITIVE);
        Matcher mHoratio1 = pHoratio1.matcher(text);
        return mHoratio1.replaceAll("Tariq");


    }

    public String changeHamletToLeon() {
        String text = hamletData;
        Pattern pHamlet = Pattern.compile("hamlet\\S*", Pattern.CASE_INSENSITIVE);
        Matcher mHamlet = pHamlet.matcher(text);
        return mHamlet.replaceAll("Leon");
    }

}
