import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Pattern;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testGetHamletData() {
        String actualText = hamletParser.getHamletData();
        String expectedText = this.hamletText;
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void testChangeHamletToLeon() {

        String changedFile = hamletParser.changeHamletToLeon();
        Assert.assertFalse(changedFile.contains("Hamlet"));
    }

    @Test
    public void testChangeHoratioToTariq() {
        String changedFile = hamletParser.changeHoratioToTariq();
        Assert.assertFalse(changedFile.contains("Horatio"));
    }

    @Test
    public void testFindHoratio() {
        Assert.assertTrue(hamletParser.findHoratio());
        Assert.assertFalse(Pattern.matches("Horatio","Hamlet Hamlet Hamlet" ));
    }

    @Test
    public void testFindHamlet() {
        Assert.assertTrue(hamletParser.findHamlet());
        Assert.assertFalse(Pattern.matches("Hamlet","Horatio Horatio Horatio" ));
    }
}