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
        expected.add("some-thing.html");
        ArrayList<String> output = new ArrayList<String>();
        output = MarkdownParse.getLinks(content);
        assertEquals(expected.toArray(), output.toArray());
    }

    @Test
    public void labreport4test1() throws IOException{
        String content = Files.readString(Path.of("labre4test1.md"));
        List<String> expected = List.of("'google.com", "google.com", "ucsd.edu");
        assertEquals(expected, MarkdownParse.getLinks(content));
    }

    @Test
    public void labreport4test2() throws IOException{
        String content = Files.readString(Path.of("labre4test2.md"));
        List<String> expected = List.of("a.com","a.com(())","example.com");
        assertEquals(expected, MarkdownParse.getLinks(content));
    }

    @Test
    public void labreport4test3() throws IOException{
        String content = Files.readString(Path.of("labre4test3.md"));
        List<String> expected = List.of("https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule");
        assertEquals(expected, MarkdownParse.getLinks(content));
    }

}

