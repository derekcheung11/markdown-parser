import static org.junit.Assert.*; //import junit assert
import org.junit.*; //import junit
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
public class MarkdownParseTest { //class for test method
    @Test
    public void addition() { //method
        assertEquals(2, 1 + 1); //asserts that two arrays are equal.
    }

    @Test
    public void getLinks() throws IOException {
        ArrayList<String> expected = new ArrayList<String>();
        Path filePath = Path.of("test-file.md");
        String content = Files.readString(filePath);
        expected.add("https://something.com");
        expected.add("some-page.html");
        ArrayList<String> output = new ArrayList<String>();
        output = MarkdownParse.getLinks(content);
        assertEquals(expected.toArray(), output.toArray());
    }

}

