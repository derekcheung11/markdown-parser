import static org.junit.Assert.*; //import junit assert
import org.junit.*; //import junit
public class MarkdownParseTest { //class for test method
    @Test
    public void addition() { //method
        assertEquals(2, 1 + 1); //asserts that two arrays are equal.
    }

    Path filePath = Path.of("test-file.md");
    String content = Files.readString(filePath);

}

